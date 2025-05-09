package org.sopt.at.data.repositoryimpl

import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.mapper.toNicknameCheckResultModel
import org.sopt.at.data.mapper.toSignInResultModel
import org.sopt.at.data.mapper.toSignUpResultModel
import org.sopt.at.data.service.UserService
import org.sopt.at.domain.model.MyNicknameModel
import org.sopt.at.domain.model.MyNicknameResultModel
import org.sopt.at.domain.model.SignInModel
import org.sopt.at.domain.model.SignInResultModel
import org.sopt.at.domain.model.SignUpModel
import org.sopt.at.domain.model.SignUpResultModel
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
}
