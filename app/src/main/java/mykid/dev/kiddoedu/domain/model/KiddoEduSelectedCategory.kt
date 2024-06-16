package mykid.dev.kiddoedu.domain.model

import mykid.dev.kiddoedu.R

data class KiddoEduSelectedCategory(
    val selectedCategoryName: String,
    val selectedCategoryImage: Int = R.drawable.ic_tomato
)
