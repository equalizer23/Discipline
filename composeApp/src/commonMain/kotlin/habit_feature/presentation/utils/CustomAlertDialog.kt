package habit_feature.presentation.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAlertDialog(
    alertOptions: AlertOptions,
    onDismiss : () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = onDismiss
    ){
        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        ){
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = alertOptions.text,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                alertOptions.description?.let {description ->
                    Text(
                        text = description,
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Button(
                        modifier = Modifier.weight(0.45f).height(50.dp),
                        onClick = {},
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color.Red
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                                if(alertOptions.isNoOptionFocused) Color.Red
                                else MaterialTheme.colorScheme.background
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Text(
                            text = "No",
                            color = MaterialTheme.colorScheme.onSecondary
                        )

                    }

                    Spacer(modifier = Modifier.weight(0.1f))

                    Button(
                        modifier = Modifier.weight(0.45f).height(50.dp),
                        onClick = {},
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if(alertOptions.isNoOptionFocused) MaterialTheme.colorScheme.background
                            else MaterialTheme.colorScheme.primary
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Text(text = "Yes", color = MaterialTheme.colorScheme.onSecondary)
                    }
                }
            }
        }
    }
}