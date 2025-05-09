package org.sopt.at.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponse(
    @SerialName("userId")
    val userId: Long,
    @SerialName("nickname")
    val nickname: String
)