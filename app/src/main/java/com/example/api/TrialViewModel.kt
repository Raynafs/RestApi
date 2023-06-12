package com.example.api

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.retrofitsetup.TrialApi
import kotlinx.coroutines.launch
import java.io.IOException
/**Strict class heirarchy*/
sealed interface WordsState{
    data class Success (val words: List<TrialWords>) : WordsState
    object Error: WordsState
    object Loading: WordsState
}
class TrialViewModel : ViewModel() {
    var wordsState: WordsState by mutableStateOf (WordsState.Loading)
    private set

    init {
        getWords()
    }

    private fun getWords() {
        viewModelScope.launch {
            wordsState = try {
                val listWords:List<TrialWords> = TrialApi.retrofitService.getPost()
                WordsState.Success (listWords)
            }
            catch (e: IOException){
                WordsState.Error
            }

        }
    }
}