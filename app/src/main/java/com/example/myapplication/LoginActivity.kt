package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {
            checkFieldsForEmptyValues()
        }

        override fun afterTextChanged(editable: Editable) {}
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val backButton = findViewById<Button>(R.id.button3) as Button
        val loginButton = findViewById<Button>(R.id.button4) as Button
        val inputNum = findViewById<EditText>(R.id.editTextPhone) as EditText
        val inputMPIN = findViewById<EditText>(R.id.editTextNumberPassword) as EditText
        val imageView = findViewById<ImageView>(R.id.imageView2) as ImageView

        imageView.setOnClickListener {
            if (inputMPIN.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                inputMPIN.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                inputMPIN.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

//        var REG = "^(09|\\+639)\\d{9}$"
//        var PATTERN: Pattern = Pattern.compile(REG)
//
//        fun CharSequence.isPhoneNumber() : Boolean = PATTERN.matcher(this).find()


        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        loginButton.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            var numInputted = inputNum.text.toString()
            var inputtedMPIN = inputMPIN.text.toString()

            val flag = false

            if (TextUtils.isEmpty(inputtedMPIN.trim())) {
                inputMPIN.error = "Enter password";
            }

            if (TextUtils.isEmpty(numInputted.trim())) {
                inputNum.error = "Enter Mobile Number";
            }
            if (inputtedMPIN.trim().length != 4) {
                inputMPIN.error = "MPIN must be 4 digits"
            }
            if(numInputted == "09123456789" && inputtedMPIN == "1234"){
                startActivity(intent)
            }
        }
    }
    private fun checkFieldsForEmptyValues() {
        val b = findViewById<View>(R.id.button4) as Button
        val inputNum = findViewById<EditText>(R.id.editTextPhone) as EditText
        val inputMPIN = findViewById<EditText>(R.id.editTextNumberPassword) as EditText
        val s1: String = inputNum.text.toString()
        val s2: String = inputMPIN.text.toString()
        if (s1 == "" && s2 == "") {
            b.isEnabled = false
        } else if (s1 != "" && s2 == "") {
            b.isEnabled = false
        } else b.isEnabled = !(s2 != "" && s1 == "")
    }
}