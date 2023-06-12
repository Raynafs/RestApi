package com.example.api.retrofitsetup

import com.example.api.TrialWords
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
private val retro = Retrofit.Builder()//    Json to object
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))//Json Object
    .baseUrl(BASE_URL)
    .build()

/**Methods return list */
interface TrialApiService {
    @GET("posts")
    suspend fun getPost(): List<TrialWords>
}

object TrialApi {
    /** Builder for endpoint configuration
     * Unless you cal endpoint it wont create retrofit
     *
     */
    val retrofitService: TrialApiService by lazy {
        retro.create(TrialApiService::class.java)
    }
}