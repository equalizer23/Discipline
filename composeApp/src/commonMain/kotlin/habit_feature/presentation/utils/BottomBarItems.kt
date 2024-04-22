package habit_feature.presentation.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItems(
    val index: UShort, val label: String, val icon: ImageVector
) {
    data object Home : BottomBarItems(
       index = 0u, label = "Home", icon = Icons.Default.Home
    )
    data object Add : BottomBarItems(
        index = 1u, label = "Add", icon = Icons.Default.AddCircle
    )
    data object Profile : BottomBarItems(
        index = 2u, label = "Profile", icon = Icons.Default.Person
    )
}