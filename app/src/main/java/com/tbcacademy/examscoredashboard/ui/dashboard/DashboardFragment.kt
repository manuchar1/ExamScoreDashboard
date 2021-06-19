package com.tbcacademy.examscoredashboard.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tbcacademy.examscoredashboard.adapter.TeamsAdapter
import com.tbcacademy.examscoredashboard.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var adapter = TeamsAdapter()

    private val viewModel by viewModels<DashboardViewModel>()
    private lateinit var binding: FragmentDashboardBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()

        viewModel._teamsLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            hideProgressBar()

        })

        viewModel.init()
        initRecycler()
    }

    private fun initRecycler() {
        adapter = TeamsAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter = adapter
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE

    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

}