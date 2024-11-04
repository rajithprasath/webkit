package com.krutik.webkitdemo.sample

import android.util.Log
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {

    // This method fetches data based on the provided boolean flag.
    suspend fun fetchData(useNativeCall: Boolean): String {
        return withContext(Dispatchers.IO) {
            if (useNativeCall) {
                fetchFromApi() // Make a native call
            } else {
                fetchFromWeb() // Fallback to web request
            }
        }
    }

    // Native HTTP client call
    private fun fetchFromApi(): String {

        val url = URL("https://jsonplaceholder.typicode.com/todos/1")
        println("Test Network Request URL " + url)
        val connection = url.openConnection() as HttpURLConnection
        return try {
            println("checking my task 9999 ")
            connection.requestMethod = "GET"
            connection.connect()
            println("Test Network Request Connected to API " + connection.responseCode)
            // Log the connection state
            Log.d("ApiService", "Connected to API: ${connection.responseCode}")

            val stream = connection.inputStream.bufferedReader().use { it.readText() }
            println("Test Network Request Response " + connection.responseMessage)

            Log.d("ApiService", "Response: $connection") // Log the API response
            stream // Return the response from the API
        } catch (e: Exception) {
            println("checking my task 10101 " + e.message)
            Log.e("ApiService", "Error fetching data: ${e.message}") // Log the error message
            "Error: ${e.message}" // Return error message if any exception occurs
        } finally {
            println("checking my task 1212121 ")
            connection.disconnect()
        }
    }

    // Fallback web request
    private fun fetchFromWeb(): String {
        // For demonstration, we can use the same URL or a different one.
        // Here we'll just return a static string as a placeholder.
        return "Fallback: This is a web request response."
    }
}
