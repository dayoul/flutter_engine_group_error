package com.example.flutter_engine_group_project

import android.content.Context
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {
    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        val app = applicationContext as BaseApplication
        return app.engineGroup.createAndRunDefaultEngine(this)
    }
}
