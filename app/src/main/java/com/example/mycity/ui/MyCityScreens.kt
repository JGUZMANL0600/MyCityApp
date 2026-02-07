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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Category
import com.example.mycity.ui.theme.MyCityTheme

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
