package org.sopt.at.core.type

import androidx.annotation.StringRes
import org.sopt.at.R
import org.sopt.at.domain.model.ContentCategory

enum class ContentType(
    @StringRes val titleResId: Int
) {
    ALL(R.string.type_drama),
    DRAMA(R.string.type_drama),
    ENTERTAINMENT(R.string.type_entertainment),
    MOVIE(R.string.type_movie),
    SPORTS(R.string.type_sports),
    ANIMATION(R.string.type_animation),
    NEWS(R.string.type_news),
}
fun ContentType.toContentCategory(): ContentCategory = when (this) {
    ContentType.ALL -> ContentCategory.ALL
    ContentType.DRAMA -> ContentCategory.DRAMA
    ContentType.ENTERTAINMENT -> ContentCategory.ENTERTAINMENT
    ContentType.MOVIE -> ContentCategory.MOVIE
    ContentType.SPORTS -> ContentCategory.SPORTS
    ContentType.ANIMATION -> ContentCategory.ANIMATION
    ContentType.NEWS -> ContentCategory.NEWS
}

fun ContentCategory.toTitleResId(): Int = when (this) {
    ContentCategory.ALL -> R.string.type_all
    ContentCategory.DRAMA -> R.string.type_drama
    ContentCategory.ENTERTAINMENT -> R.string.type_entertainment
    ContentCategory.MOVIE -> R.string.type_movie
    ContentCategory.SPORTS -> R.string.type_sports
    ContentCategory.ANIMATION -> R.string.type_animation
    ContentCategory.NEWS -> R.string.type_news
}