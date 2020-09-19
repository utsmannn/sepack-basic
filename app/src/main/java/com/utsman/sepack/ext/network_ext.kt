package com.utsman.sepack.ext

import com.utsman.sepack.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun <T: Any> data(call: suspend () -> T): Flow<Result<T>> = flow {
    emit(Result.Loading())
    try {
        val data = call.invoke()
        emit(Result.Success(data))
    } catch (e: Throwable) {
        emit(Result.Error(th = e))
    }
}