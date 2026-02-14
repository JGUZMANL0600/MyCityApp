package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.R
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Category
import com.example.mycity.model.SubCategory
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun MyCityApp(){
    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            MyCityAppBar(
                isShowingCategoryPage = uiState.isShowingCategoryPage,
                isShowingSubcategoryPage = uiState.isShowingSubcategoryPage,
                onBackButtonClick = {
                    if (uiState.isShowingSubcategoryPage)
                        viewModel.navigateToCategoryPage()
                    else
                        viewModel.navigateToSubcategoryPage()
                }
            )
        }
    ) {
        innerPadding ->
        if (uiState.isShowingCategoryPage){
            CategoryList(
                category = uiState.categoriesList,
                onClick = {
                    viewModel.updateCurrentCategory(it)
                    viewModel.navigateToSubcategoryPage()
                },
                contentPadding = innerPadding
            )
        }
        else if (uiState.isShowingSubcategoryPage){
            SubcategoryList(
                subcategory = uiState.currentCategory.subCategories,
                onClick = {},
                contentPadding = innerPadding
            )

        }

    }



}

@Composable
private fun CategoryListItem(
    category: Category,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(category) }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))

        ) {
            CategoryListImageItem(
                category,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(category.name),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space)),

                )


            }


        }

    }
}


@Composable
private fun CategoryListImageItem(
    category: Category,
    modifier: Modifier = Modifier
){
    Box(
        modifier=modifier
    ){
        Image(
            painter = painterResource(category.categoryIcon),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
private fun CategoryList(
    category:List<Category>,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
    ){
        items(items = category, key = {category -> category.id}){ category ->
            CategoryListItem(
                category = category,
                onItemClick = onClick
            )
        }

    }

}

@Composable
private fun SubcategoryListImageItem(
    subcategory: SubCategory,
    modifier: Modifier = Modifier
){
    Box(
        modifier=modifier
    ){
        Image(
            painter = painterResource(subcategory.subCategoryIcon),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
private fun SubcategoryListItem(
    subcategory: SubCategory,
    onItemClick: (SubCategory) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(subcategory) }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))

        ) {
            SubcategoryListImageItem(
                subcategory,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(subcategory.name),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space)),

                    )


            }


        }

    }
}

@Composable
private fun SubcategoryList(
    subcategory:List<SubCategory>,
    onClick: (SubCategory) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
    ){
        items(items = subcategory, key = {subcategory -> subcategory.id}){ subcategory ->
            SubcategoryListItem(
                subcategory = subcategory,
                onItemClick = onClick
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CategoryListItemPreview(){
    MyCityTheme {
        CategoryListItem(
            category = LocalCategoryDataProvider.defaultCategory,
            onItemClick = {}
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    onBackButtonClick: () -> Unit,
    isShowingCategoryPage: Boolean,
    isShowingSubcategoryPage: Boolean,

    //windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
){
    val isShowingDetailPage= !isShowingCategoryPage && !isShowingSubcategoryPage
    TopAppBar(
        title = {
            Text(
                text=
                    if (isShowingDetailPage)
                        stringResource(R.string.detail_fragment_label)
                    else if (isShowingSubcategoryPage)
                        stringResource(R.string.subcategory_fragment_label)
                    else
                        stringResource(R.string.category_fragment_label)
            )
        },
        navigationIcon =
        if (!isShowingCategoryPage)  {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
        else{
            {
                Box() { }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
    )
}

@Preview
@Composable
fun CategoryListPreview(){
    MyCityTheme() {
        Surface() {
            CategoryList(
                category = LocalCategoryDataProvider.getCategoryData(),
                onClick = {}
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SubcategoryListItemPreview(){
    MyCityTheme {
        SubcategoryListItem(
            subcategory = LocalCategoryDataProvider.defaultSubcategory,
            onItemClick = {}
        )

    }
}

@Preview
@Composable
fun SubcategoryListPreview(){
    MyCityTheme() {
        Surface() {
            SubcategoryList(
                subcategory = LocalCategoryDataProvider.getCategoryData()[0].subCategories,
                onClick = {}
            )
        }

    }
}
