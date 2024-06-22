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
        SelectedCategory.SHAPES -> {
            fetchSelectedCategoryShapes()
        }
        SelectedCategory.FRUITS -> {
            fetchSelectedCategoryFruits()
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
    KiddoEduSelectedCategory("Zebra",R.drawable.ic_zebra),

)

fun fetchSelectedCategoryFruits() = listOf(
    KiddoEduSelectedCategory("Apple", R.drawable.ic_apple),
    KiddoEduSelectedCategory("Banana", R.drawable.ic_bananas),
    KiddoEduSelectedCategory("Cherry", R.drawable.ic_cherries),
    KiddoEduSelectedCategory("Coconut", R.drawable.ic_coconut),
    KiddoEduSelectedCategory("Grapes", R.drawable.ic_green_grapes),
    KiddoEduSelectedCategory("Lemon", R.drawable.ic_lemon),
    KiddoEduSelectedCategory("Orange", R.drawable.ic_orange),
    KiddoEduSelectedCategory("Kiwi", R.drawable.ic_kiwi),
    KiddoEduSelectedCategory("Pineapple", R.drawable.ic_pineapple),
    KiddoEduSelectedCategory("Mango", R.drawable.ic_mango),
    KiddoEduSelectedCategory("Pomegranate", R.drawable.ic_pomegranate),
    KiddoEduSelectedCategory("Strawberry", R.drawable.ic_strawberry),
    KiddoEduSelectedCategory("Watermelon", R.drawable.ic_watermelon)

)

fun fetchSelectedCategoryShapes() = listOf(
    KiddoEduSelectedCategory("Circle", R.drawable.ic_circle),
    KiddoEduSelectedCategory("Cube", R.drawable.ic_cube),
    KiddoEduSelectedCategory("Cone", R.drawable.ic_cone),
    KiddoEduSelectedCategory("Square", R.drawable.ic_square),
    KiddoEduSelectedCategory("Rectangle", R.drawable.ic_rectangle),
    KiddoEduSelectedCategory("Triangle", R.drawable.ic_triangle),
    KiddoEduSelectedCategory("Hexagon", R.drawable.ic_hexagon),
    KiddoEduSelectedCategory("Pentagon", R.drawable.ic_pentagon),
    KiddoEduSelectedCategory("Octagon", R.drawable.ic_octagon)

)