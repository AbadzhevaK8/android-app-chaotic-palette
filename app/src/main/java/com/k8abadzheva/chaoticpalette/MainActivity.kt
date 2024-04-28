package com.k8abadzheva.chaoticpalette

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val colorView1 = findViewById<View>(R.id.colorView1)
        val colorView2 = findViewById<View>(R.id.colorView2)
        val colorView3 = findViewById<View>(R.id.colorView3)
        val colorView4 = findViewById<View>(R.id.colorView4)
        val colorView5 = findViewById<View>(R.id.colorView5)
        val colorView6 = findViewById<View>(R.id.colorView6)
        val colorView7 = findViewById<View>(R.id.colorView7)

        val btnGenerate = findViewById<Button>(R.id.btn_generate)

        setColors(colorView1, colorView2, colorView3, colorView4, colorView5, colorView6, colorView7)

        btnGenerate.setOnClickListener{
            setColors(colorView1, colorView2, colorView3, colorView4, colorView5, colorView6, colorView7)
        }
    }

    private fun setColors(vararg views: View) {
        for (view in views) {
            view.setBackgroundColor(Color.parseColor(generateRandomColorHex()))
        }
    }


    private fun generateRandomColorHex(): String {

        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)

        return String.format("#%02X%02X%02X", red, green, blue)
    }


}