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

fun fetchSelectedCategoryList(selectedCategoryType:String = SelectedCategory.VEGETABLES) : List<KiddoEduSelectedCategory>{
    return when (selectedCategoryType) {
        SelectedCategory.VEGETABLES -> {
            fetchSelectedCategoryVegetables()
        }
        SelectedCategory.ANIMALS -> {
            fetchSelectedCategoryAnimals()
        }
        else -> {
            fetchSelectedCategoryVegetables()
        }
    }

}

fun fetchSelectedCategoryVegetables() = listOf(
    KiddoEduSelectedCategory("Beetroot",R.drawable.ic_beet_root),
    KiddoEduSelectedCategory("Brinjal",R.drawable.ic_brinjal),
    KiddoEduSelectedCategory("Capsicum",R.drawable.ic_capsicum),
    KiddoEduSelectedCategory("Carrot",R.drawable.ic_carrot),
    KiddoEduSelectedCategory("Chilli",R.drawable.ic_chilli),
    KiddoEduSelectedCategory("Eggplant",R.drawable.ic_brinjal),
    KiddoEduSelectedCategory("Garlic",R.drawable.ic_garlic),
    KiddoEduSelectedCategory("Okra",R.drawable.ic_okra),
    KiddoEduSelectedCategory("Potato",R.drawable.ic_potato),
    KiddoEduSelectedCategory("RedChilli",R.drawable.ic_red_chilli),
    KiddoEduSelectedCategory("Pumpkin",R.drawable.ic_pumpkin),
    KiddoEduSelectedCategory("Spinach",R.drawable.ic_spinach),
    KiddoEduSelectedCategory("Tomato",R.drawable.ic_tomato_veg)
)

fun fetchSelectedCategoryAnimals() = listOf(
    KiddoEduSelectedCategory("Bear",R.drawable.ic_bear),
    KiddoEduSelectedCategory("Cat",R.drawable.ic_cat),
    KiddoEduSelectedCategory("Camel",R.drawable.ic_camel),
    KiddoEduSelectedCategory("Cow",R.drawable.ic_cow),
    KiddoEduSelectedCategory("Deer",R.drawable.ic_deer),
    KiddoEduSelectedCategory("Dog",R.drawable.ic_dog),
    KiddoEduSelectedCategory("Elephant",R.drawable.ic_elephant),
    KiddoEduSelectedCategory("Fish",R.drawable.ic_fish),
    KiddoEduSelectedCategory("Frog",R.drawable.ic_frog),
    KiddoEduSelectedCategory("Giraffe",R.drawable.ic_giraffe),
    KiddoEduSelectedCategory("Horse",R.drawable.ic_horse),
    KiddoEduSelectedCategory("Lion",R.drawable.ic_lion),
    KiddoEduSelectedCategory("Monkey",R.drawable.ic_animal),
    KiddoEduSelectedCategory("Mouse",R.drawable.ic_mouse),
    KiddoEduSelectedCategory("Squirrel",R.drawable.ic_squirrel),
    KiddoEduSelectedCategory("Tiger",R.drawable.ic_tiger),
    KiddoEduSelectedCategory("Turtle",R.drawable.ic_turtle),
   // KiddoEduSelectedCategory("Zebra",R.drawable.ic_zebra),

)