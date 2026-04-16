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
                Toast.makeText(requireContext(), "Login Berhasil", Toast.LENGTH_SHORT).show()
                
                if (e.contains("mhs")) {
                    findNavController().navigate(R.id.action_loginFragment_to_berandaFragment)
                } else {
                    findNavController().navigate(R.id.action_loginFragment_to_postChallengeFragment)
                }
            } else {
                Toast.makeText(requireContext(), "Isi semua field!", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrasiFragment)
        }
    }
}