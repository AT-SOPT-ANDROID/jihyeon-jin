package org.sopt.at.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpResultModel(
    @SerialName("userId")
    val userId: Long,
    @SerialName("nickname")
    val nickname: String
)