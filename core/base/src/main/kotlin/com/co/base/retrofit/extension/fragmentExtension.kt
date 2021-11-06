package com.co.base.retrofit.extension

import androidx.fragment.app.FragmentTransaction
import com.co.base.retrofit.BaseFragment

fun FragmentTransaction.detachIfHasDifferentTag(fragment: BaseFragment, tag: String): Boolean {
    if (tag == fragment.tag) return false
    detach(fragment)
    return true
}