package com.example.feature_hidden.hidden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.feature_hidden.R
import com.example.feature_hidden.databinding.FragmentHiddenBinding

class HiddenFragment3 : Fragment() {

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
        hiddenViewModel.resetText("This is hidden Fragment 3 ~~~~")
        hiddenViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        binding.textHidden.setOnClickListener {
            val adminId = "3To1"
            //如果沒有defaultValue , 則會變成建構參數
            //若有設定defaultValue , 則呼叫setter
            val action = HiddenFragment3Directions.actionHiddenFragment3ToHiddenFragment().apply {
                setAdminId(adminId)
            }
            findNavController().navigate(action)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}