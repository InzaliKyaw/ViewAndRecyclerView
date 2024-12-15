package com.example.viewandroid

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.viewandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var userInput:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        // Check if there's a saved state

        if (savedInstanceState != null) {
            // Retrieve data from the Bundle
            val userInput = savedInstanceState.getString("USER_INPUT", "")
            val displayText = savedInstanceState.getString("DISPLAY_TEXT", "")

            // Restore data to views
            binding.txtUserInput.setText(userInput)
            binding.txtDisplay.text = displayText
        }


        binding.btnDone.setOnClickListener {
            userInput   = binding.txtUserInput.text.toString()
            // Validate the input
            if (validateInput(userInput.toString())) {
                binding.txtDisplay.text = userInput
            } else {
                Toast.makeText(this,"Please fill valid value",Toast.LENGTH_LONG).show()
            }
        }
    }


    // Function to validate the user input
    private fun validateInput(input: String): Boolean {
        return !TextUtils.isEmpty(input.trim())
    }


    // onStart()
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedString = savedInstanceState.getString("USER_INPUT") // Retrieve the String
        val savedCounter = savedInstanceState.getInt("DISPLAY_TEXT") // Retrieve the Int

        // Use the retrieved values as needed
        Log.d("TAG", "Retrieved String: $savedString, Counter: $savedCounter")
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("USER_INPUT", binding.txtUserInput.text.toString())
        outState.putString("DISPLAY_TEXT", binding.txtDisplay.text.toString())
    }


}

