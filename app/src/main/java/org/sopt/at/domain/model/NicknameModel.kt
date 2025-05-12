package org.sopt.at.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NicknameModel (
    @SerialName("nickname")
    val nickname : String
)
