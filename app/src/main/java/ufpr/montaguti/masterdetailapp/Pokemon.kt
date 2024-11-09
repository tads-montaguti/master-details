package ufpr.montaguti.masterdetailapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val pokemon: String,
    val type: String,
    val abilities: List<String>?,
    val hitpoints: Int,
    val evolutions: List<String>?,
    val location: String?,
    val imageUrl: String?
) : Parcelable
