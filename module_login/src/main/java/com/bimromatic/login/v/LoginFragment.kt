package com.bimromatic.login.v

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/13
 * desc   :
 * version: 1.0
 * Link    :
 */
class LoginFragment:Fragment() {

    private val TAG = "LoginFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("lifecycle", "$TAG:onAttach");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("lifecycle", "$TAG:onCreate");
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.e("lifecycle", "$TAG:onCreateView");
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("lifecycle", "$TAG:onViewCreated");
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("lifecycle", "$TAG:onViewStateRestored");
    }

    override fun onStart() {
        super.onStart()
        Log.e("lifecycle", "$TAG:onStart");
    }


    override fun onResume() {
        super.onResume()
        Log.e("lifecycle", "$TAG:onResume");
    }


    override fun onStop() {
        super.onStop()
        Log.e("lifecycle", "$TAG:onResume");
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("lifecycle", "$TAG:onSaveInstanceState");
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("lifecycle", "$TAG:onDestroyView");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("lifecycle", "$TAG:onDestroy");
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("lifecycle", "$TAG:onDetach");
    }


}