package com.example.travelapp_week5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val signInButton: Button = view.findViewById(R.id.signInButton)
        val signUpButton: Button = view.findViewById(R.id.signUpButton)

        signInButton.setOnClickListener { signInListener(it) }
        signUpButton.setOnClickListener { signUpListener(it) }

        return view

    }

    private fun signInListener(view: View) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, SignInFragment())
        fragmentTransaction.addToBackStack("Sign In Fragment")
        fragmentTransaction.commit()
    }

    private fun signUpListener(view: View) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, SignUpFragment())
        fragmentTransaction.addToBackStack("Sign Up Fragment")
        fragmentTransaction.commit()

    }


}