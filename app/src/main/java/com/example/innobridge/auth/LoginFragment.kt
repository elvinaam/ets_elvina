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

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnRegister = view.findViewById<TextView>(R.id.btnRegister)

        val email = view.findViewById<EditText>(R.id.etEmail)
        val password = view.findViewById<EditText>(R.id.etPassword)

        btnLogin.setOnClickListener {
            val e = email.text.toString()
            val p = password.text.toString()

            if (e.isNotEmpty() && p.isNotEmpty()) {

                // 🔥 Dummy Auth + Role
                val role = if (e.contains("mhs")) "mahasiswa" else "perusahaan"

                Toast.makeText(requireContext(), "Login Berhasil sebagai $role", Toast.LENGTH_SHORT).show()

                // 🔀 Navigasi (ID disesuaikan dengan nav_graph.xml)
                // Karena destination 'home' belum ada di nav_graph, baris ini dikomentari agar tidak error
                // findNavController().navigate(R.id.action_loginFragment_to_home)

            } else {
                Toast.makeText(requireContext(), "Isi semua field!", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener {
            // Memperbaiki baris 44: Menggunakan ID action yang benar dari nav_graph.xml
            findNavController().navigate(R.id.action_loginFragment_to_registrasiFragment)
        }
    }
}
