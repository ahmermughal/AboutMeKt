package com.idevelopstudio.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.idevelopstudio.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName : MyName = MyName("Ahmer Mughal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.btnDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = etNickname.text.toString()
            invalidateAll()
            etNickname.visibility = View.GONE
            view.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE
        }
        // hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}
