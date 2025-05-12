package org.sopt.at.data.datasource

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.ChangeNicknameRequest
import org.sopt.at.data.dto.request.MyNicknameRequest
import org.sopt.at.data.dto.response.MyNicknameResponse
import org.sopt.at.data.dto.response.SearchUserResponse

interface UserDataSource {
    suspend fun getMyNickname(request: MyNicknameRequest) : BaseResponse<MyNicknameResponse>
    suspend fun getUserList(request: String) : BaseResponse<SearchUserResponse>
    suspend fun patchNickname(request: ChangeNicknameRequest) : BaseResponse<Unit>
}