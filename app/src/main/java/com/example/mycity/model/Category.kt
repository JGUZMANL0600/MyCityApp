package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val categoryIcon: Int,
    val subCategories: List<SubCategory>,
    var expanded: Boolean
)
