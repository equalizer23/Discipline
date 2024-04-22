package habit_feature.presentation.utils.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

import cafe.adriel.voyager.transitions.SlideTransition
import habit_feature.presentation.home.components.HomeScreen
import habit_feature.presentation.utils.BottomBarItems

object ProfileTab : Tab {

    @Composable
    override fun Content() {
        Navigator(HomeScreen()){ navigator ->
            SlideTransition(navigator)
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val profileItem = BottomBarItems.Profile
            val icon = rememberVectorPainter(profileItem.icon)

            return remember {
                TabOptions(index = profileItem.index, icon = icon, title = profileItem.label)
            }
        }

}