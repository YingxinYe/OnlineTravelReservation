package com.example.online_travel_reservation_.fragments


import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.online_travel_reservation_.R
import com.example.online_travel_reservation_.activities.LoginActivity
import com.google.android.material.textfield.TextInputLayout

import kotlinx.android.synthetic.main.fragment_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment(),View.OnClickListener {

    lateinit var entered_mobile:String
    lateinit var entered_password:String
    lateinit var edit_mobile_box: TextInputLayout
    lateinit var edit_password_box: TextInputLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_login, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        var image=view.findViewById<ImageView>(R.id.login_image_view)
        image.setBackgroundResource(R.drawable.background_load);
        val frameAnimation = image.getBackground() as AnimationDrawable
        frameAnimation.start()

        var go_to_sign_up_string=view.findViewById<TextView>(R.id.login_go_register)
        go_to_sign_up_string.setOnClickListener(this)

        var login_btn=view.findViewById<Button>(R.id.login_button)
        login_btn.setOnClickListener(this)

        edit_mobile_box=view.findViewById<TextInputLayout>(R.id.login_mobile_edit_text_box)
        edit_password_box=view.findViewById<TextInputLayout>(R.id.login_password_edit_text_box)
    }

    override fun onClick(v: View) {
        when(v){
            login_go_register-> {
                activity?.supportFragmentManager?.beginTransaction()?.add(R.id.login_fragment_container, SignUpFragment())?.commit()
            }
            login_button ->{
                entered_mobile=login_mobile_edit_text.text.toString()
                entered_password=login_password_edit_text.text.toString()
                if(AllEditTextValid()){
                    connectApi()
                }
            }
        }
    }

    private fun connectApi() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun AllEditTextValid(): Boolean {

        var passwordValid = true
        var mobileValid = true

        if (!isPasswordValid()) {
            passwordValid = false
        }
        if (!isMobileValid()) {
            mobileValid = false
        }
        return if (passwordValid && mobileValid)
            true
        else
            false
    }

    private fun isPasswordValid(): Boolean {
        var pattern:Regex="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{10,}$".toRegex()
        if (TextUtils.isEmpty(entered_password)) {
            edit_password_box.setError("Password can not be empty")
            return false
        } else if(entered_password.length <8){
            edit_password_box.setError("password length must be at lease 8 digits long");
            return false;
        }else if(!entered_password.matches(pattern)){
            edit_password_box.setError("password should contain at least one upper case letter, one lower case letter and one number");
            return false;
        } else {
            edit_password_box.setErrorEnabled(false)
            return true
        }
    }

    private fun isMobileValid(): Boolean {
        if (TextUtils.isEmpty(entered_mobile)) {
            edit_mobile_box.setError("Mobile can not be empty")
            return false
        }else if(entered_mobile.length!=10) {
            edit_mobile_box.setError("Mobile must be in 10 digits")
            return false
        } else{
            edit_mobile_box.setErrorEnabled(false)
            return true
        }
    }

}
