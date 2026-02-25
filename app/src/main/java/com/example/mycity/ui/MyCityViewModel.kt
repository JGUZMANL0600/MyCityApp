package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Category
import com.example.mycity.model.SubCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        MyCityUiState(
            categoriesList = LocalCategoryDataProvider.getCategoryData(),
            currentCategory = LocalCategoryDataProvider.getCategoryData().getOrElse(0){
                LocalCategoryDataProvider.defaultCategory

            }
        )
    )
    val uiState: StateFlow<MyCityUiState> = _uiState
    fun updateCurrentCategory(selectedCategory: Category) {
        _uiState.value =
            _uiState.value.copy(currentCategory = selectedCategory)
    }
    fun navigateToSubcategoryPage() {
        _uiState.value =
            _uiState.value.copy(isShowingSubcategoryPage = true,
                isShowingCategoryPage = false)

    }
    fun navigateToCategoryPage() {
        _uiState.value =
            _uiState.value.copy(isShowingSubcategoryPage = false,
                isShowingCategoryPage = true)

    }
    fun updateCurrentSubcategory(selectedSubcategory: SubCategory) {
        _uiState.value =
            _uiState.value.copy(currentSubcategory = selectedSubcategory)
    }
    fun navigateToDetailPage(){
        _uiState.value =
            _uiState.value.copy(isShowingCategoryPage = false,
                isShowingSubcategoryPage = false)
    }

    fun expandCollapseCategory(categoryToUpdate: Category) {
        _uiState.update { currentState ->
            val updatedCategories = currentState.categoriesList.map {
                if (it.id == categoryToUpdate.id) {
                    it.copy(expanded = !it.expanded)
                } else {
                    it
                }
            }
            currentState.copy(categoriesList = updatedCategories)
        }
    }

}

data class MyCityUiState(
    val categoriesList: List<Category> = emptyList(),
    val currentCategory: Category = LocalCategoryDataProvider.defaultCategory,
    val isShowingCategoryPage: Boolean = true,
    val isShowingSubcategoryPage: Boolean = false,
    val currentSubcategory: SubCategory = LocalCategoryDataProvider.defaultSubcategory
)
