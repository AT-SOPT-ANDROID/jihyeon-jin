package org.sopt.at.feature.home.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.core.type.toTitleResId
import org.sopt.at.domain.model.ContentCategory
import org.sopt.at.ui.theme.Gray3
import org.sopt.at.ui.theme.White

@Composable
fun ContentCategoryRow(
    selectedContentCategory: ContentCategory,
    onContentCategorySelected: (ContentCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ContentCategory.entries.forEach { contentCategory ->
            if(contentCategory != ContentCategory.ALL) {
                val isSelected = contentCategory == selectedContentCategory
                Text(
                    modifier = Modifier
                        .noRippleClickable { onContentCategorySelected(contentCategory) },
                    text = stringResource(contentCategory.toTitleResId()),
                    fontSize = 18.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (selectedContentCategory == ContentCategory.ALL) White
                    else if (isSelected) White
                    else Gray3
                )
            }
        }
    }
}