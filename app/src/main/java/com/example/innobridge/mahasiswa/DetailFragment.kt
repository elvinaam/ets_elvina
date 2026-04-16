package com.example.innobridge.mahasiswa

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobridge.R

class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        fun newInstance(
            judul: String,
            perusahaan: String,
            kategori: String,
            deskripsi: String
        ): DetailFragment {

            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString("judul", judul)
            bundle.putString("perusahaan", perusahaan)
            bundle.putString("kategori", kategori)
            bundle.putString("deskripsi", deskripsi)

            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvJudul: TextView = view.findViewById(R.id.tvJudul)
        val tvPerusahaan: TextView = view.findViewById(R.id.tvPerusahaan)
        val tvKategori: TextView = view.findViewById(R.id.tvKategori)
        val tvDeskripsi: TextView = view.findViewById(R.id.tvDeskripsi)

        // Ambil data dari Bundle
        val judul = arguments?.getString("judul")
        val perusahaan = arguments?.getString("perusahaan")
        val kategori = arguments?.getString("kategori")
        val deskripsi = arguments?.getString("deskripsi")

        tvJudul.text = judul
        tvPerusahaan.text = perusahaan
        tvKategori.text = kategori
        tvDeskripsi.text = deskripsi

        val btnKirimProposal: Button = view.findViewById(R.id.btnKirimProposal)
        btnKirimProposal.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_submissionFragment)
        }
    }
}