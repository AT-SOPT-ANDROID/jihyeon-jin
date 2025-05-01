package org.sopt.at.data.repositoryimpl

import org.sopt.at.R
import org.sopt.at.core.type.ContentType
import org.sopt.at.core.type.toContentCategory
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
                R.drawable.img_program_shin_byeong,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "콘크리트 유토피아",
                R.drawable.img_program_utopia,
                ContentType.MOVIE.toContentCategory()
            ),
            Program(
                "유퀴즈 온더 블럭",
                R.drawable.img_program_you_quiz,
                ContentType.ENTERTAINMENT.toContentCategory()
            )
        )
    )

    override fun getTop20Items(): HomeRecommendation = HomeRecommendation(
        title = "오늘의 티빙 TOP 20",
        programList = listOf(
            Program(
                "신병3",
                R.drawable.img_program_shin_byeong,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "유퀴즈 온더 블럭",
                R.drawable.img_program_you_quiz,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "나는 솔로",
                R.drawable.img_program_im_solo,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "이혼 숙려 캠프",
                R.drawable.img_program_camp,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "이혼 보험",
                R.drawable.img_program_ehon,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "놀라운 토요일",
                R.drawable.img_program_amazing,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "외계+인 1부",
                R.drawable.img_program_alien,
                ContentType.MOVIE.toContentCategory()
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "짱구는 못말려 24기",
                R.drawable.img_program_crayon_shin,
                ContentType.ANIMATION.toContentCategory()
            ),
            Program(
                "신병3",
                R.drawable.img_program_shin_byeong,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "유퀴즈 온더 블럭",
                R.drawable.img_program_you_quiz,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "나는 솔로",
                R.drawable.img_program_im_solo,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "이혼 숙려 캠프",
                R.drawable.img_program_camp,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "이혼 보험",
                R.drawable.img_program_ehon,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "놀라운 토요일",
                R.drawable.img_program_amazing,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "외계+인 1부",
                R.drawable.img_program_alien,
                ContentType.MOVIE.toContentCategory()
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "짱구는 못말려 24기",
                R.drawable.img_program_crayon_shin,
                ContentType.ANIMATION.toContentCategory()
            )
        )
    )

    override fun getNowItems(): HomeRecommendation = HomeRecommendation(
        title = "지금 방영 중인 콘텐츠",
        programList = listOf(
            Program(
                "신병3",
                R.drawable.img_program_shin_byeong,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "유퀴즈 온더 블럭",
                R.drawable.img_program_you_quiz,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "나는 솔로",
                R.drawable.img_program_im_solo,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "언젠가는 슬기로울 전공의생활",
                R.drawable.img_program_doctor,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "이혼 숙려 캠프",
                R.drawable.img_program_camp,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "이혼 보험",
                R.drawable.img_program_ehon,
                ContentType.DRAMA.toContentCategory()
            ),
            Program(
                "놀라운 토요일",
                R.drawable.img_program_amazing,
                ContentType.ENTERTAINMENT.toContentCategory()
            ),
            Program(
                "바니와 오빠들",
                R.drawable.img_program_bunny,
                ContentType.DRAMA.toContentCategory()
            )
        ).reversed()
    )
}