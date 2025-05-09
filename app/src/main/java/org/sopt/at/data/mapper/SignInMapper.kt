package org.sopt.at.data.mapper

import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.domain.model.SignInModel
import org.sopt.at.domain.model.SignInResultModel

fun SignInModel.toSignInRequest(): SignInRequest {
    return SignInRequest(
        loginId = loginId,
        password = password
    )
}

fun SignInResponse.toSignInResultModel() : SignInResultModel {
    return SignInResultModel(
        userId = userId
    )
}