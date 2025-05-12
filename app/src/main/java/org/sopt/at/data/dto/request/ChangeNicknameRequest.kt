package org.sopt.at.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.at.domain.model.NicknameModel

@Serializable
data class ChangeNicknameRequest (
    @SerialName("userId")
    val userId : Long,
    @SerialName("nickname")
    val nickname : NicknameModel
)