package com.example.simulador

import android.app.Activity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simulador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = listOf("masculino", "feminino")

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, items
        )

        binding.spinner.adapter = adapter

        binding.ButtonCalcular.setOnClickListener {
            var SexoSelecionado = binding.spinner.selectedItem.toString()
            var idadeString = binding.TextIdade.text.toString()
            if (idadeString!="") {
                var idade = idadeString.toLong()
                var resultado: Long
                var resultadoString: String
                if (SexoSelecionado.trim().lowercase() == "masculino") {
                    resultado = 65 - idade
                } else {
                    resultado = 62 - idade
                }

                if (resultado > 0) {

                    if (resultado == 1L) {
                        resultadoString = "falta 1 ano para você se aposentar"
                    } else {
                        resultadoString =
                            "faltam " + resultado.toString() + " anos para você se aposentar"
                    }
                    binding.TextViewResultado.text = resultadoString
                } else {
                    binding.TextViewResultado.text = "Você já pode se aposentar"
                }

            } else {
                binding.TextViewResultado.text="informe uma idade"
            }
        }
    }
}