package com.example.quizapp

object Constants {
    const val userName : String = ""
    val correctAns : String? = null
    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "India",
            "Belgium",
            "Fiji",
            3
        )
        val que2 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Kuwait",
            "Germany",
            2
        )
        val que3 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_kuwait,
            "Brazil",
            "India",
            "Kuwait",
            "Denmark",
            3
        )
        val que4 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_germany,
            "Argentina",
            "New Zealand",
            "Belgium",
            "Germany",
            4
        )
        val que5 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Fiji",
            "Kuwait",
            "Australia",
            1
        )
        val que6 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            "Germany",
            "India",
            "New Zealand",
            "Denmark",
            4
        )
        val que7 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_australia,
            "Belgium",
            "New Zealand",
            "Australia",
            "Brazil",
            3
        )
        val que8 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Kuwait",
            "Denmark",
            "Germany",
            1
        )
        val que9 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_india,
            "Belgium",
            "Brazil",
            "New Zealand",
            "India",
            4
        )
        val que10 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.ic_flag_of_fiji,
            "Denmark",
            "Fiji",
            "Australia",
            "Germany",
            2
        )
        questionList.addAll(listOf(que1,que2,que3,que4,que5,que6,que7,que8,que9,que10))
        return questionList
    }
}