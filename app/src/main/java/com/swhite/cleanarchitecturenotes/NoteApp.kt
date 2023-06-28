package com.swhite.cleanarchitecturenotes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Base app for DI.
@HiltAndroidApp
class NoteApp : Application()
