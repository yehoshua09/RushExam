package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val backButton = findViewById<Button>(R.id.button5) as Button
        val regButton = findViewById<Button>(R.id.button6) as Button
        val firstName = findViewById<EditText>(R.id.editTextTextPersonName) as EditText
        val lastName = findViewById<EditText>(R.id.editTextTextPersonName2) as EditText
        val inputNum = findViewById<EditText>(R.id.editTextPhone2) as EditText
        val inputMPIN = findViewById<EditText>(R.id.editTextNumberPassword2) as EditText
        val confirmInputMPIN = findViewById<EditText>(R.id.editTextNumberPassword3) as EditText
        val showHidePass = findViewById<ImageView>(R.id.imageView) as ImageView

        showHidePass.setOnClickListener {
            if(inputMPIN.transformationMethod.equals(PasswordTransformationMethod.getInstance())){
                inputMPIN.transformationMethod = HideReturnsTransformationMethod.getInstance()
                confirmInputMPIN.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else{
                inputMPIN.transformationMethod = PasswordTransformationMethod.getInstance()
                confirmInputMPIN.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        regButton.setOnClickListener {
            var numInputted = inputNum.text.toString().trim()
            var inputtedMPIN = inputMPIN.text.toString().trim()
            var fname = firstName.text.toString().trim()
            var lname = lastName.text.toString().trim()
            var confirmMPIN = confirmInputMPIN.text.toString().trim()

            var isValidated : Boolean = true

            if (TextUtils.isEmpty(fname)){
                isValidated = false
                firstName.error = "Enter first name"
            }
            if (TextUtils.isEmpty(lname)){
                isValidated = false
                firstName.error = "Enter last name"
            }
            if (TextUtils.isEmpty(inputtedMPIN)) {
                isValidated = false
                inputMPIN.error = "Enter password";
            }
            if (TextUtils.isEmpty(numInputted)) {
                isValidated = false
                inputNum.error = "Enter Mobile Number";
            }
            if (inputtedMPIN.length != 4){
                isValidated = false
                inputMPIN.error = "MPIN must be 4 digits"
            }
            if (inputtedMPIN != confirmMPIN){
                isValidated = false
                confirmInputMPIN.error = "Password does not match"
            }

            if(isValidated){
                val intent = Intent(this,Dashboard::class.java)

                startActivity(intent)
            }
        }
    }
}