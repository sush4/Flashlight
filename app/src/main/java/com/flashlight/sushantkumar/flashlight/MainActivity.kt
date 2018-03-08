package com.flashlight.sushantkumar.flashlight

import android.content.Context
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.hardware.camera2.CameraAccessException
import android.content.Context.CAMERA_SERVICE
import android.hardware.camera2.CameraManager
import android.media.MediaPlayer
import android.os.Build
import android.view.View
import android.widget.ToggleButton


class MainActivity : AppCompatActivity() {

    private var camera: CameraManager? = null
    private var isChecked: Boolean = true
    private var hasFlash: Boolean = false
    private var params: android.hardware.Camera.Parameters? = null
    private var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLightOn()
        val button: ToggleButton = findViewById(R.id.button)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                isChecked = !isChecked
                if (isChecked) {
                    setLightOn()
                } else {
                    setLightOff()
                }
            }
        })

    }

    fun setLightOff() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val camManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            var cameraId: String? = null // Usually back camera is at 0 position.
            try {
                cameraId = camManager.cameraIdList[0]
                camManager.setTorchMode(cameraId!!, false)   //Turn ON
            } catch (e: CameraAccessException) {
                e.printStackTrace()
            }

        }
    }

    fun setLightOn() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val camManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            var cameraId: String? = null // Usually back camera is at 0 position.
            try {
                cameraId = camManager.cameraIdList[0]
                camManager.setTorchMode(cameraId!!, true)   //Turn ON
            } catch (e: CameraAccessException) {
                e.printStackTrace()
            }

        }
    }
}
