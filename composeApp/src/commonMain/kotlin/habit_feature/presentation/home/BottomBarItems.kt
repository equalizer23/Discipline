package habit_feature.presentation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItems(
    val icon: ImageVector,
    val label: String,
){
    data object Home : BottomBarItems(
        label = "Home", icon = Icons.Default.Home
    )
    data object AddHabit : BottomBarItems(
        label = "Add", icon = Icons.Default.AddCircle
    )
    data object Profile : BottomBarItems(
        label = "Profile", icon = Icons.Default.Person
    )
}