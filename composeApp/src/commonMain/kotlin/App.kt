
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import di.appModule
import di.viewModule
import habit_feature.presentation.home.components.HomeScreen
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
        Navigator(HomeScreen()){ navigator ->
            SlideTransition(navigator)
        }
    }
}