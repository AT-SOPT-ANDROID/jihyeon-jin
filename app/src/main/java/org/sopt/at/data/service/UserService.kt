package org.sopt.at.data.service

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.response.MyNicknameResponse
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {
    @POST("/api/v1/users/me")
    suspend fun getUserNickname(
        @Header("userId") userId: Long
    ): BaseResponse<MyNicknameResponse>
}