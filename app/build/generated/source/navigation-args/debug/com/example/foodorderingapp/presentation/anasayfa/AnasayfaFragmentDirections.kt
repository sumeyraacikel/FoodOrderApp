package com.example.foodorderingapp.presentation.anasayfa

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.foodorderingapp.R
import com.example.foodorderingapp.domain.model.YemekDto
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class AnasayfaFragmentDirections private constructor() {
  private data class ActionAnasayfaFragmentToDetayFragment(
    public val yemek: YemekDto
  ) : NavDirections {
    public override val actionId: Int = R.id.action_anasayfaFragment_to_detayFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(YemekDto::class.java)) {
          result.putParcelable("yemek", this.yemek as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(YemekDto::class.java)) {
          result.putSerializable("yemek", this.yemek as Serializable)
        } else {
          throw UnsupportedOperationException(YemekDto::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionAnasayfaFragmentToDetayFragment(yemek: YemekDto): NavDirections =
        ActionAnasayfaFragmentToDetayFragment(yemek)
  }
}
