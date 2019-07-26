package com.example.online_travel_reservation_.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.online_travel_reservation_.R
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SignUpFragment : Fragment(),View.OnClickListener {

    lateinit var fname: String
    lateinit var lname: String
    lateinit var address: String
    lateinit var email: String
    lateinit var password: String
    lateinit var mobile: String
    lateinit var edit_fname: EditText
    lateinit var edit_lname: EditText
    lateinit var edit_address: EditText
    lateinit var edit_email: EditText
    lateinit var edit_password: EditText
    lateinit var edit_mobile: EditText
    lateinit var edit_fname_box: TextInputLayout
    lateinit var edit_lname_box: TextInputLayout
    lateinit var edit_address_box: TextInputLayout
    lateinit var edit_email_box: TextInputLayout
    lateinit var edit_password_box: TextInputLayout
    lateinit var edit_mobile_box: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        init(view);



        return view
    }

    private fun init(view: View) {
        edit_fname = view.findViewById<EditText>(R.id.register_edit_first_name)
        edit_fname_box = view.findViewById<TextInputLayout>(R.id.register_edit_first_name_box)

        edit_lname = view.findViewById<EditText>(R.id.register_edit_last_name)
        edit_lname_box = view.findViewById<TextInputLayout>(R.id.register_edit_last_name_box)

        edit_address = view.findViewById<EditText>(R.id.register_edit_address)
        edit_address_box = view.findViewById<TextInputLayout>(R.id.register_edit_address_box)

        edit_email = view.findViewById<EditText>(R.id.register_edit_email)
        edit_email_box = view.findViewById<TextInputLayout>(R.id.register_edit_email_box)

        edit_password = view.findViewById<EditText>(R.id.register_edit_password)
        edit_password_box = view.findViewById<TextInputLayout>(R.id.register_edit_password_box)

        edit_mobile = view.findViewById<EditText>(R.id.register_edit_mobile)
        edit_mobile_box = view.findViewById<TextInputLayout>(R.id.register_edit_mobile_box)

        var register_button = view.findViewById<Button>(R.id.register_button)
        register_button.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        fname=edit_fname.text.toString()
        lname=edit_lname.text.toString()
        address=edit_address.text.toString()
        email=edit_email.text.toString()
        password=edit_password.text.toString()
        mobile=edit_mobile.text.toString()

        if(AllEditTextValid()){
            connectApi()
        }
    }

    private fun connectApi() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun AllEditTextValid(): Boolean {

        var fnameValid = true
        var lnameValid = true
        var addressValid = true
        var emailValid = true
        var passwordValid = true
        var mobileValid = true

        if (!isFnameValid()) {
            fnameValid = false
        }
        if (!isLnameValid()) {
            lnameValid = false
        }
        if (!isAddressValid()) {
            addressValid = false
        }
        if (!isEmailValid()) {
            emailValid = false
        }
        if (!isPasswordValid()) {
            passwordValid = false
        }
        if (!isMobileValid()) {
            mobileValid = false
        }
        return if (fnameValid && lnameValid && addressValid && emailValid && passwordValid && mobileValid )
            true
        else
            false
    }


    private fun isFnameValid(): Boolean {
        if (TextUtils.isEmpty(fname)) {
            edit_fname_box.setError("First name can not be empty")
            return false
        } else {
            edit_fname_box.setErrorEnabled(false)
            return true
        }
    }

    private fun isLnameValid(): Boolean {
        if (TextUtils.isEmpty(lname)) {
            edit_lname_box.setError("Last name can not be empty")
            return false
        } else {
            edit_lname_box.setErrorEnabled(false)
            return true
        }
    }

    private fun isAddressValid(): Boolean {
        if (TextUtils.isEmpty(address)) {
            edit_address_box.setError("Address can not be empty")
            return false
        } else {
            edit_address_box.setErrorEnabled(false)
            return true
        }
    }

    private fun isEmailValid(): Boolean {
        if (TextUtils.isEmpty(email)) {
            edit_email_box.setError("Email can not be empty")
            return false
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edit_email_box.setError("Please input correct email address");
            return false;
        }else {
            edit_email_box.setErrorEnabled(false)
            return true
        }
    }

    private fun isPasswordValid(): Boolean {
        var pattern:Regex="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{10,}$".toRegex()
        if (TextUtils.isEmpty(password)) {
            edit_password_box.setError("Password can not be empty")
            return false
        } else if(password.length <8){
            edit_password_box.setError("password length must be at lease 8 digits long");
            return false;
        }else if(!password.matches(pattern)){
            edit_password_box.setError("password should contain at least one upper case letter, one lower case letter and one number");
            return false;
        } else {
            edit_password_box.setErrorEnabled(false)
            return true
        }
    }

    private fun isMobileValid(): Boolean {
        if (TextUtils.isEmpty(mobile)) {
            edit_mobile_box.setError("Mobile can not be empty")
            return false
        }else if(mobile.length!=10) {
            edit_mobile_box.setError("Mobile must be in 10 digits")
            return false
        } else{
            edit_mobile_box.setErrorEnabled(false)
            return true
        }
    }

}
