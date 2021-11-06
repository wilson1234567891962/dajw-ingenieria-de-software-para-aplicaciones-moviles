package com.co.base.retrofit.delegate

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlin.reflect.KProperty

class ViewProviderDelegate<out T : View>(@IdRes idRes: Int) : NullableViewProviderDelegate<T>(idRes) {

    override operator fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        return super.getValue(thisRef, property)!!
    }

    override operator fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return super.getValue(thisRef, property)!!
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): T {
        return super.getValue(thisRef, property)!!
    }
}

open class NullableViewProviderDelegate<out T : View>(@IdRes private val idRes: Int) {

    private var view: T? = null

    open operator fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T? {
        view?.let { if (!it.isAttachedToWindow) view = null }
        view = view ?: thisRef.findViewById(idRes)
        return view
    }

    open operator fun getValue(thisRef: Fragment, property: KProperty<*>): T? {
        view?.let { if (!it.isAttachedToWindow) view = null }
        view = view ?: thisRef.view?.findViewById(idRes)
        return view
    }

    open operator fun getValue(thisRef: View, property: KProperty<*>): T? {
        view = view ?: thisRef.findViewById(idRes)
        return view
    }
}

fun <T : View> viewProvider(@IdRes idRes: Int) = ViewProviderDelegate<T>(idRes)