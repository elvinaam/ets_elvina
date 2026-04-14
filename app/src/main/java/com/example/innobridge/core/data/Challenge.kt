package com.example.innobridge.core.data

// Perhatikan tanda koma di setiap akhir baris variabelnya
data class Challenge(
    val judul: String,
    val namaPerusahaan: String,
    val kategoriSDGs: String,
    val deskripsiMasalah: String,
    val deadline: String
)