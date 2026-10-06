package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DemoFragment : Fragment() {

    private val TAG = "DemoFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach Called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView Called")
        return inflater.inflate(R.layout.fragment_demo, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onPause() {
        Log.d(TAG, "onPause Called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop Called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy Called")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach Called")
        super.onDetach()
    }
}
