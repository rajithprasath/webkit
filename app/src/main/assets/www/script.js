"use strict";

// Bridge variable to interact with the Android interface
// @ts-ignore
var bridge = Bridge;

/**
 * Initializes the application once the bridge is ready.
 * @param {Function} callback - The function to execute after initialization.
 */
function initializeApp(callback) {
    if (bridge.initialized) {
        callback(); // Call the callback if the bridge is already initialized
    } else {
        bridge.afterInitialize = callback; // Store the callback to be called after initialization
    }
}

/**
 * Function to update the text area with the response from the Android side.
 * @param {string} message - The message to display.
 */
function updateText(message) {
    var textDisplay = document.getElementById("text");
    textDisplay.innerHTML = message; // Update the text display with the response
}

/**
 * Start the application and set up interactions with the Android interface.
 */
initializeApp(function () {
    var textDisplay = document.getElementById("text");
    textDisplay.innerHTML = ""; // Clear any existing text

    /**
     * Appends a new line of text to the display.
     * @param {string} message - The message to append.
     */
    var appendMessage = function (message) {
        textDisplay.innerHTML += "<br/>" + message; // Append the message with a line break
    };

    // Access the Android interface
    var androidInterface = bridge.interfaces.Android;

    // Call the synchronous method and display the result
    appendMessage(androidInterface.greetUser("From Web"));

    // Call the asynchronous promise method and display the result
    androidInterface.greetUserWithWebPromise("From Web").then(function (response) {
        appendMessage(response);
    });

    // Call the promise-returning method and display the result
    androidInterface.greetUserWithPromise("Web").then(function (response) {
        appendMessage(response);
    });

    // Register a function to be called with an integer argument
    androidInterface.registerButtonClickFunction(function (inputValue) {
        appendMessage(inputValue.toLocaleString()); // Display the input value as a formatted string
    }).then(function () {
        console.log("Function for integer registration has been successfully registered.");
    }).catch(function (error) {
        console.log("Error registering integer function:", error.toString());
    });

    // Register a function that returns a promise with a message
    androidInterface.registerButtonClickFunctionWithPromise(function () {
        return new Promise(function (resolve) {
            resolve("Hello! This app is running since " + performance.now() + " milliseconds.");
        });
    }).then(function () {
        console.log("Function for message registration has been successfully registered.");
    }).catch(function (error) {
        console.log("Error registering message function:", error.toString());
    });

    // Register a function that takes an object with two numbers and returns their sum
    androidInterface.registerButtonClickFunctionWithArgs(function (addition) {
        return new Promise(function (resolve) {
            var result = addition.a + addition.b; // Calculate the sum of the two numbers
            resolve("WEB CALCULATION: " + addition.a + " + " + addition.b + " = " + result);
        });
    }).then(function () {
        console.log("Function for addition with argument registration has been successfully registered.");
    }).catch(function (error) {
        console.log("Error registering addition function:", error.toString());
    });

 // Add event listener to the fetch button to call fetchData()
    document.getElementById("showToastButton").addEventListener("click", function() {
            // Call the Kotlin fetchData function
            androidInterface.showToast("Button clicked from WebView!")
        });

    // Add event listener to the fetch button to call fetchData()
    document.getElementById("fetchButton").addEventListener("click", function() {
            // Call the Kotlin fetchData function
            androidInterface.fetchData().then(function(response) {
                appendMessage(response); // Append the response to the display
            }).catch(function(error) {
                appendMessage("Error: " + error); // Handle errors
            });
        });
});
