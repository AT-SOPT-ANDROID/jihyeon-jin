package org.sopt.at.data.mapper

import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.dto.response.SignUpResponse
import org.sopt.at.domain.model.SignUpModel
import org.sopt.at.domain.model.SignUpResultModel

fun SignUpModel.toSignUpRequest(): SignUpRequest {
    return SignUpRequest(
        loginId = loginId,
        password = password,
        nickname = nickname
    )
}

fun SignUpResponse.toSignUpResultModel() : SignUpResultModel {
    return SignUpResultModel(
        userId = userId,
        nickname = nickname
    )
}