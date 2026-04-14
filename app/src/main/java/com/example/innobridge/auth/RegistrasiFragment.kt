package com.example.innobridge.auth

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobridge.R

class RegistrasiFragment : Fragment(R.layout.fragment_registrasi) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = view.findViewById<EditText>(R.id.etNama)
        val email = view.findViewById<EditText>(R.id.etEmail)
        val password = view.findViewById<EditText>(R.id.etPassword)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)
        val btnLogin = view.findViewById<TextView>(R.id.btnLogin)

        btnRegister.setOnClickListener {
            val n = nama.text.toString()
            val e = email.text.toString()
            val p = password.text.toString()

            if (n.isNotEmpty() && e.isNotEmpty() && p.isNotEmpty()) {
                Toast.makeText(requireContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show()

                // 🔙 Kembali ke login menggunakan popBackStack agar lebih efisien
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
            }
        }

        btnLogin.setOnClickListener {
            // 🔙 Kembali ke login
            findNavController().popBackStack()
        }
    }
}
