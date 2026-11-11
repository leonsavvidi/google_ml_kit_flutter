package com.google_mlkit_text_recognition

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMethodCodec

class GoogleMlKitTextRecognitionPlugin : FlutterPlugin {
    private lateinit var channel: MethodChannel

    companion object {
        private const val CHANNEL_NAME = "google_mlkit_text_recognizer"
    }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        val messenger = binding.binaryMessenger
        channel =
            MethodChannel(
                messenger,
                CHANNEL_NAME,
                StandardMethodCodec.INSTANCE,
                messenger.makeBackgroundTaskQueue(),
            )
        channel.setMethodCallHandler(TextRecognizer(binding.applicationContext))
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}
