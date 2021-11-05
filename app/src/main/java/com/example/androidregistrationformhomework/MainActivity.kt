package com.example.androidregistrationformhomework

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidregistrationformhomework.databinding.ActivityMainBinding
import android.util.Patterns
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registration.setOnClickListener { registration() }
    }
    fun registration() {
        val userName = binding.nameInput.text.toString()
        val userEmail = binding.emailInput.text.toString()
        val passWord = binding.passwordInput.text.toString()
        val rePassWord = binding.repassInput.text.toString()
        val birthDay = binding.birthdayInput.text.toString()
        val selectGender = binding.gender.checkedRadioButtonId
        val gender = when (selectGender) {
            R.id.female -> "Female"
            else -> "male"

        }
        if (userName.isNotEmpty() && userEmail.isNotEmpty() && passWord.isNotEmpty() && rePassWord.isNotEmpty()){
            if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
            {
                binding.emailContainer.helperText = "Invalid Email Address"
            }
           else if (passWord == rePassWord) {

                binding.userInfo.setText("Profile \n " +
                        "Name: $userName \n " +
                        "Email : $userEmail \n" +
                        "Birth Date : $birthDay \n " +
                        "Gender : $gender \n" +
                        "Password : $passWord \n" +
                        "Re-Password : $rePassWord ")

            } else {
                binding.passwordContainer.helperText="Password Mismatch , please re-enter your password"
                binding.repassContainer.helperText="Password Mismatch , please re-enter your password"
            }
        }else{
            binding.nameContainer.helperText="full the blank please !"
            binding.emailContainer.helperText="full the blank please !"
            binding.passwordContainer.helperText="full the blank please !"
            binding.repassContainer.helperText="full the blank please !"
            binding.birthdayContainer.helperText="full the blank please !"
        }

        }
//    public final static boolean isValidEmail(CharSequence target) {
//        if (target == null) {
//            return false;
//        } else {
//            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
//        }
//    }

}