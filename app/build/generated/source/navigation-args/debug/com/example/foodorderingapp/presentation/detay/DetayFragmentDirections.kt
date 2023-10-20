package com.example.foodorderingapp.presentation.detay

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.foodorderingapp.R

public class DetayFragmentDirections private constructor() {
  public companion object {
    public fun sepetGecis(): NavDirections = ActionOnlyNavDirections(R.id.sepetGecis)
  }
}
