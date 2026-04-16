package com.example.innobridge.mahasiswa

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innobridge.R

class BerandaFragment : Fragment(R.layout.fragment_beranda) {

    private lateinit var rvChallenge: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvChallenge = view.findViewById(R.id.rvChallenge)

        val listChallenge = listOf(
            Challenge("Smart Waste Management", "PT EcoTech", "Lingkungan", "Solusi pengelolaan sampah berbasis IoT."),
            Challenge("AI for Education", "EduTech Corp", "IT", "Platform pembelajaran adaptif menggunakan AI."),
            Challenge("Renewable Energy Tracker", "GreenEnergy", "Energi", "Sistem monitoring energi terbarukan.")
        )

        val adapter = ChallengeAdapter(listChallenge) { challenge ->
            // Gunakan Action dari nav_graph
            findNavController().navigate(R.id.action_berandaFragment_to_detailFragment)
        }

        rvChallenge.layoutManager = LinearLayoutManager(requireContext())
        rvChallenge.adapter = adapter
    }
}