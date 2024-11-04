package com.krutik.webkitdemo.sample

import androidx.fragment.app.FragmentActivity
import com.krutik.webkitdemo.CallResolver
import com.krutik.webkitdemo.DefaultJSInterface
import com.krutik.webkitdemo.JSFunctionWithArg
import com.krutik.webkitdemo.JSFunctionWithPromise
import com.krutik.webkitdemo.JSFunctionWithPromiseAndArg

class AndroidNativeInterface(private val mainActivity: FragmentActivity) :
    DefaultJSInterface("Android"), AndroidInterface {

    /**
     * Synchronously greets the user with their name.
     * @param name The name of the user.
     * @return A greeting message.
     */
    override fun greetUser(name: String): String {
        return "Hello, $name! Welcome to the app."
    }

    /**
     * Synchronously greets the user with their name.
     * @param name The name of the user.
     * @return A greeting message.
     */
    override fun greetUserWithWebPromise(name: String): String {
        return "Hello, $name! This message is from a web promise."
    }

    /**
     * Asynchronously greets the user with their name and returns a promise.
     * @param name The name of the user.
     * @return A promise that resolves to a greeting message.
     */
    override fun greetUserWithPromise(name: String): CallResolver<String> {
        return doInBackground<String> { promise ->
            promise.resolve("Hello, $name! This message is from a promise.")
        }
    }

    /**
     * Registers a function that is triggered by a button click in the app.
     * @param function The function to be registered, which takes an integer as an argument.
     * @return A promise that resolves when the function is successfully registered.
     */
    override fun registerButtonClickFunction(function: JSFunctionWithArg<Int>): CallResolver<Unit> {
        return doInBackground<Unit> { promise ->
//            mainActivity.registerFunctionToButton1(function)
            promise.resolve(Unit)
        }
    }

    /**
     * Registers a function that returns a promise when triggered by a button click.
     * @param function The function to be registered, which returns a promise with a string result.
     * @return A promise that resolves when the function is successfully registered.
     */
    override fun registerButtonClickFunctionWithPromise(function: JSFunctionWithPromise<String>): CallResolver<Unit> {
        return doInBackground<Unit> { promise ->
//            mainActivity.registerFunctionToButton2(function)
            promise.resolve(Unit)
        }
    }

    /**
     * Registers a function that takes two integers as arguments and returns a promise.
     * @param function The function to be registered, which takes an Add object and returns a promise with a string result.
     * @return A promise that resolves when the function is successfully registered.
     */
    override fun registerButtonClickFunctionWithArgs(function: JSFunctionWithPromiseAndArg<Add, String>): CallResolver<Unit> {
        return doInBackground<Unit> { promise ->
//            mainActivity.registerFunctionToButton3(function)
            promise.resolve(Unit)
        }
    }

    // Implementation for the fetchData method
    override fun fetchData(): CallResolver<String> {
        println("checking my task 11111 ")
        return doInBackground { promise ->
            println("checking my task 2222 ")
            // Call the fetchData function from MainActivity
//            mainActivity.fetchData(promise) // Pass the promise to MainActivity's fetchData
        }
    }

    override fun showToast(message: String) {
//        mainActivity.showToast(message)
    }


}
