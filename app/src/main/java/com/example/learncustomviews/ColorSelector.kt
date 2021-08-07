package com.example.learncustomviews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.widget.ImageViewCompat

class ColorSelector @JvmOverloads
constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
    defRes: Int = 0
) : LinearLayout(context, attributeSet, defStyle, defRes) {

    private var listOfColors = listOf<Int>(Color.BLUE, Color.RED, Color.GREEN)
    private var selectedColorIndex = 0
    private lateinit var selectedColor: View

    init {
        orientation = LinearLayout.HORIZONTAL
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.color_selector, this)
        selectedColor = findViewById<View>(R.id.selectedColor)
        selectedColor.setBackgroundColor(listOfColors[selectedColorIndex])

        findViewById<ImageView>(R.id.colorSelectorArrowLeft).setOnClickListener {
            selectPreviousColor()
        }
        findViewById<ImageView>(R.id.colorSelectorArrowRight).setOnClickListener {
            selectNextColor()
        }

    }

    private fun selectPreviousColor() {
        if (selectedColorIndex == 0) {
            selectedColorIndex = listOfColors.lastIndex
        } else {
            selectedColorIndex--
        }
        selectedColor.setBackgroundColor(listOfColors[selectedColorIndex])
    }

    private fun selectNextColor() {
        if (selectedColorIndex == listOfColors.lastIndex) {
            selectedColorIndex = 0
        } else {
            selectedColorIndex++
        }
        selectedColor.setBackgroundColor(listOfColors[selectedColorIndex])
    }


}