package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.SubCategory

object LocalCategoryDataProvider {



    private val categoryData: List<Category> =
        listOf(
            Category(
                id = 1,
                name = R.string.cafeterias,
                categoryIcon = R.drawable.ic_category_cafe,
                expanded = true,
                subCategories = listOf(
                    SubCategory(
                        id = 1,
                        name = R.string.cafe_tacuba,
                        subCategoryIcon = R.drawable.ic_cafe_de_tacuba,
                        location = R.string.cafe_tacuba_location,
                        description = R.string.cafe_tacuba_description,
                        subCategoryBanner = R.drawable.banner_cafe_tacuba
                    ),
                    SubCategory(
                        id = 2,
                        name = R.string.cafe_jarocho,
                        subCategoryIcon = R.drawable.ic_cafe_jarocho,
                        location = R.string.cafe_jarocho_location,
                        description = R.string.cafe_jarocho_description,
                        subCategoryBanner = R.drawable.banner_cafe_jarocho
                    ),
                    SubCategory(
                        id = 3,
                        name = R.string.cafe_nin,
                        subCategoryIcon = R.drawable.ic_cafe_nin,
                        location = R.string.cafe_nin_location,
                        description = R.string.cafe_nin_description,
                        subCategoryBanner = R.drawable.banner_cafe_nin
                    ),
                    SubCategory(
                        id = 4,
                        name = R.string.cafe_almanegra,
                        subCategoryIcon = R.drawable.ic_cafe_almanegra,
                        location = R.string.cafe_almanegra_location,
                        description = R.string.cafe_almanegra_description,
                        subCategoryBanner = R.drawable.banner_cafe_almanegra
                    ),
                    SubCategory(
                        id = 5,
                        name = R.string.cafe_quentin,
                        subCategoryIcon = R.drawable.ic_cafe_quentin,
                        location = R.string.cafe_quentin_location,
                        description = R.string.cafe_quentin_description,
                        subCategoryBanner = R.drawable.banner_cafe_quentin
                    ),


                    ),
            ),
            Category(
                id = 2,
                name = R.string.bares,
                categoryIcon = R.drawable.ic_category_pub,
                subCategories = listOf(
                    SubCategory(
                        id = 1,
                        name = R.string.cafe_tacuba,
                        subCategoryIcon = R.drawable.ic_category_cafe,
                        location = R.string.cafe_tacuba_location,
                        description = R.string.cafe_tacuba_description,
                        subCategoryBanner = R.drawable.banner_cafe_jarocho
                    )
                ),
                expanded = false,
            ),
            Category(
                id = 3,
                name = R.string.restaurantes,
                categoryIcon = R.drawable.ic_category_restaurant,
                subCategories = listOf(
                    SubCategory(
                        id = 1,
                        name = R.string.cafe_tacuba,
                        subCategoryIcon = R.drawable.ic_category_cafe,
                        location = R.string.cafe_tacuba_location,
                        description = R.string.cafe_tacuba_description,
                        subCategoryBanner = R.drawable.banner_cafe_jarocho
                    )
                ),
                expanded = false,
            ),
            Category(
                id = 4,
                name = R.string.parques,
                categoryIcon = R.drawable.ic_category_park,
                subCategories = listOf(
                    SubCategory(
                        id = 1,
                        name = R.string.cafe_tacuba,
                        subCategoryIcon = R.drawable.ic_category_cafe,
                        location = R.string.cafe_tacuba_location,
                        description = R.string.cafe_tacuba_description,
                        subCategoryBanner = R.drawable.banner_cafe_jarocho
                    )
                ),
                expanded = false,
            ),
            Category(
                id = 5,
                name = R.string.centros_comerciales,
                categoryIcon = R.drawable.ic_category_mall,
                subCategories = listOf(
                    SubCategory(
                        id = 1,
                        name = R.string.cafe_tacuba,
                        subCategoryIcon = R.drawable.ic_category_cafe,
                        location = R.string.cafe_tacuba_location,
                        description = R.string.cafe_tacuba_description,
                        subCategoryBanner = R.drawable.banner_cafe_jarocho
                    )
                ),
                expanded = false,
            ),

        )
    val defaultCategory= categoryData[0]
    val defaultSubcategory= categoryData[0].subCategories[0]
    fun getCategoryData(): List<Category> {
        return categoryData
    }
}
