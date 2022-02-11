package com.bimromatic.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/7
 * desc   : 仿稀土掘金loading闪动字体效果
 * version: 1.0
 * Link    :https://juejin.cn/post/7039545571664723975?share_token=1bd401cb-8f0b-4d05-a9c9-8f6e4e7a5299
 */

private const val VERTICALOFFSET = 40f

class TransitTextView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : View(context, attrs, defStyleAttr) {

 private var minWidth = 0
 private var minHeight = 0

 private lateinit var paint: Paint
 private var textSize = 120
 private var showText: String = ""
 private var normalColor = Color.parseColor("#F0F0F2")
 private var flickColor = Color.parseColor("#DCDCDC")
 private var flickPercent = 0.16f
 private var clipLeft = -VERTICALOFFSET
 private var path: Path = Path()

 init {
  init(attrs, defStyleAttr, 0)

 }

 private fun init(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
  // 获取配置属性
  context.theme.obtainStyledAttributes(
   attrs,
   R.styleable.widget_TransitTextView,
   0, 0
  ).apply {
   try {
    showText = getString(R.styleable.widget_TransitTextView_text).toString()
    textSize = getDimensionPixelSize(R.styleable.widget_TransitTextView_text_size, textSize)
    normalColor = getColor(R.styleable.widget_TransitTextView_text_normal_color, normalColor)
    flickColor = getColor(R.styleable.widget_TransitTextView_text_flick_color, flickColor)
    flickPercent = getFloat(R.styleable.widget_TransitTextView_flick_precent, flickPercent)
   } finally {
    recycle()
   }
  }

  // 初始化画笔相关
  paint = Paint()
  paint.isAntiAlias = true
  paint.textSize = textSize.toFloat()
  val textBound = Rect()
  paint.getTextBounds(showText, 0, showText.length, textBound)
  minWidth = textBound.width()
  minHeight = textBound.height()
 }

 /**
  * 1:假如mode为EXACTLY，说明指定了具体值，则直接使用
  * 2:假如mode为AT_MOST或UNSPECIFIED，判断父布局提供的大小与上方计算出的显示完整文本需要的大小，取最小值，保证不会超过父布局提供的大小
  */
 override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
  val widthMode = MeasureSpec.getMode(widthMeasureSpec)
  val widthSize = MeasureSpec.getSize(widthMeasureSpec)
  val heightMode = MeasureSpec.getMode(heightMeasureSpec)
  val heightSize = MeasureSpec.getSize(heightMeasureSpec)
  var width = 0
  var height = 0
  if (widthMode == MeasureSpec.EXACTLY) {
   width = widthSize
  } else {
   width = min(widthSize, minWidth)
  }
  if (heightMode == MeasureSpec.EXACTLY) {
   height = heightSize
  } else {
   height = min(heightSize, minHeight)
  }
  setMeasuredDimension(width, height)
 }

 override fun onDraw(canvas: Canvas?) {
  super.onDraw(canvas)
  paint.color = normalColor
  canvas?.drawText(showText, 0f, height * 0.5f, paint)

  path.reset()
  path.moveTo(clipLeft, 0f)
  path.lineTo(clipLeft + width * flickPercent, 0f)
  path.lineTo(clipLeft + width * flickPercent + VERTICALOFFSET, height.toFloat())
  path.lineTo(clipLeft + VERTICALOFFSET, height.toFloat())
  paint.color = flickColor
  canvas?.clipPath(path)
  canvas?.drawText(showText, 0f, height * 0.5f, paint)

  clipLeft += 5f
  if (clipLeft > width) {
   clipLeft = -VERTICALOFFSET
  }
  invalidate()
 }

}