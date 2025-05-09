package org.sopt.at.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.data.repositoryimpl.AuthRepositoryImpl
import org.sopt.at.data.repositoryimpl.DummyHomeContentRepositoryImpl
import org.sopt.at.data.repositoryimpl.UserRepositoryImpl
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.domain.repository.DummyHomeProgramRepository
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Provides
    @Singleton
    fun provideDummyHomeContentRepository(): DummyHomeProgramRepository {
        return DummyHomeContentRepositoryImpl()
    }

    @Binds
    @Singleton
    abstract fun bindsAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

}