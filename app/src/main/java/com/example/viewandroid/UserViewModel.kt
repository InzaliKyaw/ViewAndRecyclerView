package com.example.viewandroid

import android.text.TextUtils
import androidx.lifecycle.ViewModel

class UserViewModel:ViewModel() {
    var displayText:String? = null
     fun validateInput(input: String): Boolean {
        return !TextUtils.isEmpty(input.trim())
    }
}