package com.aid.pro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }
}

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) return intArrayOf(1)

        var carry = 1
        for (i in digits.lastIndex downTo 0) {
            val current = digits[i] + carry

            if (current > 9) {
                digits[i] = 0
                carry = 1
            } else {
                digits[i] = current
                carry = 0
            }
        }

        if (carry == 1) {
            val answer = IntArray(digits.size + 1)
            answer[0] = 1
            return answer
        } else {
            return digits
        }
    }
}

internal class Solution {
    // Calculate the sum of all of the results from multiplyOneDigit.
    private fun sumResults(results: ArrayList<ArrayList<Int>>): StringBuilder {
        // Initialize answer as a number from results.
        var answer = ArrayList(results[results.size() - 1])
        var newAnswer: ArrayList<Int> = ArrayList()

        // Sum each digit from answer and result
        for (j in 0 until results.size() - 1) {
            val result = ArrayList(results[j])
            newAnswer = ArrayList()
            var carry = 0
            var i = 0
            while (i < answer.size() || i < result.size()) {

                // If answer is shorter than result or vice versa, use 0 as the current digit.
                val digit1 = if (i < result.size()) result[i] else 0
                val digit2 = if (i < answer.size()) answer[i] else 0
                // Add current digits of both numbers.
                val sum = digit1 + digit2 + carry
                // Set carry equal to the tens place digit of sum.
                carry = sum / 10
                // Append the ones place digit of sum to answer.
                newAnswer.add(sum % 10)
                ++i
            }
            if (carry != 0) {
                newAnswer.add(carry)
            }
            answer = newAnswer
        }

        // Convert answer to a string.
        val finalAnswer = StringBuilder()
        for (digit in answer) {
            finalAnswer.append(digit)
        }
        return finalAnswer
    }

    // Multiply the current digit of secondNumber with firstNumber.
    fun multiplyOneDigit(
        firstNumber: StringBuilder,
        secondNumberDigit: Char,
        numZeros: Int
    ): ArrayList<Int> {
        // Insert zeros at the beginning based on the current digit's place.
        val currentResult: ArrayList<Int> = ArrayList()
        for (i in 0 until numZeros) {
            currentResult.add(0)
        }
        var carry = 0

        // Multiply firstNumber with the current digit of secondNumber.
        for (i in 0 until firstNumber.length) {
            val firstNumberDigit = firstNumber[i]
            val multiplication = (secondNumberDigit - '0') * (firstNumberDigit - '0') + carry
            // Set carry equal to the tens place digit of multiplication.
            carry = multiplication / 10
            // Append last digit to the current result.
            currentResult.add(multiplication % 10)
        }
        if (carry != 0) {
            currentResult.add(carry)
        }
        return currentResult
    }

    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }
        val firstNumber = StringBuilder(num1)
        val secondNumber = StringBuilder(num2)

        // Reverse both the numbers.
        firstNumber.reverse()
        secondNumber.reverse()

        // For each digit in secondNumber, multipy the digit by firstNumber and
        // store the multiplication result (reversed) in results.
        val results: ArrayList<ArrayList<Int>> = ArrayList()
        for (i in 0 until secondNumber.length) {
            results.add(multiplyOneDigit(firstNumber, secondNumber[i], i))
        }

        // Add all the results in the results array, and store the sum in the answer string.
        val answer = sumResults(results)

        // answer is reversed, so reverse it to get the final answer.
        answer.reverse()
        return answer.toString()
    }
}