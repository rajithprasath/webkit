package com.krutik.webkitdemo.sample

import com.krutik.webkitdemo.CallType
import com.krutik.webkitdemo.JSFunctionWithArg
import com.krutik.webkitdemo.JSFunctionWithPromise
import com.krutik.webkitdemo.JSFunctionWithPromiseAndArg
import com.krutik.webkitdemo.NativeCall
import com.krutik.webkitdemo.CallResolver

interface AndroidInterface {

    @NativeCall(CallType.FULL_SYNC)
    fun greetUser(name: String): String

    @NativeCall(CallType.WEB_CALL)
    fun greetUserWithWebPromise(name: String): String

    @NativeCall(CallType.FULL_PROMISE)
    fun greetUserWithPromise(name: String): CallResolver<String>

    @NativeCall(CallType.FULL_PROMISE)
    fun registerButtonClickFunction(function: JSFunctionWithArg<Int>): CallResolver<Unit>

    @NativeCall(CallType.FULL_PROMISE)
    fun registerButtonClickFunctionWithPromise(function: JSFunctionWithPromise<String>): CallResolver<Unit>

    @NativeCall(CallType.FULL_PROMISE)
    fun registerButtonClickFunctionWithArgs(function: JSFunctionWithPromiseAndArg<Add, String>): CallResolver<Unit>

    @NativeCall(CallType.FULL_PROMISE)
    fun fetchData(): CallResolver<String>

    @NativeCall(CallType.FULL_SYNC)
    fun showToast(message: String)
}

data class Add(val a: Int, val b: Int)