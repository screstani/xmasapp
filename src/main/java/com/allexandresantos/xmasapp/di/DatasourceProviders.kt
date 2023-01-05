package com.allexandresantos.xmasapp.di

import com.allexandresantos.xmasapp.datasource.OrderDataSource
import com.allexandresantos.xmasapp.datasource.OrderDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourceProviders {

    @Provides
    @Singleton
    fun provideOrderDataSource(): OrderDataSource = OrderDataSourceImpl()
}