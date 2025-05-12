package org.sopt.at.data.repositoryimpl

import org.sopt.at.data.mapper.toNicknameCheckResultModel
import org.sopt.at.data.mapper.toSearchUserResultModel
import org.sopt.at.data.service.UserService
import org.sopt.at.domain.model.MyNicknameModel
import org.sopt.at.domain.model.MyNicknameResultModel
import org.sopt.at.domain.model.SearchUserResultModel
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {
    override suspend fun getMyNickname(request: MyNicknameModel): Result<MyNicknameResultModel> =
        runCatching {
            val response = userService.getUserNickname(
                userId = request.userId
            )
            response.data?.toNicknameCheckResultModel() ?: throw Exception("Response data is null")
        }

    override suspend fun getUserList(request: String): Result<SearchUserResultModel> =
        runCatching {
            val response = userService.getUserList(
                keyword = request
            )
            response.data?.toSearchUserResultModel() ?: throw Exception("Response data is null")
        }
}
