package com.example.travelapp_week5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText


class SignInFragment : Fragment() {
private lateinit var userPassword: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signInButton: Button = view.findViewById(R.id.signInButton)
        signInButton.setOnClickListener {
            val passwordError = validPassword()
            if(passwordError == null) {
                launchWelcome(it)
            } else {
                Toast.makeText(requireContext(), "${passwordError ?: ""}", Toast.LENGTH_SHORT).show()
            }
        }

        //Validate Form Field
        userPassword = view.findViewById(R.id.password_field)

    }

    private fun launchWelcome(view: View) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, WelcomeFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    //Validate Password
    private fun validPassword() : String? {
        val password = userPassword.text.toString()
        if(password.length < 8) {
            return  "Minimum 8 Character password"
        }
        if(!password.matches(".*[A-Z].*".toRegex())) {
            return "Must contain 1 uppercase character"
        }
        if(!password.matches(".*[a-z].*".toRegex())) {
            return "Must contain 1 lower case character"
        }
        if(!password.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Must Contain 1 special character (@#\$%^&+=)"
        }
        return null
    }

}