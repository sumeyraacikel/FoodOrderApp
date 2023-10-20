package com.example.foodorderingapp.presentation.detay

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.foodorderingapp.domain.model.YemekDto
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetayFragmentArgs(
  public val yemek: YemekDto
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(YemekDto::class.java)) {
      result.set("yemek", this.yemek as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(YemekDto::class.java)) {
      result.set("yemek", this.yemek as Serializable)
    } else {
      throw UnsupportedOperationException(YemekDto::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): DetayFragmentArgs {
      bundle.setClassLoader(DetayFragmentArgs::class.java.classLoader)
      val __yemek : YemekDto?
      if (bundle.containsKey("yemek")) {
        if (Parcelable::class.java.isAssignableFrom(YemekDto::class.java) ||
            Serializable::class.java.isAssignableFrom(YemekDto::class.java)) {
          __yemek = bundle.get("yemek") as YemekDto?
        } else {
          throw UnsupportedOperationException(YemekDto::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__yemek == null) {
          throw IllegalArgumentException("Argument \"yemek\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"yemek\" is missing and does not have an android:defaultValue")
      }
      return DetayFragmentArgs(__yemek)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetayFragmentArgs {
      val __yemek : YemekDto?
      if (savedStateHandle.contains("yemek")) {
        if (Parcelable::class.java.isAssignableFrom(YemekDto::class.java) ||
            Serializable::class.java.isAssignableFrom(YemekDto::class.java)) {
          __yemek = savedStateHandle.get<YemekDto?>("yemek")
        } else {
          throw UnsupportedOperationException(YemekDto::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__yemek == null) {
          throw IllegalArgumentException("Argument \"yemek\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"yemek\" is missing and does not have an android:defaultValue")
      }
      return DetayFragmentArgs(__yemek)
    }
  }
}
