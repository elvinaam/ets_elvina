package com.example.innobridge.perusahaan

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innobridge.R
import com.google.android.material.card.MaterialCardView

class ManageProposalFragment : Fragment(R.layout.fragment_manage_proposal) {

    private lateinit var rvProposals: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvProposals = view.findViewById(R.id.rvProposals)

        val dataProposal = listOf(
            "Solusi AI untuk SDGs 9",
            "Sistem Monitoring Air Bersih",
            "Inovasi Energi Terbarukan",
            "Platform Kolaborasi Lintas Disiplin",
            "Manajemen Limbah Digital"
        )

        rvProposals.layoutManager = LinearLayoutManager(requireContext())
        rvProposals.adapter = ProposalAdapter(dataProposal)
    }

    // Adapter
    class ProposalAdapter(private val listProposal: List<String>) :
        RecyclerView.Adapter<ProposalAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvNama: TextView = view.findViewById(R.id.tvNamaMahasiswa)
            val tvJudul: TextView = view.findViewById(R.id.tvJudulSolusi)
            val cvStatus: MaterialCardView = view.findViewById(R.id.cvStatusLabel)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_proposal, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.tvNama.text = "Mahasiswa Inovator ${position + 1}"
            holder.tvJudul.text = listProposal[position]
        }

        override fun getItemCount(): Int = listProposal.size
    }
}