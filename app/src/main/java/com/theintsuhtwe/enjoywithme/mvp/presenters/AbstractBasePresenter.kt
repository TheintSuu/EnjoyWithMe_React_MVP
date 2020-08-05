package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.ViewModel
import com.theintsuhtwe.enjoywithme.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}