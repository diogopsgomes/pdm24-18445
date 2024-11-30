package com.example.articles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.articles.presentation.view.ArticleScreen
import com.example.articles.presentation.view.ArticlesScreen
import com.example.articles.presentation.viewmodel.ArticleViewModel
import com.example.articles.presentation.viewmodel.ArticlesViewModel
import com.example.articles.ui.theme.ArticlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticlesTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedArticleUri by remember { mutableStateOf<String?>(null) }

    if (selectedArticleUri == null) {
        val articlesViewModel: ArticlesViewModel = viewModel()
        ArticlesScreen(articlesViewModel) { articleUri ->
            selectedArticleUri = articleUri
        }
    } else {
        val articleViewModel: ArticleViewModel = viewModel()
        ArticleScreen(articleViewModel, selectedArticleUri!!) {
            selectedArticleUri = null
        }
    }
}