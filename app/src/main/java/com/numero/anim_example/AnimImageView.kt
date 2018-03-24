package com.numero.anim_example

import android.animation.ObjectAnimator
import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.animation.PropertyValuesHolder

class AnimImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatImageView(context, attrs, defStyleAttr) {

    val holderX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f)
    val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 2f)
    val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 2f)

    val anim = ObjectAnimator.ofPropertyValuesHolder(this, holderX, scaleX, scaleY).apply {
        duration = 700
        repeatMode = ObjectAnimator.RESTART
        repeatCount = ObjectAnimator.INFINITE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        anim.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        anim.end()
    }
}