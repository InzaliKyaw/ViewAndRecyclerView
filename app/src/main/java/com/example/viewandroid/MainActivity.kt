package com.example.viewandroid

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.viewandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    var userInput:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        // Check if there's a saved state
        /*
        if (savedInstanceState != null) {
            // Retrieve data from the Bundle
            val userInput = savedInstanceState.getString("USER_INPUT", "")
            val displayText = savedInstanceState.getString("DISPLAY_TEXT", "")

            // Restore data to views
            binding.txtUserInput.setText(userInput)
            binding.txtDisplay.text = displayText
        }
         */

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btnDone.setOnClickListener {
            userInput   = binding.txtUserInput.text.toString()
            // Validate the input

            // Validate the input using ViewModel
            if (viewModel.validateInput(userInput.toString())) {
                viewModel.displayText = userInput
                binding.txtDisplay.text = viewModel.displayText // Manually update TextView

            } else {
                Toast.makeText(this, "Please fill valid value", Toast.LENGTH_LONG).show()
            }
        }

        // Bind ViewModel to layout
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }


    // Function to validate the user input


    /*

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
     */


}

