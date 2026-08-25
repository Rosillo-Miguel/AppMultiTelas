package com.example.appmultiview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtSenha: EditText

    private lateinit var bttLogin: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        txtUsuario = findViewById(R.id.txtUsuario)
        txtSenha = findViewById(R.id.txtSenha)

        bttLogin = findViewById(R.id.bttLogin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bttLogin.setOnClickListener {
//            Toast.makeText(this, "Hello Wrold", Toast.LENGTH_SHORT).show()
            auth(txtUsuario.text.toString(), txtSenha.text.toString())
        }
    }

    fun auth(usuario: String, senha: String){
        if (usuario == "admin" && senha == "admin123"){
            login()
        } else {
            Toast.makeText(this, "Usuario ou senha incorretos, tente novamente",
                Toast.LENGTH_SHORT).show()
        }

    }

    fun login(){
        val telaMenu = Intent(this, MenuActivity::class.java)
        startActivity(telaMenu)
        finish()
    }
}