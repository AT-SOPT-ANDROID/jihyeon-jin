package org.sopt.at.data.mapper

import org.sopt.at.data.dto.response.SignUpResponse
import org.sopt.at.domain.model.SignUpResultModel


fun SignUpResponse.toSignUpResultModel() : SignUpResultModel {
    return SignUpResultModel(
        userId = userId,
        nickname = nickname
    )
}