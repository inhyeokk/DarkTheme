package com.github.rkddlsgur983.darktheme.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.rkddlsgur983.darktheme.util.Logger

open class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Logger.printLifeCycleLog(this, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.printLifeCycleLog(this, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        Logger.printLifeCycleLog(this, "onCreateView")
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Logger.printLifeCycleLog(this, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Logger.printLifeCycleLog(this, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Logger.printLifeCycleLog(this, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Logger.printLifeCycleLog(this, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Logger.printLifeCycleLog(this, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.printLifeCycleLog(this, "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Logger.printLifeCycleLog(this, "onDetach")
    }
}