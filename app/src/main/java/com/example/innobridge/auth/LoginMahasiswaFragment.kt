package com.example.innobridge.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobridge.R
import com.example.innobridge.databinding.FragmentLoginMahasiswaBinding

class LoginMahasiswaFragment : Fragment() {

    private var _binding: FragmentLoginMahasiswaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginMahasiswaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val email = binding.etEmail.text.toString()
            val universitas = binding.etUniversitas.text.toString()

            if (nama.isNotEmpty() && email.isNotEmpty() && universitas.isNotEmpty()) {
                Toast.makeText(requireContext(), "Login Mahasiswa Berhasil", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginMahasiswaFragment_to_berandaFragment)
            } else {
                Toast.makeText(requireContext(), "Isi semua field!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginMahasiswaFragment_to_registrasiFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}