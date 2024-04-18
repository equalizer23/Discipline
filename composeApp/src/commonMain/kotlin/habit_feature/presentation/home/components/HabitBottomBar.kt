package habit_feature.presentation.home.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import habit_feature.presentation.home.BottomBarItems

@Composable
fun HabitBottomBar(

) {
    val items = listOf(
        BottomBarItems.Home,
        BottomBarItems.AddHabit,
        BottomBarItems.Profile
    )

    var navIndex by remember {
        mutableIntStateOf(0)
    }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == navIndex,
                onClick = {
                    navIndex = index
                    TODO("Navigate to Screen in BottomBar")
                },
                icon = { Icon(
                    imageVector = item.icon,
                    contentDescription = item.label,
                    tint = MaterialTheme.colorScheme.onSecondary
                )},
                label = {
                    Text(text = item.label, color = MaterialTheme.colorScheme.onSecondary)
                }
            )
        }
    }
}