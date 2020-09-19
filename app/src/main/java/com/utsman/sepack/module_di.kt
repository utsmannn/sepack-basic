package com.utsman.sepack

import com.utsman.sepack.data.network.Service
import com.utsman.sepack.repository.MainRepository
import com.utsman.sepack.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repository = module {
    single { Service.create() }
    single { MainRepository(get()) }
}

val viewModel = module {
    viewModel { MainViewModel(get()) }
}