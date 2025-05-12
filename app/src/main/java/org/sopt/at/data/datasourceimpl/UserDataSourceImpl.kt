package org.sopt.at.data.datasourceimpl

import org.sopt.at.data.datasource.UserDataSource
import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.ChangeNicknameRequest
import org.sopt.at.data.dto.request.MyNicknameRequest
import org.sopt.at.data.dto.response.MyNicknameResponse
import org.sopt.at.data.dto.response.SearchUserResponse
import org.sopt.at.data.service.UserService
import javax.inject.Inject

class UserDataSourceImpl  @Inject constructor(
    private val userService: UserService
) : UserDataSource {
    override suspend fun getMyNickname(request: MyNicknameRequest): BaseResponse<MyNicknameResponse> =
        userService.getUserNickname(request.userId)

    override suspend fun getUserList(request: String): BaseResponse<SearchUserResponse> =
        userService.getUserList(request)

    override suspend fun patchNickname(request: ChangeNicknameRequest) : BaseResponse<Unit> =
        userService.patchNickname(request.userId, request.nickname)

}