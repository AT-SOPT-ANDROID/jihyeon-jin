package org.sopt.at.feature.main.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import org.sopt.at.feature.main.MainTab
import org.sopt.at.ui.theme.TivingTheme
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography


@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    visible: Boolean,
    tabs: PersistentList<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideIn { IntOffset(0, it.height) },
        exit = fadeOut() + slideOut { IntOffset(0, it.height) }
    ) {
        val borderColor = colors.gray04
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(68.dp)
                .drawBehind {
                    val borderThickness = 1.dp.toPx()

                    drawLine(
                        color = borderColor,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = borderThickness
                    )
                }
                .background(
                    color = colors.basicBlack,
                ),
        ) {
            tabs.forEach { tab ->
                MainBottomBarItem(
                    tab = tab,
                    selected = tab == currentTab,
                    onClick = { onTabSelected(tab) },
                )
            }
        }
    }
}

@Composable
private fun RowScope.MainBottomBarItem(
    modifier: Modifier = Modifier,
    tab: MainTab,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val itemSelectColor = if (selected) colors.basicWhite else colors.gray04
    val itemSelectIcon = if (selected) tab.selectIconResId else tab.defaultIconResId

    Column(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .weight(1f)
            .selectable(
                selected = selected,
                role = Role.Tab,
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(itemSelectIcon),
            contentDescription = stringResource(tab.descriptionResId),
            tint = itemSelectColor,
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = stringResource(tab.descriptionResId),
            style = typography.caption.merge(itemSelectColor),
        )
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    TivingTheme {
        Column(Modifier.fillMaxSize()) {
            MainBottomBar(
                visible = true,
                tabs = MainTab.entries.toPersistentList(),
                currentTab = MainTab.HOME,
                onTabSelected = { },
            )
        }
    }
}