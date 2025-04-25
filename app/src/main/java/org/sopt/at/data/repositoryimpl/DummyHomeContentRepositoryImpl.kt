package org.sopt.at.data.repositoryimpl

import org.sopt.at.R
import org.sopt.at.domain.model.HomeRecommendation
import org.sopt.at.domain.model.Program
import org.sopt.at.domain.repository.DummyHomeProgramRepository
import javax.inject.Inject

class DummyHomeContentRepositoryImpl @Inject constructor() : DummyHomeProgramRepository {
    override fun getBannerItems(): HomeRecommendation = HomeRecommendation(
        title = "",
        programList = listOf(
            Program(
                "신병3",
                R.drawable.img_program_shin_byeong
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny
            ),
            Program(
                "콘크리트 유토피아",
                R.drawable.img_program_utopia
            )
        )
    )

    override fun getTop20Items(): HomeRecommendation = HomeRecommendation(
        title = "오늘의 티빙 TOP 20",
        programList = listOf(
            Program(
                "신병3",
                R.drawable.img_program_shin_byeong
            ),
            Program(
                "유퀴즈 온더 블럭",
                R.drawable.img_program_you_quiz
            ),
            Program(
                "나는 솔로",
                R.drawable.img_program_im_solo
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor
            ),
            Program(
                "이혼 숙려 캠프",
                R.drawable.img_program_camp
            ),
            Program(
                "이혼 보험",
                R.drawable.img_program_ehon
            ),
            Program(
                "놀라운 토요일",
                R.drawable.img_program_amazing
            ),
            Program(
                "외계+인 1부",
                R.drawable.img_program_alien
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny
            ),
            Program(
                "짱구는 못말려 24기",
                R.drawable.img_program_crayon_shin
            ),
            Program(
                "신병3",
                R.drawable.img_program_shin_byeong
            ),
            Program(
                "유퀴즈 온더 블럭",
                R.drawable.img_program_you_quiz
            ),
            Program(
                "나는 솔로",
                R.drawable.img_program_im_solo
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor
            ),
            Program(
                "이혼 숙려 캠프",
                R.drawable.img_program_camp
            ),
            Program(
                "이혼 보험",
                R.drawable.img_program_ehon
            ),
            Program(
                "놀라운 토요일",
                R.drawable.img_program_amazing
            ),
            Program(
                "외계+인 1부",
                R.drawable.img_program_alien
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny
            ),
            Program(
                "짱구는 못말려 24기",
                R.drawable.img_program_crayon_shin
            )
        )
    )

    override fun getNowItems(): HomeRecommendation = HomeRecommendation(
        title = "지금 방영 중인 콘텐츠",
        programList = listOf(
            Program(
                "신병3",
                R.drawable.img_program_shin_byeong
            ),
            Program(
                "유퀴즈 온더 블럭",
                R.drawable.img_program_you_quiz
            ),
            Program(
                "나는 솔로",
                R.drawable.img_program_im_solo
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor
            ),
            Program(
                "이혼 숙려 캠프",
                R.drawable.img_program_camp
            ),
            Program(
                "이혼 보험",
                R.drawable.img_program_ehon
            ),
            Program(
                "놀라운 토요일",
                R.drawable.img_program_amazing
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny
            )
        ).reversed()
    )
}