package com.example.innobridge.perusahaan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.innobridge.R
import com.example.innobridge.core.data.Challenge

class PostChallengeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_challenge, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etJudul = view.findViewById<EditText>(R.id.etJudulChallenge)
        val etKategori = view.findViewById<EditText>(R.id.etKategoriSDG)
        val etDeadline = view.findViewById<EditText>(R.id.etDeadlineChallenge)
        val etDeskripsi = view.findViewById<EditText>(R.id.etDeskripsiMasalah)
        val btnPost = view.findViewById<Button>(R.id.btnPostChallenge)

        btnPost.setOnClickListener {
            val judul = etJudul.text.toString()
            val kategori = etKategori.text.toString()
            val deadline = etDeadline.text.toString()
            val deskripsi = etDeskripsi.text.toString()

            if (judul.isEmpty() || kategori.isEmpty() || deadline.isEmpty() || deskripsi.isEmpty()) {
                Toast.makeText(context, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Tantangan Berhasil Dipublikasikan!", Toast.LENGTH_LONG).show()

                etJudul.text.clear()
                etKategori.text.clear()
                etDeadline.text.clear()
                etDeskripsi.text.clear()
            }
        }
    }
}