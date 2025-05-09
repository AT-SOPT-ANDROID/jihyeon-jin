package org.sopt.at.domain.repository

import org.sopt.at.domain.model.MyNicknameModel
import org.sopt.at.domain.model.MyNicknameResultModel

interface UserRepository {
    suspend fun getMyNickname(request: MyNicknameModel): Result<MyNicknameResultModel>
}