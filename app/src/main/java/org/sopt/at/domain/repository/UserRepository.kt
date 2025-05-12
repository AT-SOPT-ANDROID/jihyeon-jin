package org.sopt.at.domain.repository

import org.sopt.at.domain.model.MyNicknameModel
import org.sopt.at.domain.model.MyNicknameResultModel
import org.sopt.at.domain.model.SearchUserResultModel

interface UserRepository {
    suspend fun getMyNickname(request: MyNicknameModel): Result<MyNicknameResultModel>
    suspend fun getUserList(request: String): Result<SearchUserResultModel>
}