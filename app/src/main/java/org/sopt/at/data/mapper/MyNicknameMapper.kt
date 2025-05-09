package org.sopt.at.data.mapper

import org.sopt.at.data.dto.request.MyNicknameRequest
import org.sopt.at.data.dto.response.MyNicknameResponse
import org.sopt.at.domain.model.MyNicknameModel
import org.sopt.at.domain.model.MyNicknameResultModel

fun MyNicknameModel.toNicknameCheckRequest(): MyNicknameRequest {
    return MyNicknameRequest(
        userId = userId
    )
}

fun MyNicknameResponse.toNicknameCheckResultModel() : MyNicknameResultModel {
    return MyNicknameResultModel(
        nickname = nickname
    )
}