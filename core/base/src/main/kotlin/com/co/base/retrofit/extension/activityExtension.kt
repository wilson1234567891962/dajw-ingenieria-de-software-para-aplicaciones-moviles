package com.co.base.retrofit.extension

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.app.TaskStackBuilder
import androidx.core.content.ContextCompat
import androidx.fragment.app.*
import com.co.base.retrofit.BaseFragment
import com.co.base.retrofit.dialog.LoaderFragment
import com.co.retrofit.base.R
import com.google.android.material.snackbar.Snackbar

@Suppress("UNCHECKED_CAST")
fun <T : Fragment> FragmentActivity.findFragment(@IdRes id: Int): T? {
    return supportFragmentManager.findFragmentById(id) as? T
}

@Suppress("UNCHECKED_CAST")
fun <T : Fragment> FragmentActivity.findFragment(tag: String): T? {
    return supportFragmentManager.findFragmentByTag(tag) as? T
}

fun FragmentActivity.clearFragmentStack() {
    supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

fun FragmentActivity.fragmentTransaction(func: FragmentTransaction.() -> Unit) {
    supportFragmentManager.beginTransaction().apply(func).commit()
}

fun FragmentActivity.changeToFragment(tag: String, @IdRes parentId: Int, creator: (tag: String) -> BaseFragment, arguments: Bundle = Bundle()) {
    fragmentTransaction {
        val currentFragment: BaseFragment? = findFragment(parentId)
        val mustResetFragment = currentFragment?.let { !detachIfHasDifferentTag(it, tag) && it.view != null }
                ?: false
        if (mustResetFragment) currentFragment?.reset()
        else {
            val oldFragment: BaseFragment? = findFragment(tag)
            if (oldFragment != null) {
                attach(oldFragment)
            } else {
                val newFragment = creator.invoke(tag)
                newFragment.arguments = arguments
                add(parentId, newFragment, tag)
            }
        }
    }
}

fun FragmentActivity.changeToFragment(tag: String, @IdRes parentId: Int, fragment: BaseFragment, arguments: Bundle = Bundle()) {
    fragmentTransaction {
        val currentFragment: BaseFragment? = findFragment(parentId)
        val mustResetFragment = currentFragment?.let { !detachIfHasDifferentTag(it, tag) && it.view != null }
                ?: false
        if (mustResetFragment) currentFragment?.reset()
        else {
            val oldFragment: BaseFragment? = findFragment(tag)
            if (oldFragment != null) {
                attach(oldFragment)
            } else {
                fragment.arguments = arguments
                add(parentId, fragment, tag)
            }
        }
    }
}

fun FragmentActivity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    val v = currentFocus
    if (v != null && imm != null)
        imm.hideSoftInputFromWindow(v.windowToken, 0)
}

fun FragmentActivity.showKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    val v = currentFocus
    if (v != null && imm != null) imm.showSoftInput(v, 0)
}

fun FragmentActivity.snack(@StringRes msgRes: Int) {
    Snackbar.make(findViewById<View>(android.R.id.content), msgRes, Snackbar.LENGTH_SHORT).show()
}

fun FragmentActivity.snack(msg: String) {
    Snackbar.make(findViewById<View>(android.R.id.content), msg, Snackbar.LENGTH_SHORT).show()
}

fun FragmentActivity.snackError(rootView: View = findViewById(android.R.id.content), message: Int, indefinite: Boolean = true) {

}

fun FragmentActivity.showLoader() {
    if (isFinishing || isDestroyed) return

    hideLoader()
    val loaderFragment: LoaderFragment = LoaderFragment.newInstance()

    if (!loaderFragment.isVisible)
        loaderFragment.show(supportFragmentManager, "loaderFragment")
}

fun FragmentActivity.hideLoader() {
    if (isFinishing || isDestroyed) return

    val loaderFragment: DialogFragment? = findFragment("loaderFragment")
    loaderFragment?.let {
        it.dismiss()
        fragmentTransaction {
            remove(it)
        }
    }
}

fun FragmentActivity.finishAndStartLauncher() {
    packageManager.getLaunchIntentForPackage(packageName)?.let {
       TaskStackBuilder.create(this)
                .addNextIntentWithParentStack(it)
                .startActivities()
    }
    finishAndRemoveTask()
}

@Suppress("DEPRECATION")
fun Context.isConnected(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
}
