package app.talia.networking.structure

sealed interface NetworkResponse<T> {
    data object NullBody : NetworkResponse<Nothing>
    data class Body<T>(val response: T) : NetworkResponse<T>
}
