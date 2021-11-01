package com.example.androidregistrationformhomework

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidregistrationformhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registration.setOnClickListener { registration() }
    }
    fun registration() {
        val userName = binding.name.text.toString()
        val userEmail = binding.email.text.toString()
        val passWord = binding.password.text.toString()
        val rePassWord = binding.rePassword.text.toString()
        val birthDay = binding.birtday.text.toString()
        val selectGender = binding.gender.checkedRadioButtonId
        val gender = when (selectGender) {
            R.id.female -> "Female"
            R.id.male -> "male"
            else -> "you are an angle"
        }
        if (userName.isNotEmpty() && userEmail.isNotEmpty() && passWord.isNotEmpty() && rePassWord.isNotEmpty()){
            if (passWord == rePassWord) {

                binding.userInfo.setText("Profile \n " +
                        "Name: $userName \n " +
                        "Email : $userEmail \n" +
                        "Birth Date : $birthDay \n " +
                        "Gender : $gender \n" +
                        "Password : $passWord \n" +
                        "Re-Password : $rePassWord ")

            } else {
                binding.userInfo.setText("Password Missmatch , please re-enter your password")
            }
        }else{
            binding.warning.setText("full the blank please !")
        }

        }


}