package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.Source
import com.example.newsapp.presentation.navgraph.NavGraph
import com.example.newsapp.presentation.onboarding.OnBoardingScreen
import com.example.newsapp.presentation.onboarding.OnBoardingViewModel
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewmodel by viewModels<MainViewModel>()

    @Inject
    lateinit var dao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        lifecycleScope.launch {
            dao.upsert(
                Article(
                    author = "",
                    content = "",
                    description = "",
                    publishedAt = "",
                    source = Source(
                        id = "",
                        name = ""
                    ),
                    title = "",
                    url = "",
                    urlToImage = ""
                )
            )
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewmodel.splashCondition
            }
        }

        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val startDestination = viewmodel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}


