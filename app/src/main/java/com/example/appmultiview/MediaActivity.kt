package com.example.appmultiview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MediaActivity : AppCompatActivity() {

    private lateinit var txtNota1 : EditText
    private lateinit var txtNota2 : EditText
    private lateinit var txtFaltas : EditText

    private lateinit var lbNotaFinal : TextView
    private lateinit var lbSituacao : TextView

    private lateinit var bttCalcular : Button
    private lateinit var bttLimpar : Button
    private lateinit var bttSair : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media)

        txtNota1 = findViewById(R.id.txtNota1)
        txtNota2 = findViewById(R.id.txtNota2)
        txtFaltas = findViewById(R.id.txtFaltas)

        lbNotaFinal = findViewById(R.id.lbNotaFinal)
        lbSituacao = findViewById(R.id.lbSituacao)

        bttCalcular = findViewById(R.id.bttCalcular)
        bttLimpar = findViewById(R.id.bttLimpar)
        bttSair = findViewById(R.id.bttSair)

        bttCalcular.setOnClickListener() {
            calcular()
        }

        bttLimpar.setOnClickListener() {
            limpar()
        }

        bttSair.setOnClickListener() {
            sair()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcular(){
        //As variáveis podem ser decladas por separado ou na hora da atribuição
        //Além disso, "não precisa" declarar o tipo da variável, a linguagem
        //atribui o tipo segundo o valor que recebe

        //Ex: *Criação com tipo
        var nota1: Double //Variáveis
        var notaFinal: Double
        var situacao: String

        //*Atribuição
        nota1 = txtNota1.text.toString().toDouble()

        // Criação sem tipo e atribuição direta
        val nota2 = txtNota2.text.toString().toDouble()

        notaFinal = (nota1 + nota2)/2
        if (notaFinal >= 6){
            situacao = "Aprovado"
        }
        else{
            situacao = "Exame"
        }

        lbNotaFinal.text = notaFinal.toString()
        lbSituacao.text = situacao
    }

    private fun limpar(){
        txtNota1.setText("")
        txtNota2.setText("")
        txtFaltas.setText("")
        lbNotaFinal.text = ""
        lbSituacao.text = ""

        txtNota1.requestFocus()
    }

    private fun sair(){
        val telaMenu = Intent(this, MenuActivity::class.java)
        startActivity(telaMenu)
        finish()
    }
}