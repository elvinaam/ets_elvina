package com.example.innobridge.auth

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.innobridge.R
import com.example.innobridge.mahasiswa.BerandaFragment
import com.example.innobridge.perusahaan.PostChallengeFragment

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

                // 🔥 Dummy role
                val fragment = if (e.contains("mhs")) {
                    BerandaFragment() // mahasiswa
                } else {
                    PostChallengeFragment() // perusahaan
                }

                Toast.makeText(requireContext(), "Login Berhasil", Toast.LENGTH_SHORT).show()

                // 🔀 PINDAH FRAGMENT (AMAN)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, fragment)
                    .commit()

            } else {
                Toast.makeText(requireContext(), "Isi semua field!", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener {
            // 🔀 PINDAH KE REGISTER (tanpa Navigation)
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, RegistrasiFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}