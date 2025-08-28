package com.example.tp02_cadastroaluno.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp02_cadastroaluno.R
import com.example.tp02_cadastroaluno.model.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvNomeAluno = findViewById<TextView>(R.id.txvNomeAluno)
        val txvMatriculaAluno = findViewById<TextView>(R.id.txvMatriculaAluno)
        val btnGeraMatricula = findViewById<Button>(R.id.btnGeraMatricula)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fabVolta)

        val nome = intent.getStringExtra("nomeAluno").toString()

        btnGeraMatricula.setOnClickListener {
            if(nome == "Sem aluno" || nome == "") {
                txvNomeAluno.text = "Sem aluno"
                txvMatriculaAluno.text = "Sem matrícula"
                alertaErro()
            }
            else {
                val matricula = Random.nextInt(100000, 999999).toString()
                var aluno = Aluno(nome, matricula)

                txvNomeAluno.text = aluno.nomeAluno.toString()
                txvMatriculaAluno.text = aluno.matriculaAluno.toString()

                alertaSucesso()
            }
        }

        fabVolta.setOnClickListener {
            finish()
        }
    }
    fun alertaSucesso() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sucesso")
        builder.setMessage("Matrícula gerada!")
        var alert = builder.create()
        alert.show()
    }
    fun alertaErro() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Erro")
        builder.setMessage("Matrícula não gerada!")
        var alert = builder.create()
        alert.show()
    }
}