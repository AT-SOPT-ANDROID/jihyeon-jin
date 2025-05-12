package org.sopt.at.data.repositoryimpl

import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.mapper.toSignInResultModel
import org.sopt.at.data.mapper.toSignUpResultModel
import org.sopt.at.data.service.AuthService
import org.sopt.at.domain.model.SignInModel
import org.sopt.at.domain.model.SignInResultModel
import org.sopt.at.domain.model.SignUpModel
import org.sopt.at.domain.model.SignUpResultModel
import org.sopt.at.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository {
    override suspend fun postSignUp(request: SignUpModel): Result<SignUpResultModel> =
        runCatching {
            val response = authService.postSignUp(
                request = SignUpRequest(
                    loginId = request.loginId,
                    password = request.password,
                    nickname = request.nickname
                )
            )
            response.data?.toSignUpResultModel() ?: throw Exception("Response data is null")
        }

    override suspend fun postSignIn(request: SignInModel): Result<SignInResultModel> =
        runCatching {
            val response = authService.postSignIn(
                request = SignInRequest(
                    loginId = request.loginId,
                    password = request.password
                )
            )
            response.data?.toSignInResultModel() ?: throw Exception("Response data is null")
        }
}
