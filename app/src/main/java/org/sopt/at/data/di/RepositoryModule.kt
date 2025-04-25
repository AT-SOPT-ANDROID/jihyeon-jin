package org.sopt.at.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.data.repositoryimpl.DummyHomeContentRepositoryImpl
import org.sopt.at.domain.repository.DummyHomeProgramRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideDummyHomeContentRepository(): DummyHomeProgramRepository {
        return DummyHomeContentRepositoryImpl()
    }
}