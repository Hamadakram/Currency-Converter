package com.test.currencyconverter

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import java.text.DecimalFormat


/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */
class RateEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : EditText(context, attrs) {

    var onFocus: ((Float) -> Unit)? = null
    var onTextChange: ((Float) -> Unit)? = null
    private lateinit var textWatcher: TextWatcher

    init {
        inputType = InputType.TYPE_CLASS_NUMBER
        setUpTextWatcher()
        setUpFocusChangeListener()
    }

    fun setRate(rate: Float, multiplier: Float) {
        val rateValue = (rate * multiplier).round()
        if (rateValue != getRate()) {
            setText(rateValue.toString())
        }
    }

    fun getRate(): Float? {
        return text.toString().toFloatOrNull()
    }

    private fun setUpFocusChangeListener() {
        setOnFocusChangeListener { view, _ ->
            if (view.hasFocus()) {
                addTextChangedListener(textWatcher)

                text.toString().toFloatOrNull()?.let {
                    onFocus?.invoke(it)
                }

            } else if (!view.hasFocus()) {
                removeTextChangedListener(textWatcher)
            }
        }
    }

    private fun setUpTextWatcher() {
        textWatcher = object : TextWatcher {
            override fun onTextChanged(char: CharSequence, start: Int, before: Int, count: Int) {
                char.toString().toFloatOrNull()?.let {
                    onTextChange?.invoke(it)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        }
    }

    private fun Float.round(): Float? {
        val format = DecimalFormat("#.##")
        return format.format(this).toFloatOrNull()
    }
}