package com.example.appmultiview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ImcActivity : AppCompatActivity() {

    private lateinit var txtPeso: EditText
    private lateinit var txtAltura: EditText

    private lateinit var lbImc: TextView
    private lateinit var lbCategoria: TextView

    private lateinit var bttCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)

        lbImc = findViewById(R.id.lbImc)
        lbCategoria = findViewById(R.id.lbCategoria)

        bttCalcular = findViewById(R.id.bttCalcular)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bttCalcular.setOnClickListener {
            calcularImc()
        }
    }

    fun calcularImc(){

    }
}