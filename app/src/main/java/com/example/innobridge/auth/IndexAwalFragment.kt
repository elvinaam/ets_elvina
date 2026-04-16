package com.example.innobridge.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobridge.R
import com.example.innobridge.databinding.FragmentIndexAwalBinding

class IndexAwalFragment : Fragment() {

    private var _binding: FragmentIndexAwalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIndexAwalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLoginMahasiswa.setOnClickListener {
            findNavController().navigate(R.id.action_indexAwalFragment_to_loginMahasiswaFragment)
        }

        binding.btnLoginPerusahaan.setOnClickListener {
            findNavController().navigate(R.id.action_indexAwalFragment_to_loginPerusahaanFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}