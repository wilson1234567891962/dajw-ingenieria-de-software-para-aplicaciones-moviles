package com.co.base.retrofit.delegate

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.co.base.retrofit.extension.activity
import com.co.base.retrofit.extension.findFragment
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class ViewModelProviderDelegate<out T : ViewModel>(private val clazz: KClass<T>, private val fromActivity: Boolean, private val fromParentFragment: Boolean, @IdRes private val fragmentContainerId: Int) {

    private var viewModel: T? = null

    operator fun getValue(thisRef: AppCompatActivity, property: KProperty<*>) = buildViewModel(activity = thisRef)

    operator fun getValue(thisRef: Fragment, property: KProperty<*>) = if (fromActivity)
        buildViewModel(activity = thisRef.activity as? AppCompatActivity)
    else buildViewModel(fragment = if (fromParentFragment) thisRef.parentFragment else thisRef)

    operator fun getValue(thisRef: View, property: KProperty<*>): T {
        return thisRef.activity?.findFragment<Fragment>(fragmentContainerId)?.let { buildViewModel(fragment = it) }
                ?: buildViewModel(activity = thisRef.activity)
    }

    private fun buildViewModel(activity: AppCompatActivity? = null, fragment: Fragment? = null): T {
        if (viewModel != null) return viewModel!!

        activity?.let {
            viewModel = ViewModelProviders.of(it).get(clazz.java)
        } ?: fragment?.let {
            viewModel = ViewModelProviders.of(it).get(clazz.java)
        } ?: throw IllegalStateException("Activity and Fragment null! =(")

        return viewModel!!
    }
}

fun <T : ViewModel> viewModelProvider(clazz: KClass<T>, fromActivity: Boolean = false, fromParentFragment: Boolean = false, @IdRes fragmentContainerId: Int = 0) = ViewModelProviderDelegate(clazz, fromActivity, fromParentFragment, fragmentContainerId)



