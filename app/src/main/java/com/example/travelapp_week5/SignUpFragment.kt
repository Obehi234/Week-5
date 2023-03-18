package com.example.travelapp_week5

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class SignUpFragment : Fragment() {
    private lateinit var gender: AutoCompleteTextView
    private lateinit var signUpButton: Button
    private lateinit var userPassword: TextInputEditText
    private lateinit var userEmail: TextInputEditText
    private lateinit var userPhone: TextInputEditText
    private lateinit var userName: TextInputEditText

    //Add variables to store user input
//    private var nameInput: String = ""
//    private var emailInput: String = ""
//    private var phoneInput: String = ""
//    private var genderInput: String = ""

    //AutoComplete drop down items
    private val subjects = arrayOf("Male", "Female", "Non-Binary", "Other")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Validate Forms
        userPassword = view.findViewById(R.id.input_password)
        userEmail = view.findViewById(R.id.email_field)
        userPhone = view.findViewById(R.id.phone_field)
        userName = view.findViewById(R.id.name_field)
        //Get a reference to the autocompleteView(spinner)
        gender = view.findViewById(R.id.user_gender_select)

       val  nameInput = userName.text.toString()
       val  emailInput = userEmail.text.toString()
       val  phoneInput = userPhone.text.toString()
       val  genderInput = gender.text.toString()
        Log.d("nameInput", "1 $nameInput")


        // create an array adapter and pass the required parameters
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, subjects)
        //Set the adapter to the spinner
        gender.setAdapter(adapter)

        //set up item selection listener
        gender.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
            gender.text.toString()
        }

        //Launch Congrats Fragment with SignUp Button
        signUpButton = view.findViewById(R.id.signUpButton)
        signUpButton.setOnClickListener {
//            val emailError = validateEmail()
//            val passwordError = validatePassword()
//            val phoneError = validatePhone()
//            val nameError = validateName()
//            val genderError = validateGender()
            launchCongrats(nameInput, emailInput, phoneInput, genderInput)

//            if (passwordError == null && phoneError == null && nameError == null && genderError == null) {
//                launchCongrats()
//            } else {
//                // display error message to the user
//                Toast.makeText(
//                    requireContext(),
//                    "${emailError ?: ""} ${passwordError ?: ""} ${phoneError ?: ""} ${nameError ?: ""} ${genderError ?: ""}",
//                    Toast.LENGTH_LONG
//                ).show()


        }

    }

    private fun launchCongrats(nameInput: String, emailInput: String, phoneInput: String, genderInput: String) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        val args = Bundle()
        args.putString("name", nameInput)
        args.putString("email", emailInput)
        args.putString("phone", phoneInput)
        args.putString("gender", genderInput)
        Log.d("nameInput", "2 $nameInput")
        CongratsFragment().arguments = args
        fragmentTransaction.replace(R.id.fragment_container, CongratsFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


    }

    //Password Validation
    private fun validatePassword(): String? {
        val outputPassword = userPassword.text.toString()
        if (outputPassword.length < 8) {
            return "Minimum 8 Character password"
        }
        if (!outputPassword.matches(".*[A-Z].*".toRegex())) {
            return "Must contain 1 uppercase character"
        }
        if (!outputPassword.matches(".*[a-z].*".toRegex())) {
            return "Must contain 1 lower case character"
        }
        if (!outputPassword.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Must Contain 1 special character (@#\$%^&+=)"
        }
        return null
    }

    //Email Validation
//    private fun validateEmail(): String? {
////        val emailOutput = userEmail.text.toString()
//        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
//            userEmail.error = "Invalid email address"
//            return "Invalid email address"
//        } else {
//            userEmail.error = null
//            return null
//        }
//    }

//    //Validate Phone Number
//    private fun validatePhone(): String? {
////        val phoneOutput = userPhone.text.toString().trim()
//        if (phoneInput.isEmpty()) {
//            return "Phone number is required"
//        }
//        if (!phoneInput.matches("^\\+?234\\d{9}$|^0\\d{10}$".toRegex())) {
//            return "Must be digits"
//        }
//        if (phoneInput.length != 10) {
//            return "Must be 10 digits"
//        }
//        return null
//    }
//
//    //Validate User Name
//    private fun validateName(): String? {
////        val nameOutput = userName.text.toString()
//        if (nameInput.isNullOrEmpty()) {
//            return "User name is required"
//        }
//        val nameParts = nameInput.split(" ")
//        if (nameParts.size != 2) {
//            return "Please enter both first and last names separated by a space"
//        }
//        val firstName = nameParts[0]
//        val lastName = nameParts[1]
//        if (!firstName.matches("[a-zA-Z]+".toRegex()) || !lastName.matches("[a-zA-Z]+".toRegex())) {
//            return "First and last names must contain only alphabets"
//        }
//        return null
//    }
//
//    //Validate User Gender
//    private fun validateGender(): String? {
////        val genderOutput = gender.text.toString()
//        if (!subjects.contains(genderInput)) {
//            return "Please select a valid gender"
//        }
//        if (genderInput.isBlank()) {
//            return "Please select a gender"
//        }
//        return null
//    }

}

