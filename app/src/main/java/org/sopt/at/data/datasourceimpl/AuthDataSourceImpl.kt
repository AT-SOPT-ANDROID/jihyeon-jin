package org.sopt.at.data.datasourceimpl

import org.sopt.at.data.datasource.AuthDataSource
import org.sopt.at.data.datasource.UserDataSource
import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.MyNicknameRequest
import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.dto.response.MyNicknameResponse
import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.data.dto.response.SignUpResponse
import org.sopt.at.data.service.AuthService
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {
    override suspend fun postSignUp(request: SignUpRequest): BaseResponse<SignUpResponse> =
        authService.postSignUp(request)

    override suspend fun postSignIn(request: SignInRequest): BaseResponse<SignInResponse> =
        authService.postSignIn(request)

}