package org.sopt.at.data.datasource

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.MyNicknameRequest
import org.sopt.at.data.dto.response.MyNicknameResponse

interface UserDataSource {
    suspend fun getMyNickname(request: MyNicknameRequest) : BaseResponse<MyNicknameResponse>
}