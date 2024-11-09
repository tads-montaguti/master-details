package ufpr.montaguti.masterdetailapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        val pokemonList = loadPokemonData()
        val adapter = PokemonAdapter(this, pokemonList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val pokemon = pokemonList[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("pokemon", pokemon)
            startActivity(intent)
        }
    }

    private fun loadPokemonData(): List<Pokemon> {
        val jsonString = assets.open("pokemon_data.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val listType = object : TypeToken<List<Pokemon>>() {}.type
        return gson.fromJson(jsonString, listType)
    }
}