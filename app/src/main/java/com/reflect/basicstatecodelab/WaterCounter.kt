package com.reflect.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//
//
//}

//@Composable
//fun WellnessTaskItem(taskName: String, OnClose : ()-> Unit,modifier: Modifier = Modifier){
//
//    var checkedState by rememberSaveable() { mutableStateOf(false) }
//    WellnessTaskItem(taskName,checkedState,{newValue -> checkedState = newValue},onClose =OnClose, modifier = modifier)
//
//}

@Composable
fun WellnessTaskItem(taskName: String,
                     checked: Boolean,
                     onCheckedChange : (Boolean) -> Unit,
                     onClose : ()-> Unit,
                     modifier: Modifier = Modifier){
    Row (modifier = modifier, verticalAlignment = Alignment.CenterVertically){
        Text(taskName,
            modifier =Modifier.weight(1f).padding(start = 16.dp))
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton( onClick = onClose){
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Composable
fun StatelessCounter(count : Int, onIncrement : () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
//            var showTask by remember { mutableStateOf(true) }
//            if(showTask){
//                WellnessTaskItem(onClose = {
//                    showTask = false
//                }, taskName = "Have you taken your 15 minute walk today?")
//            }
            Text(
                text =
                if(count == 1){
                     "You had 1 glass of water today"
                }else{
                    "You had $count glasses of water today"
                })
        }

        Row {
            //onClick = {} is the event that happens when the button is clicked
            Button(
                onClick =
                    onIncrement
                , modifier = Modifier.padding(top = 8.dp),
                enabled = count < 10
            ) {

                Text("Add one")

            }
            /* Button(
                 onClick = {
 //                    Text showing count, and all code related to WellnessTaskItem, are not invoked and leave the Composition.
                     //showTask MutableState is forgotten
                     count=0
                 }, modifier = Modifier.padding(top = 8.dp),
                 enabled = count > 0
             ) {

                 Text("Clear water count")

             }*/
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)

}