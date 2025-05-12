package org.sopt.at.data.mapper

import org.sopt.at.data.dto.response.SearchUserResponse
import org.sopt.at.domain.model.SearchUserResultModel

fun SearchUserResponse.toSearchUserResultModel(): SearchUserResultModel {
    return SearchUserResultModel(
        nicknameList = nicknameList
    )
}