package org.sopt.at.data.mapper

import org.sopt.at.data.dto.response.MyNicknameResponse
import org.sopt.at.domain.model.MyNicknameResultModel

fun MyNicknameResponse.toNicknameCheckResultModel() : MyNicknameResultModel {
    return MyNicknameResultModel(
        nickname = nickname
    )
}