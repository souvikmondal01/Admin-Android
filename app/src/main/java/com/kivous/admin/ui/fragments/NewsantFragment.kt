package com.kivous.admin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.kivous.admin.databinding.FragmentNewsantBinding

class NewsantFragment : Fragment() {
    private var _binding: FragmentNewsantBinding? = null
    private val binding get() = _binding!!
    private val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvBackArrow.setOnClickListener {
            findNavController().navigateUp()
        }

        val dbRef = db.collection("newsant").document("api_key")

        dbRef.get().addOnSuccessListener { result ->

            result?.let {
                when (it.get("key").toString()) {
                    binding.rbOne.text -> {
                        binding.rbOne.isChecked = true
                    }

                    binding.rbTwo.text -> {
                        binding.rbTwo.isChecked = true
                    }

                    binding.rbThree.text -> {
                        binding.rbThree.isChecked = true
                    }

                    binding.rbFour.text -> {
                        binding.rbFour.isChecked = true
                    }

                    binding.rbFive.text -> {
                        binding.rbFive.isChecked = true
                    }

                    binding.rbSix.text -> {
                        binding.rbSix.isChecked = true
                    }

                    binding.rbSeven.text -> {
                        binding.rbSeven.isChecked = true
                    }

                    binding.rbEight.text -> {
                        binding.rbEight.isChecked = true
                    }

                    binding.rbNine.text -> {
                        binding.rbNine.isChecked = true
                    }

                    binding.rbTen.text -> {
                        binding.rbTen.isChecked = true
                    }

                    binding.rbEleven.text -> {
                        binding.rbEleven.isChecked = true
                    }

                    binding.rbTwelve.text -> {
                        binding.rbTwelve.isChecked = true
                    }

                }
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = group.findViewById(checkedId)
            val apiKey = radioButton.text.toString()
            dbRef.set(mapOf("key" to apiKey))
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}