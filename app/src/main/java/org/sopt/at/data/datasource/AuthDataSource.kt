package org.sopt.at.data.datasource

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.data.dto.response.SignUpResponse

interface AuthDataSource {
    suspend fun postSignUp(request: SignUpRequest): BaseResponse<SignUpResponse>
    suspend fun postSignIn(request: SignInRequest): BaseResponse<SignInResponse>

}