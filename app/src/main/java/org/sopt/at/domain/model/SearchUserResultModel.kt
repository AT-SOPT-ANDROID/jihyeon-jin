package org.sopt.at.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchUserResultModel(
    @SerialName("nicknameList")
    val nicknameList: List<String>
)