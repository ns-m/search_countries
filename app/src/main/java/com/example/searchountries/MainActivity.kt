package com.example.searchountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.searchountries.databinding.ActivityMainBinding
import com.example.searchountries.databinding.ActivityMainBinding.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        binding.SearchButton.setOnClickListener {
            val countryName = binding.CountryNameEditText.text.toString()
            lifecycleScope.launch {
                try {
                    val countries = restCoutriesApi.getCountryByName(countryName)
                    val country = countries[0]
                    binding.CountryNameTextView.text = country.name
                    binding.CapitalTextView.text = country.capital
                    binding.PopulationTextView.text = formatNumber(country.population)
                    binding.AreaTextView.text = formatNumber(country.area)
                    binding.LanguagesTextView.text = languagesToString(country.languages)
                    binding.FlagImageView.load(country.flag)
                    binding.ResultLayout.visibility = View.VISIBLE
                    binding.StatusLayout.visibility = View.INVISIBLE
                } catch (e: Exception){
                    binding.StatusTextView.text = "Country not found"
                    binding.StatusImageView.setImageResource(R.drawable.ic_baseline_error_outline_24)
                    binding.ResultLayout.visibility = View.INVISIBLE
                    binding.StatusLayout.visibility = View.VISIBLE
                }

            }
        }
    }

}