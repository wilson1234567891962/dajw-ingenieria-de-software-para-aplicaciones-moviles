package com.co.retrofit.app.feature.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.co.retrofit.app.R
import android.view.View
import android.widget.Button
import com.co.base.retrofit.delegate.viewProvider
import kotlin.system.exitProcess

class Maintenance : AppCompatActivity() {

    private val btnRestart: Button by viewProvider(R.id.btn_restart)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maintenance)
        setUpListenerEvent()
    }

    private fun setUpListenerEvent() {
        btnRestart.setOnClickListener(this::restartApplication)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun restartApplication(view: View) {
        val pm = this.packageManager
        val intent = pm.getLaunchIntentForPackage(this.packageName)
        this.finishAffinity() // Finishes all activities.
        this.startActivity(intent) // Start the launch activity
        exitProcess(0) // System finishes and automatically relaunches us.
    }
}