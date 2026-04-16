package com.example.innobridge.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobridge.R
import com.example.innobridge.databinding.FragmentRegistrasiBinding

class RegistrasiFragment : Fragment() {

    private var _binding: FragmentRegistrasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegisterMahasiswa.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val email = binding.etEmail.text.toString()
            val univAtauPerusahaan = binding.etUnivAtauPerusahaan.text.toString()

            if (nama.isNotEmpty() && email.isNotEmpty() && univAtauPerusahaan.isNotEmpty()) {
                Toast.makeText(requireContext(), "Daftar Mahasiswa Berhasil", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_registrasiFragment_to_berandaFragment)
            } else {
                Toast.makeText(requireContext(), "Isi semua field!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegisterPerusahaan.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val email = binding.etEmail.text.toString()
            val univAtauPerusahaan = binding.etUnivAtauPerusahaan.text.toString()

            if (nama.isNotEmpty() && email.isNotEmpty() && univAtauPerusahaan.isNotEmpty()) {
                Toast.makeText(requireContext(), "Daftar Perusahaan Berhasil", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_registrasiFragment_to_portfolioFragment)
            } else {
                Toast.makeText(requireContext(), "Isi semua field!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}