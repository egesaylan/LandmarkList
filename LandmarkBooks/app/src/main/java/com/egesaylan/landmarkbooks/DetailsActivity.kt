package com.egesaylan.landmarkbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.egesaylan.landmarkbooks.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val selectedLandmark = intent.getSerializableExtra("landmarkName") as Landmark

        binding.nameText.text = selectedLandmark.name
        binding.CountryText.text = selectedLandmark.country
        binding.imageView.setImageResource(selectedLandmark.image)


    }
}