package com.egesaylan.landmarkbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.egesaylan.landmarkbooks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        landmarkList = ArrayList<Landmark>()

        val pisa = Landmark("pisa","italy",R.drawable.pisa)
        val niagara = Landmark("niagara", "Canada", R.drawable.niagara)
        val eiffel = Landmark("eiffel", "France", R.drawable.eiffel)
        val wall = Landmark("The great wall", "China", R.drawable.wall)

        landmarkList.add(pisa)
        landmarkList.add(niagara)
        landmarkList.add(eiffel)
        landmarkList.add(wall)

        val adapter  =ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })

        binding.listview.adapter = adapter

        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmarkName",landmarkList.get(position))
            startActivity(intent)
        }
    }
}