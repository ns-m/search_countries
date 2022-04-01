package com.example.searchountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
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
                val countries = restCoutriesApi.getCountryByName(countryName)
                val country = countries[0]
                binding.CountryNameTextView.text = country.name
                binding.CapitalTextView.text = country.capital
                binding.PopulationTextView.text = country.population.toString()
                binding.AreaTextView.text = country.area.toString()
                binding.LanguagesTextView.text = country.languages.toString()
            }
        }
    }
}