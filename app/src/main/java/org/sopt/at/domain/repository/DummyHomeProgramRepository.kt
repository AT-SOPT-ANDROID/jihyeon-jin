package org.sopt.at.domain.repository

import org.sopt.at.domain.model.HomeRecommendation

interface DummyHomeProgramRepository {
    fun getBannerItems(): HomeRecommendation
    fun getTop20Items(): HomeRecommendation
    fun getNowItems(): HomeRecommendation
}