package com.utsman.sepack.ext

import com.utsman.sepack.domain.Result
import kotlinx.coroutines.flow.MutableStateFlow

// default value of StateFlow from repository
fun <T: Any>stateOf(): MutableStateFlow<Result<T>> = run {
    MutableStateFlow(Result.Idle())
}

