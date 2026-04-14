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

    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var btnLogin: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 Inisialisasi View
        etNama = view.findViewById(R.id.etNama)
        etEmail = view.findViewById(R.id.etEmail)
        etPassword = view.findViewById(R.id.etPassword)
        btnRegister = view.findViewById(R.id.btnRegister)
        btnLogin = view.findViewById(R.id.btnLogin)

        // 🔹 Aksi tombol register
        btnRegister.setOnClickListener {
            handleRegister()
        }

        // 🔹 Kembali ke login
        btnLogin.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun handleRegister() {
        val nama = etNama.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // ✅ Validasi input
        if (nama.isEmpty()) {
            etNama.error = "Nama tidak boleh kosong"
            etNama.requestFocus()
            return
        }

        if (email.isEmpty()) {
            etEmail.error = "Email tidak boleh kosong"
            etEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etPassword.error = "Password tidak boleh kosong"
            etPassword.requestFocus()
            return
        }

        if (password.length < 6) {
            etPassword.error = "Password minimal 6 karakter"
            etPassword.requestFocus()
            return
        }

        // ✅ Simulasi registrasi berhasil
        Toast.makeText(requireContext(), "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()

        // 🔙 Kembali ke Login
        findNavController().popBackStack()
    }
}