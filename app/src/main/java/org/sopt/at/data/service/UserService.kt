package org.sopt.at.data.service

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.response.MyNicknameResponse
import org.sopt.at.data.dto.response.SearchUserResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UserService {
    @GET("/api/v1/users/me")
    suspend fun getUserNickname(
        @Header("userId") userId: Long
    ): BaseResponse<MyNicknameResponse>

    @GET("/api/v1/users")
    suspend fun getUserList(
        @Query("keyword") keyword: String
    ): BaseResponse<SearchUserResponse>
}