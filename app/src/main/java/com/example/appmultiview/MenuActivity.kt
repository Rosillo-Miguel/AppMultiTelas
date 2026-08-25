package com.example.appmultiview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    private lateinit var bttAppMedia : Button
    private lateinit var bttAppImc : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        bttAppMedia = findViewById(R.id.bttAppMedia)
        bttAppImc = findViewById(R.id.bttAppImc)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bttAppImc.setOnClickListener {
            val telaImc = Intent(this, ImcActivity::class.java)
            startActivity(telaImc)
            finish()
        }

        bttAppMedia.setOnClickListener {
            val telaMedia = Intent(this, MediaActivity::class.java)
            startActivity(telaMedia)
            finish()
        }
    }
}