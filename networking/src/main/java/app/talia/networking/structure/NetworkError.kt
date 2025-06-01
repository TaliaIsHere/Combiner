package app.talia.networking.structure

/**
 * All errors that can be returned by BaseWebService
 *
 * @see app.talia.networking.BaseWebService
 */
sealed interface NetworkError {

    /**
     * Error to represent when a network error is returned from a network call
     *
     * @param code what code the endpoint has returned typically 400-500
     * @param message what message the endpoint has returned
     */
    data class ApiFailure(
        val code: Int,
        val message: String,
    ) : NetworkError

    /**
     * Error for when an exception is returned when trying to make a network request
     *
     * @param exception the exception that was caught
     */
    data class Exception(
        val exception: kotlin.Exception,
    ) : NetworkError
}
