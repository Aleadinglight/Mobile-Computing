package com.example.assignment4_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    private var expression = "";
    private var result = "";

    private val symbolPlus by lazy { getString(R.string.button_plus) }
    private val symbolMinus by lazy { getString(R.string.button_minus) }
    private val symbolMultiply by lazy { getString(R.string.button_multiply) }
    private val symbolDivide by lazy { getString(R.string.button_divide) }
    private val symbolModulo by lazy { getString(R.string.button_mod) }
    private val symbolInvert by lazy { getString(R.string.button_invert) }
    private val symbolSentinel = "'"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CE
        findViewById<Button>(R.id.button_ce).setOnClickListener {
            pressCE()
        }
        // C
        findViewById<Button>(R.id.button_c).setOnClickListener {
            pressC()
        }
        // backspace
        findViewById<Button>(R.id.button_del).setOnClickListener {
            pressBackspace()
        }
        // +
        findViewById<Button>(R.id.button_plus).setOnClickListener {
            pressOperator(symbolPlus.single())
        }
        // -
        findViewById<Button>(R.id.button_minus).setOnClickListener {
            pressOperator(symbolMinus.single())
        }
        // x
        findViewById<Button>(R.id.button_multiply).setOnClickListener {
            pressOperator(symbolMultiply.single())
        }
        // /
        findViewById<Button>(R.id.button_divide).setOnClickListener {
            pressOperator(symbolDivide.single())
        }
        // %
        findViewById<Button>(R.id.button_modulo).setOnClickListener {
            pressOperator(symbolModulo.single())
        }
        // invert
        findViewById<Button>(R.id.button_invert).setOnClickListener {
            pressInvert()
        }
        // calculate
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            pressCalculate()
        }
        // numbers
        val btnNumbers = arrayOf(
            R.id.button_0,
            R.id.button_1,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9
        )
        btnNumbers.forEachIndexed { index, btnId ->
            findViewById<Button>(btnId).setOnClickListener {
                pressNumber(index)
            }
        }
    }


    private fun pressCE() {
        expression = ""
        result = ""
        render()
    }

    private fun pressC() {
        expression = expression.dropLastWhile { it.isDigit() }
        render()
    }

    private fun pressBackspace() {
        expression = expression.dropLast(1)
        render()
    }

    private fun pressOperator(op: Char) {
        if (expression.isEmpty()) return

        if (expression.takeLast(1).isDigitsOnly()) {
            // last character is digit, then append
            expression += op
        } else {
            // last character is an operator, then replace it
            expression = expression.dropLast(1) + op
        }
        render()
    }

    private fun pressNumber(n: Int) {
        val lastOperand = expression.takeLastWhile { it.isDigit() }
        if (lastOperand == "0") {
            // last operand is a single 0, then replace it
            expression = expression.dropLast(1) + n
        } else {
            // else append
            expression += n.toString()
        }
        render()
    }

    private fun pressInvert() {
        val lastOperand = expression.takeLastWhile { it.isDigit() }
        val prefix = expression.dropLast(lastOperand.length)
        if (prefix.takeLast(1) == symbolInvert) {
            expression = prefix.dropLast(1) + lastOperand
        } else {
            expression = prefix + symbolInvert + lastOperand
        }
        render()
    }

    private fun pressCalculate() {
        expression = expression.dropLastWhile { !it.isDigit() }
        if (expression.isEmpty()) {
            expression = "0"
        }
        Log.d("huypham", "Calculating " + expression)

        val operandStack = Stack<Float>()
        val operatorStack = Stack<String>()
        var dividedByZero = false

        var currentOperand = ""
        val exp = expression + symbolSentinel // added a plus at the end as sentinel
        exp.forEach {
            when {
                it.isDigit() || (it.toString() == symbolInvert) -> {
                    // digit
                    currentOperand += it
                }
                else -> {
                    // reached an operator
                    // finished reading an operand
                    operandStack.push(currentOperand.toFloat())
                    Log.d("huypham", "push $currentOperand")
                    currentOperand = ""
                    val currentOperator = it.toString()
                    while (!operatorStack.empty() && priority(currentOperator) <= priority(
                            operatorStack.peek()
                        )
                    ) {
                        // lower priority, must handle previous operations before pushing
                        val b = operandStack.pop()
                        val op = operatorStack.pop()
                        val a = operandStack.pop()
                        if (op == symbolDivide && b == 0.0f) {
                            dividedByZero = true
                        }
                        val aOpB = calculate(a, op, b)
                        operandStack.push(aOpB)
                        Log.d("huypham", "push $aOpB")
                        Log.d(
                            "huypham",
                            "a = $a, b = $b, op = $op, aOpB = $aOpB, currentOperator = $currentOperator"
                        )
                    }
                    operatorStack.push(currentOperator)
                    Log.d("huypham", "push $currentOperator")
                }
            }
        }
        Log.d("huypham", "result = " + operandStack.peek())
        val res = operandStack.pop()
        if (dividedByZero) {
            result = "Cannot divide by zero"
        } else if (res.isFinite()) {
            result = res.toString()
        } else {
            result = "Value is out of range"
        }

        render()
    }

    private fun calculate(a: Float, op: String, b: Float): Float {
        return when (op) {
            symbolPlus -> a + b
            symbolMinus -> a - b
            symbolMultiply -> a * b
            symbolDivide -> a / b
            symbolModulo -> a % b
            else -> throw Exception("Operator unknown")
        }
    }

    private fun priority(op: String): Int {
        return when (op) {
            symbolPlus, symbolMinus -> 1
            symbolMultiply, symbolDivide, symbolModulo -> 2
            symbolSentinel -> 0
            else -> 0
        }
    }

    private fun render() {
        findViewById<TextView>(R.id.text_input).setText(expression)
        findViewById<TextView>(R.id.text_output).setText(result)
    }
}