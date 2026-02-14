package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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

}

data class MyCityUiState(
    val categoriesList: List<Category> = emptyList(),
    val currentCategory: Category = LocalCategoryDataProvider.defaultCategory,
    val isShowingCategoryPage: Boolean = true,
    val isShowingSubcategoryPage: Boolean = false


)