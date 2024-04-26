package habit_feature.presentation.habit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.maximilianproell.multiplatformchart.barchart.BarChart
import at.maximilianproell.multiplatformchart.barchart.config.BarConfigDefaults
import at.maximilianproell.multiplatformchart.barchart.model.BarChartEntry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import discipline.composeapp.generated.resources.Res
import discipline.composeapp.generated.resources.flame_icon
import habit_feature.presentation.utils.AlertOptions
import habit_feature.presentation.utils.CustomAlertDialog
import habit_feature.presentation.utils.CustomTextField
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class HabitScreen : Screen {
    @OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        var habitName by remember { mutableStateOf("Do push ups") }
        var frequency by remember { mutableStateOf("7") }

        var alertOptions by remember { mutableStateOf(AlertOptions()) }
        var isDialogVisible by remember { mutableStateOf(false) }


        if(isDialogVisible){
            CustomAlertDialog(
                alertOptions = alertOptions,
                onDismiss = {isDialogVisible = false}
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {

                Box(modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        modifier = Modifier.align(Alignment.TopStart),
                        onClick = {
                            navigator.pop()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Habit Info",
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = habitName,
                    onTextChange = { habitName = it },
                    label = "Name"
                )

                Spacer(modifier = Modifier.height(10.dp))

                CustomTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = frequency,
                    onTextChange = { frequency = it },
                    label = "Frequency",
                    keyBoardType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
                ) {
                    Text("Update", color = MaterialTheme.colorScheme.secondary)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "Habit Stats",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.height(20.dp))

                BarChart(
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    entries = listOf(
                        BarChartEntry("One", 0.5f),
                        BarChartEntry("Two", 1.25f),
                        BarChartEntry("Three", 3f),
                        BarChartEntry("Four", 1f),
                        BarChartEntry("One", 0.5f),
                        BarChartEntry("Two", 1.25f),
                        BarChartEntry("Three", 3f),
                        BarChartEntry("Four", 1f),
                    ),
                    maxYValue = 3f,
                    barConfig = BarConfigDefaults.defaultBarConfig.copy(
                        animate = true,
                        barColor = MaterialTheme.colorScheme.onSecondary
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Current Streak:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSecondary
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "5",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.onSecondary
                            )

                            Image(
                                painter = painterResource(Res.drawable.flame_icon),
                                contentDescription = "Flame",
                                modifier = Modifier.size(32.dp),
                                colorFilter = ColorFilter.tint(color = Color.Yellow)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "The Best Streak:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSecondary
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "15",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.onSecondary
                            )

                            Image(
                                painter = painterResource(Res.drawable.flame_icon),
                                contentDescription = "Flame",
                                modifier = Modifier.size(32.dp),
                                colorFilter = ColorFilter.tint(color = Color.Yellow)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Button(
                            modifier = Modifier.weight(0.45f).height(50.dp),
                            onClick = {
                                alertOptions = alertOptions.copy(
                                    text = "Are you sure you want to delete a habit?",
                                    isNoOptionFocused = true
                                )
                                isDialogVisible = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(text = "Delete habit", color = Color.Red)
                        }

                        Spacer(modifier = Modifier.weight(0.1f))

                        Button(
                            modifier = Modifier.weight(0.45f).height(50.dp),
                            onClick = {
                                alertOptions = alertOptions.copy(
                                    text = "Are you sure you want to complete a habit?",
                                    isNoOptionFocused = false
                                )
                                isDialogVisible = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "Complete habit",
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }

                }
            }
        }
    }

}