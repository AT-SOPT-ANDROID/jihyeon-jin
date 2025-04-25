package org.sopt.at.core.type

import androidx.annotation.StringRes
import org.sopt.at.R

enum class ContentType(
    @StringRes val titleResId: Int
) {
    DRAMA(R.string.type_drama),
    ENTERTAINMENT(R.string.type_entertainment),
    MOVIE(R.string.type_movie),
    SPORTS(R.string.type_sports),
    ANIMATION(R.string.type_animation),
    NEWS(R.string.type_news),
}