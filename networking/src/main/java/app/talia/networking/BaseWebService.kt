package app.talia.networking

import app.talia.networking.structure.NetworkError
import app.talia.networking.structure.NetworkResponse
import arrow.core.Either
import retrofit2.Response

/**
 * This is the base web service provides the underlying structure for all networking services
 */
abstract class BaseWebService {

    protected suspend fun <T : Any> networkCall(
        call: suspend () -> Response<T>,
    ): Either<NetworkError, NetworkResponse<T>> {
        return try {
            val response = call()
            val body = response.body()

            if (response.isSuccessful) {
                if (body != null) {
                    Either.Right(NetworkResponse.Body(response = body))
                } else {
                    @Suppress("UNCHECKED_CAST")
                    Either.Right(NetworkResponse.NullBody as NetworkResponse<T>)
                }
            } else {
                Either.Left(
                    NetworkError.ApiFailure(
                        code = response.code(),
                        message = response.message(),
                    ),
                )
            }
        } catch (e: Exception) {
            Either.Left(NetworkError.Exception(e))
        }
    }
}
