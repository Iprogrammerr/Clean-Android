package com.iprogrammerr.mvp.template

import android.content.Context
import android.support.v4.app.Fragment
import com.iprogrammerr.mvp.template.example.Presenters

abstract class BaseFragment<Presenter>(private val presenterFactory: () -> Presenter) : Fragment() {

    protected lateinit var activity: BaseActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            activity = context
        }
    }

    protected fun getPresenter() = Presenters.of(this, presenterFactory)
}