package com.example.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Breaking: Climate change critical point",
        "In a recent report, scientists warn that has reached a critical threshold. Urgent is required to mitigate the severe consequences expected over the next decade. Discover the steps being taken globally to address this pressing issue.",
        R.drawable.onboarding1
    ),
    Page(
        "Giants: The futureIntelligence",
        "Major technology companies have come together to collaborate.This unprecedented alliance aims to ensure AI development benefits all of humanity. Learn about the groundbreaking innovations and ethical considerations shaping the future.",
        R.drawable.onboarding2
    ),
    Page(
        "Health: Breakthroughs medical science",
        "Medical researchers have unveiled a series of to revolutionize healthcare. From  to innovative technologies, explore how these advancements will enhance patient care and improve quality of life worldwide.",
        R.drawable.onboarding3
    )

)
