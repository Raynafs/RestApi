package com.example.api

import kotlinx.serialization.Serializable

@Serializable
data class TrialWords (
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
        )