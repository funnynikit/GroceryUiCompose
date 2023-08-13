package com.compose.grocerycompose.content

import com.compose.grocerycompose.R

val fruitList = listOf<Fruit>(
    Fruit(
        R.drawable.papaya,
        40,
        "Papaya",
        "Papaya is a melon-like fruit, which varies greatly in shape and size. The skin of unripe fruit is smooth, green, and thin and changes to deep orange or yellow when ripe. The flesh varies from 2.5 to 5.0 cm in thickness and yellow to orange in color."
    ),
    Fruit(
        R.drawable.mango,
        80,
        "Mango",
        "A mango is a sweet tropical fruit, and it's also the name of the trees on which the fruit grows. Ripe mangoes are juicy, fleshy, and delicious. Like peaches and plums, mangoes have an inedible pit at the center. Unlike these other fruits, the skin of a mango is very tough and also inedible."
    ),
    Fruit(
        R.drawable.guava,
        60,
        "Guava",
        "The fruits are round to pear-shaped and measure up to 7.6 cm in diameter; their pulp contains many small hard seeds (more abundant in wild forms than in cultivated varieties). The fruit has a yellow skin and white, yellow, or pink flesh. The musky, at times pungent, odour of the sweet pulp is not always appreciated."
    ),
    Fruit(
        R.drawable.grape,
        120,
        "Grapes",
        "A grape is a fruit, botanically a berry, of genus Vitis and family Vitaceae. Grapes grow in clusters of 15–300 in different colors (crimson, black, dark blue, yellow, green, orange, pink, and white) and are specifically a nonclimacteric type and deciduous crop."
    ),
    Fruit(
        R.drawable.banana,
        50,
        "Banana",
        "A banana is a curved, yellow fruit with a thick skin and soft sweet flesh. If you eat a banana every day for breakfast, your roommate might nickname you \"the monkey.\" A banana is a tropical fruit that's quite popular all over the world. It grows in bunches on a banana tree."
    ),
    Fruit(
        R.drawable.apple,
        160,
        "Apple",
        "The apple is one of the pome (fleshy) fruits. Apples at harvest vary widely in size, shape, colour, and acidity, but most are fairly round and some shade of red or yellow. The thousands of varieties fall into three broad classes: cider, cooking, and dessert varieties."
    )
)

val chipList = listOf<String>("Fruits", "Vegitable", "Sweets", "Drinks", "Cake")

data class Fruit(val image: Int, val rs: Int, val title: String, val subTitle: String)