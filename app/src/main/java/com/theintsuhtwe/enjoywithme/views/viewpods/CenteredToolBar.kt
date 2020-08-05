package com.theintsuhtwe.enjoywithme.views.viewpods

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.theintsuhtwe.enjoywithme.R

class CenteredToolBar : Toolbar {

    private var titleView: TextView? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int): super(context, attrs, defStyle)

    override fun setTitle(resId: Int) {
        var s = resources.getString(resId)
        title = s
    }

    override fun setTitle(title: CharSequence?) {
        getCenteredTitleView().text = title
    }

    override fun getTitle(): CharSequence {
        return getCenteredTitleView().text.toString()
    }

    override fun setTitleTextColor(color: Int) {
        getCenteredTitleView().setTextColor(color)
    }

    private fun getCenteredTitleView() : TextView {
        if (titleView == null){
            titleView = TextView(context)
            titleView?.setSingleLine()
           titleView?.ellipsize = TextUtils.TruncateAt.END
            titleView?.gravity = Gravity.CENTER
            titleView?.setTextAppearance(context, R.style.TextAppearance_AppCompat_Widget_ActionBar_Title)
            var lp = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            lp.gravity = Gravity.CENTER
            titleView?.layoutParams = lp
            titleView?.setTextColor(resources.getColor(R.color.colorWhite))
            addView(titleView)
        }
        return  titleView!!

    }

}