package com.example.appmultiview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Math.pow
import kotlin.math.pow


class ImcActivity : AppCompatActivity() {

    private lateinit var txtPeso: EditText
    private lateinit var txtAltura: EditText

    private lateinit var lbImc: TextView
    private lateinit var lbCategoria: TextView

    private lateinit var bttCalcular: Button
    private lateinit var bttSair: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)

        lbImc = findViewById(R.id.lbImc)
        lbCategoria = findViewById(R.id.lbCategoria)

        bttCalcular = findViewById(R.id.bttCalcular)
        bttSair = findViewById(R.id.bttSair)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bttCalcular.setOnClickListener {
            calcularImc()

        }

        bttSair.setOnClickListener {
            val telaMenu = Intent(this, MenuActivity::class.java)
            startActivity(telaMenu)
            finish()
        }
    }

    fun calcularImc(){
        var peso: Double = txtPeso.text.toString().toDouble()
        var altura: Double = txtAltura.text.toString().toDouble()
        var categoria: String = ""

        var imc: Double = peso * (altura*altura)

        lbImc.text = imc.toString()

        Toast.makeText(this, imc.toString(), Toast.LENGTH_LONG).show()

        if(imc < 18.5){
            categoria = "Abaixo do peso"
        } else if (imc >= 18.5 && imc < 24.9){
            categoria = "Peso adequado"
        }else if (imc >= 24.9 && imc < 29.9){
            categoria = "Sobrepeso"
        }else if (imc >= 29.9 && imc < 39.9){
            categoria = "Obesidade"
        }else if (imc >= 40){
            categoria = "Obesidade grave"
        }

        lbCategoria.text = categoria
    }


}