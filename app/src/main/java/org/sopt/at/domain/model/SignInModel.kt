package org.sopt.at.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInModel (
    @SerialName("loginId")
    val loginId: String,
    @SerialName("password")
    val password: String
)