package com.example.viewpagerdemo.data.result

import java.lang.Exception

/**
 * A generic class that holds a value.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T?) : Result<T>()
    data class Failure<out T>(val code: Int, val body: T?) : Result<T>() // TODO: define correct body
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure -> "Failure[code=$code][body=$body]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading"
        }
    }
}