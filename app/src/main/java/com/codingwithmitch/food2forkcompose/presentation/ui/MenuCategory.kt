package com.codingwithmitch.food2forkcompose.presentation.ui



enum class MenuCategory(val value: String){
    ERROR("error"),
    CHICKEN("Chicken"),

}

fun getAllMenus(): List<MenuCategory>{
    return listOf(
        MenuCategory.ERROR, MenuCategory.CHICKEN
    )
}
/*
fun getMenu(value: String): MenuCategory? {
    val map = values().associateBy(MenuCategory::value)
    return map[value]
}*/