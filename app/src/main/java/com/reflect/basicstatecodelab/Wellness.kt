package com.reflect.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.Collections.list

//viewModel() returns an existing ViewModel or creates a new one in the given scope.
// The ViewModel instance is retained as long as the scope is alive.
// For example, if the composable is used in an activity, viewModel() returns the same instance until the activity is finished or the process is killed.
@Composable
fun Wellness(modifier: Modifier = Modifier,
             wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList(list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedTask = { task, checked -> wellnessViewModel.changeTaskChecked(task, checked) })
    }
}


