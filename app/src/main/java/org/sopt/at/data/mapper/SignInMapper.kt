package org.sopt.at.data.mapper

import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.domain.model.SignInResultModel

fun SignInResponse.toSignInResultModel() : SignInResultModel {
    return SignInResultModel(
        userId = userId
    )
}