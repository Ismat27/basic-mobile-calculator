package com.example.basiccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Calculator {
    fun add(num1: Float?, num2: Float?): String {
        if (num1 == null || num2 == null) {
            return "invalid numbers"
        }
        return (num1 + num2).toString()
    }

    fun subtract(num1: Float?, num2: Float?): String {
        if (num1 == null || num2 == null) {
            return "invalid numbers"
        }
        return (num1 - num2).toString()
    }

    fun divide(num: Float?, deno: Float?): String {
        if (num == null || deno == null) {
            return "invalid numbers"
        }
        if (deno.toInt() == 0) {
            return "cannot divide by zero"
        }
        return (num / deno).toString()
    }

    fun multiply(num1: Float?, num2: Float?): String {
        if (num1 == null || num2 == null) {
            return "invalid numbers"
        }
        return (num1 * num2).toString()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calc = Calculator()
        val input1 = findViewById<TextInputEditText>(R.id.numberInput1)
        val input2 = findViewById<TextInputEditText>(R.id.numberInput2)
        val resultView = findViewById<TextView>(R.id.textView)

        val plusButton = findViewById<Button>(R.id.btnPlus)
        val minusButton = findViewById<Button>(R.id.btnMinus)
        val divideButton = findViewById<Button>(R.id.btnDivide)
        val multiplyButton = findViewById<Button>(R.id.btnMul)

        plusButton.setOnClickListener {
            val num1 = input1.text.toString().toFloatOrNull()
            val num2 = input2.text.toString().toFloatOrNull()
            resultView.text = (calc.add(num1, num2))
        }

        minusButton.setOnClickListener {
            val num1 = input1.text.toString().toFloatOrNull()
            val num2 = input2.text.toString().toFloatOrNull()
            resultView.text = (calc.subtract(num1, num2))
        }

        divideButton.setOnClickListener {
            val num1 = input1.text.toString().toFloatOrNull()
            val num2 = input2.text.toString().toFloatOrNull()
            resultView.text = (calc.divide(num1, num2))
        }

        multiplyButton.setOnClickListener {
            val num1 = input1.text.toString().toFloatOrNull()
            val num2 = input2.text.toString().toFloatOrNull()
            resultView.text = (calc.multiply(num1, num2))
        }
    }
}