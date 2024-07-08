package com.example.uxcamptest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.uxcamptest.databinding.FragmentSecondBinding
import com.uxcamp.analytics.AnalyticsSingleton
import com.uxcamp.analytics.data.Event

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            val event = Event("UserAction", mapOf("action" to "button_click", "label" to "Previous Button"))
            AnalyticsSingleton.addEvent(event)

        }
        binding.butttonEndSession.setOnClickListener{
            val event = Event("UserAction", mapOf("action" to "button_click", "label" to "End Session"))
            AnalyticsSingleton.addEvent(event)
            AnalyticsSingleton.stopSession()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}