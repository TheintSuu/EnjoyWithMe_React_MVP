package com.theintsuhtwe.enjoywithme.mvp.presenters


import com.theintsuhtwe.enjoywithme.mvp.views.BaseView

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}