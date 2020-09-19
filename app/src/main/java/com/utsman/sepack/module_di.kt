package com.utsman.sepack

import com.utsman.sepack.data.network.Service
import com.utsman.sepack.repository.MainRepository
import com.utsman.sepack.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin module instance
 * doc: {@link 'https://medium.com/koin-developers/unboxing-koin-2-1-7f1133ebb790' }
 */

val repository = module {
    single { Service.create() }
    single { MainRepository(get()) }
}

val viewModel = module {
    viewModel { MainViewModel(get()) }
}