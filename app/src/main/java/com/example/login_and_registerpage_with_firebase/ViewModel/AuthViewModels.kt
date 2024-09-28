package com.example.login_and_registerpage_with_firebase.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModels:ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    fun signUp(email: String, password: String): LiveData<String> {
        val result = MutableLiveData<String>()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    result.value = "Sign up success"
                } else {
                    result.value = it.exception?.message
                }
            }
        return result
    }

    fun signIn(email: String, password: String): LiveData<String> {
        val result = MutableLiveData<String>()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    result.value = "Sign in success"
                } else {
                    result.value = it.exception?.message
                }
            }
        return result

    }
    fun sigOut(){
        auth.signOut()
    }
}