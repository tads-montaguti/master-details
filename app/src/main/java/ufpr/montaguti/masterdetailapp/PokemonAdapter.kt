package ufpr.montaguti.masterdetailapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class PokemonAdapter(
    private val context: Context,
    private val pokemonList: List<Pokemon>
) : ArrayAdapter<Pokemon>(context, 0, pokemonList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false)

        val pokemon = pokemonList[position]
        val title = view.findViewById<TextView>(R.id.title)
        val type = view.findViewById<TextView>(R.id.type)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        title.text = pokemon.pokemon
        type.text = pokemon.type
        Glide.with(context)
            .load(pokemon.imageUrl)
            .placeholder(R.drawable.placeholder_image)
            .into(imageView)

        return view
    }
}
