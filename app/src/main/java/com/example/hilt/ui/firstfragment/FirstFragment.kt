package com.example.hilt.ui.firstfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hilt.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job


@AndroidEntryPoint
class FirstFragment : Fragment() {


    private val viewModel : FirstFragmentViewModel by viewModels()
    private lateinit var fetchJob : Job


    private var _bindnig: FragmentFirstBinding? = null
    private val binding get() = _bindnig!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindnig = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fetchJob = viewModel.fetchData()
        observeData()

        initView()
    }



    private fun observeData(){
        viewModel.list.observe(viewLifecycleOwner){
            Log.e("list", it.toString())
        }


        viewModel.clickEvent.observe(viewLifecycleOwner){
            Log.e("ButtonListener", "SingleLiveEventObserve")
        }
    }


    private fun initView() = with(binding){
        binding.testButton.setOnClickListener {
            viewModel.clickButton()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _bindnig = null
    }

    override fun onDestroy() {
        if(fetchJob.isActive) {
            fetchJob.cancel()
        }

        super.onDestroy()
    }







    companion object {
        const val TAG = "FirstFragment"
    }
}