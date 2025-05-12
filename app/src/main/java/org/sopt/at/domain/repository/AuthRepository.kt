package org.sopt.at.domain.repository

import org.sopt.at.domain.model.SignInModel
import org.sopt.at.domain.model.SignInResultModel
import org.sopt.at.domain.model.SignUpModel
import org.sopt.at.domain.model.SignUpResultModel

interface AuthRepository {
    suspend fun postSignUp(request: SignUpModel): Result<SignUpResultModel>
    suspend fun postSignIn(request: SignInModel): Result<SignInResultModel>
}