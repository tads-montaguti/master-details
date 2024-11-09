package ufpr.montaguti.masterdetailapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val pokemon = intent.getParcelableExtra<Pokemon>("pokemon")

        val imageView: ImageView = findViewById(R.id.imageView)
        val nameTextView: TextView = findViewById(R.id.name)
        val typeTextView: TextView = findViewById(R.id.type)
        val hitpointsTextView: TextView = findViewById(R.id.hitpoints)
        val evolutionsTextView: TextView = findViewById(R.id.evolutions)
        val abilitiesTextView: TextView = findViewById(R.id.abilities)
        val locationTextView: TextView = findViewById(R.id.location)
        val backButton: Button = findViewById(R.id.back_button)

        pokemon?.let {
            Glide.with(this)
                .load(it.imageUrl)
                .placeholder(R.drawable.placeholder_image)
                .into(imageView)

            nameTextView.text = it.pokemon
            typeTextView.text = it.type
            hitpointsTextView.text = it.hitpoints.toString()
            evolutionsTextView.text = if (it.evolutions.isNullOrEmpty()) "None" else it.evolutions.joinToString(", ")
            abilitiesTextView.text = if (it.abilities.isNullOrEmpty()) "None" else it.abilities.joinToString(", ")
            locationTextView.text = it.location ?: "Unknown"
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
