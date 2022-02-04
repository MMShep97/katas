package katas.lt.photoalbum

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

/*
Nice to haves:
1. validation on input arguments
 */

suspend fun main() {
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }

    println("""
        Welcome! This application allows you to print your favorite photo album information!
        If you're not familiar with what data we're referring to, please navigate to https://jsonplaceholder.typicode.com/photos.
        
    """.trimIndent()
    )

    while (true) {
        print("Please supply an album id: ")
        val albumId = readLine() ?: println("An album id is required")

        val photoAlbumInfo: List<PhotoAlbumInfo> = client.get("https://jsonplaceholder.typicode.com/photos") {
            parameter("albumId", albumId)
        }

        printAlbumInfo(photoAlbumInfo)
    }
}

private fun printAlbumInfo(photoAlbumInfo: List<PhotoAlbumInfo>) {
    if (photoAlbumInfo.isEmpty()) {
        println("No matching album information")
    } else {
        println("Photo ID | Title")
        println("----------------")
        for (album in photoAlbumInfo) {
            println("[${album.photoId}] ${album.title}")
        }
    }
}