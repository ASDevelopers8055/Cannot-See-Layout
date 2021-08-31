package com.example.passwordfactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.passwordfactory.databinding.ActivityMainBinding

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.generate.setOnClickListener{ generatePassword() }
    }
    private fun generatePassword() {
        val stringInField = binding.digits.text.toString()
        val digits = stringInField.toInt()
        val passwordRange: MutableList<String>
        val output: MutableList<String> = mutableListOf("a","b","c")
        output.clear()
        when (binding.type.checkedRadioButtonId) {
            R.id.textOnly -> {
                passwordRange = mutableListOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
            }
            R.id.numbersOnly -> {
                passwordRange = mutableListOf("1","2","3","4","5","6","7","8","9","0")
            }
            R.id.alphanumeric -> {
                passwordRange = mutableListOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0")
            }
            R.id.allTypes -> {
                passwordRange = mutableListOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0","!","@","#","$","%","^","&","*","(",")","{","}",";",":","\'","\"",",","<",".",">","/","?","\\","~","|")
            }
            else -> {
                passwordRange = mutableListOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0","!","@","#","$","%","^","&","*","(",")","{","}",";",":","\'","\"",",","<",".",">","/","?","\\","~","|")
            }
        }
        val intRange = passwordRange.size - 1
        repeat(digits) {
            val randomInt = (0..intRange).random()
            output.add(passwordRange[randomInt])
        }
        binding.output.text = output.joinToString(separator="")
    }
}
