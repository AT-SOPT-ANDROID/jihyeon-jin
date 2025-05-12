package org.sopt.at.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyNicknameRequest (
    @SerialName("userId")
    val userId : Long
)