package com.example.travelapp_week5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CongratsFragment : Fragment() {

    private lateinit var profileName: TextView
    private lateinit var profileEmail: TextView
    private lateinit var profilePhone: TextView
    private lateinit var profileGender: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_congrats, container, false)
        profileName = view.findViewById(R.id.profile_name)
        profileEmail = view.findViewById(R.id.profile_email)
        profilePhone = view.findViewById(R.id.profile_phone)
        profileGender = view.findViewById(R.id.profile_gender)

        displayUI()
        return view
    }

    private fun displayUI() {
        // retrieve the data from the bundle
        val bundle = arguments
        val name = bundle?.getString("name")
        val email = bundle?.getString("email")
        val phone = bundle?.getString("phone")
        val gender = bundle?.getString("gender")

        Log.d("*NAME", "$name")
        // display the data in the UI
        profileName.text = name
        profileEmail.text = email
        profilePhone.text = phone
        profileGender.text = gender
    }

}