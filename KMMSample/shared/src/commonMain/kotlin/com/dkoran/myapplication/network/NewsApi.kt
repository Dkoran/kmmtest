package com.dkoran.myapplication.network

import com.dkoran.myapplication.models.NewsData
import com.dkoran.myapplication.utils.Constants.Companion.API_KEY
import com.dkoran.myapplication.utils.Constants.Companion.BASE_URL
import com.dkoran.myapplication.utils.Constants.Companion.News_Path
import com.dkoran.myapplication.utils.Constants.Companion.Search_Path
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.get
import io.ktor.http.*
import kotlinx.serialization.json.Json as KotlinJson

class NewsApi {
    private val httpClient: HttpClient = HttpClient {
        install(JsonFeature){
            serializer = KotlinxSerializer(KotlinJson {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun fetchNews(): NewsData {
        val url = URLBuilder(BASE_URL).run {
            path(News_Path)
            parameters.append("country","us")
            parameters.append("apiKey",API_KEY)
            buildString()
        }
        return httpClient.get(url)

    }

    suspend fun searchNews(country:String,search:String) : NewsData {
        val url = URLBuilder(BASE_URL).run {
            path(Search_Path)
            parameters.append("q",search)
            parameters.append("country",country)
            parameters.append("apiKey",API_KEY)
            buildString()
        }
        return httpClient.get(url)
    }
}