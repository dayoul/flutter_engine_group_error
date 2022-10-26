package com.example.flutter_engine_group_project

import io.flutter.FlutterInjector
import io.flutter.app.FlutterApplication
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineGroup
import io.flutter.embedding.engine.dart.DartExecutor

class BaseApplication : FlutterApplication() {
    lateinit var engineGroup: FlutterEngineGroup
    lateinit var applicationEngine: FlutterEngine
    override fun onCreate() {
        super.onCreate()
        engineGroup = FlutterEngineGroup(this)
        val applicationEngineDartEntrypoint =
            DartExecutor.DartEntrypoint(
                FlutterInjector.instance().flutterLoader().findAppBundlePath(),
                "applicationMain"
            )
        applicationEngine =
            engineGroup.createAndRunEngine(FlutterEngineGroup.Options(this).also { options ->
                options.dartEntrypoint = applicationEngineDartEntrypoint
            })
    }
}