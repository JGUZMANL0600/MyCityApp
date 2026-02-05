package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SubCategory(
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val subCategoryIcon: Int,
    @StringRes val location: Int,
    @StringRes val description: Int
)
