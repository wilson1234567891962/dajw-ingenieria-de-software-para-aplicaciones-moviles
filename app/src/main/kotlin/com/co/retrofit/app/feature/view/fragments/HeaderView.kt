package com.co.retrofit.app.feature.view.fragments


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R

class HeaderView: RelativeLayout  {

    private val initials: TextView by viewProvider(R.id.header_label_initials)
    private val name: TextView by viewProvider(R.id.header_label_username)

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            this(context, attrs, defStyleAttr, R.style.HeaderView)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
            super(context, attrs, defStyleAttr, defStyleRes)
    init {
        View.inflate(context, R.layout.header_view_col, this)
        bind()
    }

    private fun bind() {
        initials.text = "J"
        name.text = "Juan Perez"
    }
}