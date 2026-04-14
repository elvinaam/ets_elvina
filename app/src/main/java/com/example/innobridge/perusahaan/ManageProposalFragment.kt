package com.example.innobridge.perusahaan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innobridge.R
import com.google.android.material.card.MaterialCardView

class ManageProposalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_manage_proposal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvProposals = view.findViewById<RecyclerView>(R.id.rvProposals)

        // Data dummy untuk simulasi list proposal mahasiswa
        val dataProposal = listOf(
            "Solusi AI untuk SDGs 9",
            "Sistem Monitoring Air Bersih",
            "Inovasi Energi Terbarukan",
            "Platform Kolaborasi Lintas Disiplin",
            "Manajemen Limbah Digital"
        )

        rvProposals.layoutManager = LinearLayoutManager(context)
        rvProposals.adapter = ProposalAdapter(dataProposal)
    }

    // --- ADAPTER DALAM SATU FILE ---
    private class ProposalAdapter(private val listProposal: List<String>) :
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
            // Label status otomatis berwarna True Blue dari XML
        }

        override fun getItemCount(): Int = listProposal.size
    }
}