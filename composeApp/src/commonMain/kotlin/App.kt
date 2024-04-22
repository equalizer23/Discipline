
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import di.appModule
import di.viewModule
import habit_feature.presentation.utils.HabitBottomBar
import habit_feature.presentation.utils.tabs.HomeTab
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.koin.core.context.startKoin
import ui.theme.AppTheme


@Composable
@Preview
fun App() {
    initKoin()
    setView()

}
private fun initKoin(){
    startKoin {
        modules(appModule, viewModule)
    }
}



@Composable
private fun setView(){
    AppTheme {
        TabNavigator(HomeTab){
            Scaffold(bottomBar = {
                HabitBottomBar()
            }){padding ->
                Box(modifier = Modifier.fillMaxSize().padding(padding)){
                    CurrentTab()
                }
            }
        }
    }
}