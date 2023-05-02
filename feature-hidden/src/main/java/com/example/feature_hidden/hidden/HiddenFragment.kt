package com.example.feature_hidden.hidden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.feature_hidden.R
import com.example.feature_hidden.databinding.FragmentHiddenBinding

class HiddenFragment : Fragment() {
    private val args: HiddenFragmentArgs by navArgs()

    private var _binding: FragmentHiddenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val hiddenViewModel =
            ViewModelProvider(this).get(HiddenViewModel::class.java)

        _binding = FragmentHiddenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHidden
        hiddenViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

//         Get the adminId from the arguments
        val adminId = args.adminId
        hiddenViewModel.resetText("Get adminId: $adminId")

        binding.textHidden.setOnClickListener {
            findNavController().navigate(R.id.action_hiddenFragment_to_hiddenFragment2)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}