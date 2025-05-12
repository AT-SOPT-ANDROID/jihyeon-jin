package org.sopt.at.data.service

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.data.dto.response.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/v1/auth/signup")
    suspend fun postSignUp(
        @Body request: SignUpRequest
    ): BaseResponse<SignUpResponse>

    @POST("/api/v1/auth/signin")
    suspend fun postSignIn(
        @Body request: SignInRequest
    ): BaseResponse<SignInResponse>
}