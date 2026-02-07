package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.SubCategory

object LocalCategoryDataProvider {
    val defaultCategory= getCategoryData()[0]

   fun getCategoryData() : List<Category> {
       return listOf(
           Category(
               id = 1,
               name = R.string.cafeterias,
               categoryIcon = R.drawable.ic_category_cafe,
               subCategories = listOf(
                   SubCategory(
                       id = 1,
                       name = R.string.cafe_tacuba,
                       subCategoryIcon = R.drawable.ic_category_cafe,
                       location = R.string.cafe_tacuba_location,
                       description = R.string.cafe_tacuba_description
                   )
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
                       description = R.string.cafe_tacuba_description
                   )
               ),
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
                       description = R.string.cafe_tacuba_description
                   )
               ),
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
                       description = R.string.cafe_tacuba_description
                   )
               ),
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
                       description = R.string.cafe_tacuba_description
                   )
               ),
           ),
       )
   }
}