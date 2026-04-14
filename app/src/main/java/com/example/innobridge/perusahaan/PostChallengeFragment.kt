package com.example.innobridge.perusahaan

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.innobridge.R
import java.util.Calendar

class PostChallengeFragment : Fragment() {

    private lateinit var etJudul: EditText
    private lateinit var etKategori: EditText
    private lateinit var etDeadline: EditText
    private lateinit var etDeskripsi: EditText
    private lateinit var btnPost: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_post_challenge, container, false)

        // Inisialisasi komponen
        etJudul = view.findViewById(R.id.etJudulChallenge)
        etKategori = view.findViewById(R.id.etKategoriSDG)
        etDeadline = view.findViewById(R.id.etDeadlineChallenge)
        etDeskripsi = view.findViewById(R.id.etDeskripsiMasalah)
        btnPost = view.findViewById(R.id.btnPostChallenge)

        // 🔹 Date Picker untuk deadline
        etDeadline.setOnClickListener {
            showDatePicker()
        }

        // 🔹 Tombol submit
        btnPost.setOnClickListener {
            submitChallenge()
        }

        return view
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            requireContext(),
            { _, y, m, d ->
                val selectedDate = "$d/${m + 1}/$y"
                etDeadline.setText(selectedDate)
            },
            year, month, day
        )
        datePicker.show()
    }

    private fun submitChallenge() {
        val judul = etJudul.text.toString()
        val kategori = etKategori.text.toString()
        val deadline = etDeadline.text.toString()
        val deskripsi = etDeskripsi.text.toString()

        if (judul.isEmpty() || kategori.isEmpty() || deadline.isEmpty() || deskripsi.isEmpty()) {
            Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            return
        }

        // 🔥 Sementara tampilkan hasil (nanti bisa konek ke database/API)
        Toast.makeText(
            requireContext(),
            "Challenge berhasil dipost!",
            Toast.LENGTH_LONG
        ).show()

        // Reset form
        etJudul.text.clear()
        etKategori.text.clear()
        etDeadline.text.clear()
        etDeskripsi.text.clear()
    }
}