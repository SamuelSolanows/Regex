package com.example.regex

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.regex.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        validarCorreo()
        binding.btnLimpiar.setOnClickListener {
            Limpiar()
        }
        binding.btnGuardar.setOnClickListener {
            Validacion()
        }
    }


    fun validarCorreo() {
        binding.apply {
            txtcorreo.addTextChangedListener {
                var valido = Pattern.matches(
                    "^[A-Za-z]{1}[A-Za-z0-9]{3,}([-._]||)[A-Za-z0-9]{4,}@[a-z]{3,}[.][a-z]{2,}",
                    txtcorreo.text
                )
                if (valido) {
                    txtcorreo.setTextColor(Color.GREEN)

                } else {
                    txtcorreo.setTextColor(Color.RED)
                }
            }
        }
    }

    fun Validacion() {
        binding.apply {
            if (txtname.text.isNotEmpty() && txtapellido.text.isNotEmpty() && txtcelular.text.isNotEmpty()) {
                Enviardatos()
            } else {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Error").setIcon(R.drawable.baseline_error_24)
                    .setMessage("Error al intentar guardar los campos, verifique que la informacion sea correcta")
                    .setPositiveButton("Aceptar") { dialog, which ->
                        // Acción cuando se hace clic en el botón Aceptar
                    }
                    .show()
                //Toast.makeText(this@MainActivity, "Error al guardar, campos invalidos", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun Enviardatos() {
        binding.apply {
            startActivity(
                Intent(this@MainActivity, Mostarar::class.java)
                    .putExtra("nombre", txtname.text)
                    .putExtra("apellido", txtapellido.text)
                    .putExtra("celular", txtcelular.text)
                    .putExtra("correo", txtcorreo.text)
            )
        }
    }

    fun Limpiar() {
        binding.apply {
            txtname.setText("")
            txtapellido.setText("")
            txtcelular.setText("")
            txtcorreo.setText("")

        }
    }
}