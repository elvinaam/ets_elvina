package com.example.innobridge.mahasiswa

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobridge.R

class SubmissionFragment : Fragment(R.layout.fragment_submission) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            Toast.makeText(requireContext(), "Proposal Berhasil Dikirim!", Toast.LENGTH_SHORT).show()
            // Kembali ke Beranda setelah submit
            findNavController().popBackStack(R.id.berandaFragment, false)
        }
    }
}