package com.utsman.sepack.repository

import com.utsman.sepack.data.model.Reqres
import com.utsman.sepack.data.network.Routes
import com.utsman.sepack.ext.data
import com.utsman.sepack.ext.stateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainRepository(private val routes: Routes) {

    val scope = CoroutineScope(Dispatchers.Default)
    val user = stateOf<List<Reqres.User>>()

    suspend fun users(): Job = scope.launch {
        data {
            routes.user().data
        }.collect {
            user.value = it
        }
    }
}