package com.allexandresantos.xmasapp.di

import com.allexandresantos.xmasapp.orderrepository.OrderRepository
import com.allexandresantos.xmasapp.orderrepository.OrderRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {
    @Binds
    @Singleton
    abstract fun bindsOrderRepository(repository: OrderRepositoryImpl): OrderRepository
}