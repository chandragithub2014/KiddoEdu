package mykid.dev.kiddoedu.utils

import android.content.Context
import mykid.dev.kiddoedu.R
import mykid.dev.kiddoedu.domain.model.KiddoEduCategory
import mykid.dev.kiddoedu.domain.model.KiddoEduSelectedCategory

fun fetchKiddoEduCategories(context: Context) = listOf(
    KiddoEduCategory(
        context.getString(R.string.kiddo_edu_category_vegetables),
        R.drawable.ic_tomato
    ),
    KiddoEduCategory(context.getString(R.string.kiddo_edu_category_fruits), R.drawable.ic_fruit),
    KiddoEduCategory(context.getString(R.string.kiddo_edu_category_animals), R.drawable.ic_animal),
    KiddoEduCategory(context.getString(R.string.kiddo_edu_category_shapes), R.drawable.ic_shape)
)


fun fetchSelectedCategoryVegetables(context: Context) = listOf(
    KiddoEduSelectedCategory("Tomato"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("Carrot"),
    KiddoEduSelectedCategory("EggVegetable"),
    KiddoEduSelectedCategory("Okra"),
    KiddoEduSelectedCategory("Beetroot")
)

