package habit_feature.presentation.utils

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import habit_feature.presentation.utils.tabs.AddHabitTab
import habit_feature.presentation.utils.tabs.HomeTab
import habit_feature.presentation.utils.tabs.ProfileTab

@Composable
fun HabitBottomBar(){
    val tabs = listOf(
        HomeTab,
        AddHabitTab,
        ProfileTab
    )

    NavigationBar {
        tabs.forEach{tab ->
            TabNavigationItem(tab)
        }
    }
}


@Composable
private fun RowScope.TabNavigationItem(tab: Tab){
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { tab.options.icon?.let {
            Icon(
                painter = it,
                contentDescription = tab.options.title,
                tint = MaterialTheme.colorScheme.onSecondary
            )}
        },
        label = {
            Text(text = tab.options.title, color = MaterialTheme.colorScheme.onSecondary)
        }
    )
}