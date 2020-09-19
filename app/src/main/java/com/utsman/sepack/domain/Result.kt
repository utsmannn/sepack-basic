package com.utsman.sepack.domain

sealed class Result<T: Any>(val payload: T? = null, val throwable: Throwable? = null, message: String? = "") {
    class Loading<T: Any> : Result<T>()
    data class Idle<T: Any>(val msg: String = ""): Result<T>(message = msg)
    data class Success<T: Any>(val data: T) : Result<T>(payload = data)
    data class Error<T: Any>(val th: Throwable) : Result<T>(throwable = th)
}