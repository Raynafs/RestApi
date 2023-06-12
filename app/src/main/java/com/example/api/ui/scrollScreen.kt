package com.example.api.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.api.TrialWords
import com.example.api.WordsState

@Composable
fun ScrollScreen(
 wordsState: WordsState
){
    when (wordsState){
        is WordsState.Loading -> LoadingScreen()
        is WordsState.Success -> SuccessScreen(wordsState.words)
        is WordsState.Error -> ErrorScreen()
    }
}

@Composable
fun ErrorScreen() {

}

@Composable
fun LoadingScreen() {

}

@Composable
fun SuccessScreen(words: List<TrialWords>) {
    Column(modifier= Modifier.fillMaxSize()){
        LazyColumn()
        {
            items(words){
                Card() {
                    Text(text = "${it}")
                }
            }
        }
    }
}
