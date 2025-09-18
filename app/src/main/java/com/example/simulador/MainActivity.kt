package com.example.simulador

import android.app.Activity
import android.os.Bundle
import android.renderscript.ScriptGroup
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
    // teste 2
        val items = listOf("masculino", "feminino")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        binding.spinner.adapter = adapter

        binding.ButtonCalcular.setOnClickListener {
            val SexoSelecionado = binding.spinner.selectedItem as String
            var idade = binding.TextIdade.text.toString().toLong()
            var result: long
            if (idade!=null) {
                if (SexoSelecionado.trim().lowercase()="masculino") {
                    result = 65 - idade
                }
            } else {
                binding.TextViewResultado.text="informe uma idade"
            }
        }
    }
}