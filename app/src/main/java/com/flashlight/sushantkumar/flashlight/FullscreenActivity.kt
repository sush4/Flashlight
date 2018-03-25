package com.flashlight.sushantkumar.flashlight

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.blank_fullscreen.*
import android.view.MotionEvent
import android.support.v4.view.MotionEventCompat
import android.util.Log
import android.view.View.OnTouchListener
import android.app.Activity
import android.content.Intent






/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {

    val DEBUG_TAG = "DEBUG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.blank_fullscreen)
        val view: View = findViewById(R.id.entire_view)
        view.setOnTouchListener { view, event ->

            val goBackToMainActivity = Intent()
            setResult(Activity.RESULT_OK, goBackToMainActivity)
            finish()
            true }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val action = MotionEventCompat.getActionMasked(event)

        when (action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d(DEBUG_TAG, "Action was DOWN")
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d(DEBUG_TAG, "Action was MOVE")
                return true
            }
            MotionEvent.ACTION_UP -> {
                Log.d(DEBUG_TAG, "Action was UP")
                return true
            }
            MotionEvent.ACTION_CANCEL -> {
                Log.d(DEBUG_TAG, "Action was CANCEL")
                return true
            }
            MotionEvent.ACTION_OUTSIDE -> {
                Log.d(DEBUG_TAG, "Movement occurred outside bounds " + "of current screen element")
                return true
            }
            else -> return super.onTouchEvent(event)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

}
