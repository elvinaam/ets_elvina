package com.example.innobridge.mahasiswa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.innobridge.R
import com.example.innobridge.databinding.FragmentPortfolioBinding

class PortfolioFragment : Fragment() {

    private var _binding: FragmentPortfolioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPortfolioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dummyData = listOf(
            Proposal("AI Education", "Platform belajar AI", "Under Review"),
            Proposal("Green Energy", "Monitoring energi", "Accepted"),
            Proposal("Smart City App", "Aplikasi kota pintar", "Rejected")
        )

        binding.rvPortfolio.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPortfolio.adapter = PortfolioAdapter(dummyData)

        binding.btnToPostChallenge.setOnClickListener {
            findNavController().navigate(R.id.action_portfolioFragment_to_postChallengeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}