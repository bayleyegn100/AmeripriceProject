package com.yedebkid.ameriprisecodechallenge.data.di.modules

import com.yedebkid.ameriprisecodechallenge.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment
}