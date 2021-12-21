package com.codingwithmitch.food2forkcompose.di

import com.codingwithmitch.food2forkcompose.interactors.voting_list.UpdateList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {


    @ViewModelScoped
    @Provides
    fun provideUpdateList(

    ): UpdateList {
        return UpdateList(

        )
    }



}