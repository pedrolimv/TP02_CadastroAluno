package com.example.tp02_cadastroaluno.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp02_cadastroaluno.R
import com.example.tp02_cadastroaluno.model.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeAluno = findViewById<EditText>(R.id.edtNomeAluno)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fabAvanca)

        var aluno = Aluno("Sem aluno", "Sem matrícula")

        btnCadastrar.setOnClickListener {
            val nome = edtNomeAluno.text.toString()

            aluno = Aluno(nome, "Sem matrícula")

            alertaSucesso()
            edtNomeAluno.text.clear()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, AlunoActivity::class.java)
            intent.putExtra("nomeAluno", aluno.nomeAluno)
            intent.putExtra("matriculaAluno", aluno.matriculaAluno)
            startActivity(intent)
        }
    }
    fun alertaSucesso() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sucesso")
        builder.setMessage("Aluno cadastrado!")
        var alert = builder.create()
        alert.show()
    }
}