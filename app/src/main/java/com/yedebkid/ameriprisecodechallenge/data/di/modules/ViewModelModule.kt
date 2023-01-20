package com.yedebkid.ameriprisecodechallenge.data.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yedebkid.ameriprisecodechallenge.data.di.ViewModelKey
import com.yedebkid.ameriprisecodechallenge.ui.HomeViewModel
import com.yedebkid.ameriprisecodechallenge.ui.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeFragmentViewModel(homeFragmentViewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}