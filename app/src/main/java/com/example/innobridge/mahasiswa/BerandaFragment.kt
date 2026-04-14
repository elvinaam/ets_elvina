package com.example.innobridge.mahasiswa

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innobridge.R

class BerandaFragment : Fragment(R.layout.fragment_beranda) {

    private lateinit var rvChallenge: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvChallenge = view.findViewById(R.id.rvChallenge)

        // ✅ Dummy Data (Sprint 1)
        val listChallenge = listOf(
            Challenge(
                "Smart Waste Management",
                "PT EcoTech",
                "Lingkungan",
                "Solusi pengelolaan sampah berbasis IoT untuk kota pintar."
            ),
            Challenge(
                "AI for Education",
                "EduTech Corp",
                "IT",
                "Platform pembelajaran adaptif menggunakan Artificial Intelligence."
            ),
            Challenge(
                "Renewable Energy Tracker",
                "GreenEnergy",
                "Energi",
                "Sistem monitoring energi terbarukan secara real-time."
            )
        )

        // ✅ Adapter
        val adapter = ChallengeAdapter(listChallenge) { challenge ->

            // Kirim data ke DetailFragment
            val fragment = DetailFragment.newInstance(
                challenge.judul,
                challenge.perusahaan,
                challenge.kategori,
                challenge.deskripsi
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, fragment)
                .addToBackStack(null)
                .commit()
        }

        rvChallenge.layoutManager = LinearLayoutManager(requireContext())
        rvChallenge.adapter = adapter
    }
}