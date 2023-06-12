package com.example.api.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.api.TrialViewModel
import com.example.api.WordsState

@Composable
fun FinalApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray)
    {
        val wordsViewModel: TrialViewModel = viewModel()
        ScrollScreen(wordsState =  wordsViewModel.wordsState)
    }
}