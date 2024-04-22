package habit_feature.presentation.utils.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import habit_feature.presentation.add_habit.components.AddHabitScreen
import habit_feature.presentation.utils.BottomBarItems

object AddHabitTab : Tab {

    @Composable
    override fun Content() {
        Navigator(AddHabitScreen()){ navigator ->
            SlideTransition(navigator)
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val addHabitItem = BottomBarItems.Add
            val icon = rememberVectorPainter(addHabitItem.icon)

            return remember {
                TabOptions(index = addHabitItem.index, icon = icon, title = addHabitItem.label)
            }
        }

}