package com.co.retrofit.app.feature.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.co.base.retrofit.BaseActivity
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.base.retrofit.extension.hideLoader
import com.co.base.retrofit.extension.showLoader
import com.co.retrofit.app.R
import com.co.retrofit.data.model.dto.TestDto

class MainActivity : BaseActivity() {

    private val viewModel by viewModelProvider(MainViewModel::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setUpListener()
    }

    private fun observeErrorThrowable(){
        Log.d("Fue resultado exitoso", "")
    }

    private fun observeErrorThrowable(error: Throwable){
        Log.d("Fue resultado exitoso", error.toString())
    }

    private fun setUpListener(){

    }

    private fun clickTest(view: View) {
        showLoader()
        viewModel.getExampleTest()
            .observeData(this, ::showResult)
            .observeError(this, ::observeErrorThrowable)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }

    private fun showResult(test: TestDto) {
        hideLoader()
         Log.d("Fue resultado exitoso", "Resultado en proceso")
    }
}
