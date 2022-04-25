package com.example.parcialii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.parcialii.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val nombreProducto = binding.editTextTextPersonName.text.toString()
            val cantidad = binding.editTextTextPersonName2.text.toString()
            val nombreCliente = binding.editTextTextPersonName3.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Products")
            val Product = Product(nombreProducto, cantidad, nombreCliente)
            database.child(nombreProducto).setValue(Product).addOnSuccessListener {

                binding.editTextTextPersonName.text.clear()
                binding.editTextTextPersonName2.text.clear()
                binding.editTextTextPersonName3.text.clear()


                Toast.makeText(this, "¡El registro se ha guardado exitósamente!", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this, "¡Ha ocurrido un error al guardar el registro!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}