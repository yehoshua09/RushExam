package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class RewardDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward_details)

        val backButton = findViewById<ImageButton>(R.id.imageButton)
        val image = findViewById<ImageView>(R.id.imageView4)
        val name = findViewById<TextView>(R.id.textView6)
        val desc = findViewById<TextView>(R.id.textView7)
        val bundle : Bundle? = intent.extras

        val resId : Int? = bundle?.getInt("image")
        val resName : String? = bundle?.getString("name")
        val resDesc: String? = bundle?.getString("desc")

        name.text = resName
        desc.text = resDesc

        if (resId != null) {
            image.setImageResource(resId)
        }

        backButton.setOnClickListener{
            val intent = Intent(this, Dashboard::class.java)

            startActivity(intent)
        }


    }
}