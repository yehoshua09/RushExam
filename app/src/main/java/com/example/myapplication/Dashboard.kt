@file:Suppress("DEPRECATION")

package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.BitmapCompat
import com.example.myapplication.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(findViewById(R.id.toolbar))
//        binding.toolbarLayout.title = title
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        val image1 = findViewById<ImageView>(R.id.imageView3)
        val image2 = findViewById<ImageView>(R.id.imageView5)
        val name1 = findViewById<TextView>(R.id.textView5)
        val desc1 = image1.contentDescription
        val name2 = findViewById<TextView>(R.id.textView8)
        val desc2 = image2.contentDescription
        var imageMcdo = R.drawable.symbol_mcdonalds
        var imageLazada = R.drawable.lazada

        image1.setOnClickListener {
            val intent = Intent(this, RewardDetailsActivity::class.java)

            intent.putExtra("name", name1.text)
            intent.putExtra("desc", desc1.toString())
            intent.putExtra("image", imageMcdo)

            startActivity(intent)
        }

        image2.setOnClickListener {
            val intent = Intent(this, RewardDetailsActivity::class.java)

            intent.putExtra("name", name2.text)
            intent.putExtra("desc", desc2.toString())
            intent.putExtra("image", imageLazada)

            startActivity(intent)
        }

    }
}