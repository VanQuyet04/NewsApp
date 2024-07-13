package com.example.newsapp.presentation.navgraph

sealed class Route(
    val route: String
) {
    object AppStartNavigation : Route("app_start_navigation")
    object OnBoardingScreen : Route("onboarding_screen")

    object HomeScreen : Route("home_screen")
    object SearchScreen : Route("search_screen")
    object BookmarkScreen : Route("bookmark_screen")
    object DetailsScreen : Route("detail_screen")

    object NewsNavigation : Route("news_navigation")
    object NewsNavigatorScreen : Route("news_navigator_screen")
}
