package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category

object LocalCategoryDataProvider {
    val defaultCategory= getCategoryData()[0]

    fun getCategoryData() : List<Category> {
        return listOf(
            Category(
                id = 1,
                name = R.string.cafeterias,
                categoryIcon = TODO()
            ),
            Category(
                id = 2,
                name = R.string.bares,
                categoryIcon = TODO()
            ),
            Category(
                id = 3,
                name = R.string.restaurantes,
                categoryIcon = TODO()
            ),
            Category(
                id = 4,
                name = R.string.parques,
                categoryIcon = TODO()
            ),
            Category(
                id = 5,
                name = R.string.centros_comerciales,
                categoryIcon = TODO()
            )

        )

    }
}