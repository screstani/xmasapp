package com.allexandresantos.xmasapp

import android.app.Application
import com.allexandresantos.xmasapp.models.UserModel
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object{
        val mockUser: UserModel = UserModel(userId = "1234", userName = "Leãozinho")
    }
}