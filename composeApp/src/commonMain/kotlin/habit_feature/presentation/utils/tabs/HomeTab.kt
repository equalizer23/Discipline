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

object HomeTab : Tab {

    @Composable
    override fun Content() {
        Navigator(HomeScreen()){ navigator ->
            SlideTransition(navigator)
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val homeItem = BottomBarItems.Home
            val icon = rememberVectorPainter(homeItem.icon)

            return remember {
                TabOptions(index = homeItem.index, icon = icon, title = homeItem.label)
            }
        }

}