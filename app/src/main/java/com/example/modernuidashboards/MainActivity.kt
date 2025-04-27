package com.example.modernuidashboards
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.graphics.toColorInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyUI()
        }
    }
}
@Composable
@Preview(showBackground = true)
@Composable
fun MyUI() {
    val scaffoldState = rememberScaffoldState() // Declare scaffoldState

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            MyBottomBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchRow()
            Banner()
            Categories()
            PopularCourses()
            ItemList()
        }
    }
}


@Composable
fun MyBottomBar() {
    TODO("Not yet implemented")
}
@Composable
fun PrepareBottomMenu(): List<BottomMenuItem>{
    val BottomMenuItemList = arrayListOf<BottomMenuItem>()
    BottomMenuItemList.add(
        BottomMenuItem(
            label = "Explorer",
            icon = 
        )
    )
}
data class BottomMenuItem(
    val label: String,
    val icon: Painter
)
data class Items(
    val title: String,
    val name: String,
    val price: Int,
    val score: Double,
    val picUrl: Int
)
@Composable
fun ItemList() {
  val people: List<Items> = listOf(
      Items("Quick Learn C# Language", "MD: Ratul Master", 128, 4.6, R.drawable.cart),
      Items("Full Course Android Kotlin", "MD: Fazle Rabbi", 170, 4.9, R.drawable.cart),
      Items("Quick Learn C# Language", "MD: Ratul Master", 128, 4.6, R.drawable.cart),
  )
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(people) { item ->
            Column(
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
                    .shadow(3.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .clickable {
                        println("Clicked On: ${item.name}")
                    }
            ) {
                ConstraintLayout(modifier = Modifier.height(IntrinsicSize.Max)) {
                    val (topImg, title, owner,ownerIcon, price, score, scoreIcon) = createRefs()
                    Image(painter = painterResource(R.drawable.cart),
                        contentDescription = null,
                        Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .constrainAs(topImg) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = item.title,
                       modifier =  Modifier
                           .background(Color("#90000000".toColorInt()))
                           .fillMaxWidth()
                           .padding(6.dp)
                           .constrainAs(title) {
                               bottom.linkTo(topImg.bottom)
                               start.linkTo(parent.start)
                           },
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(R.drawable.cart),
                        contentDescription = null,
                        modifier = Modifier
                            .constrainAs(ownerIcon) {
                                start.linkTo(parent.start)
                                top.linkTo(topImg.top)
                            }
                            .padding(start = 16.dp, top = 16.dp)
                    )
                    Text(
                        text = item.name, modifier = Modifier
                            .constrainAs(owner) {
                                start.linkTo(ownerIcon.end)
                                top.linkTo(ownerIcon.top)
                                bottom.linkTo(ownerIcon.bottom)
                            }
                            .padding(start = 16.dp, top = 16.dp)
                    )
                    Text(
                        text = "${item.price}",
                        fontWeight = FontWeight.Bold,
                        color = Color("#521c98".toColorInt()),
                        modifier = Modifier.constrainAs(price) {
                            start.linkTo(ownerIcon.start)
                            top.linkTo(ownerIcon.bottom)
                            bottom.linkTo(parent.bottom)
                        }
                    )
                    Text(
                        text = item.score.toString(),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .constrainAs(score) {
                                end.linkTo(parent.end)
                                top.linkTo(price.top)
                                bottom.linkTo(price.bottom)
                            }
                            .padding(end = 16.dp)
                    )
                    Image(painter = painterResource(R.drawable.cart),
                        contentDescription = null,
                        modifier = Modifier
                            .constrainAs(scoreIcon) {
                                end.linkTo(score.start)
                                top.linkTo(score.top)
                                bottom.linkTo(score.bottom)
                            }
                            .padding(end = 8.dp)
                    )


                }

            }
        }
    }
}
@Composable
private fun SearchRow() {
    var text by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp, start = 16.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    text = "Searching....",
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedTextColor = Color(0xFF5E5E5E),
                unfocusedTextColor = Color(0xFF5E5E5E),
                unfocusedLabelColor = Color(0xFF5E5E5E)
            ),
            modifier = Modifier
                .weight(1f)
                .border(
                    1.dp,
                    Color(0xFF521C98),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color.White, CircleShape)
        )

        Image(
            painter = painterResource(id = R.drawable.bell),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Composable
fun Banner() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .height(160.dp)
            .background(
                color = Color(0xFF521C98),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        val (img, text, buttons) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.snake_man),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .constrainAs(img) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "Advanced Certification \nProgram in AI",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = "Buy Now",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .constrainAs(buttons) {
                    top.linkTo(text.bottom)
                    bottom.linkTo(parent.bottom)
                }
                .background(
                    Color("#f0e9fa".toColorInt()),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(8.dp)
        )
    }
}
@Composable
fun Categories() {
    Row(
        modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "see all",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color("#521c98".toColorInt())
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
    ){
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(
                        color = Color("#f0e9fa".toColorInt()),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(16.dp)
            )
            Text(
                text = "Business",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color("#521c98".toColorInt())
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(
                        color = Color("#f0e9fa".toColorInt()),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(16.dp)
            )
            Text(
                text = "Business",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color("#521c98".toColorInt())
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(
                        color = Color("#f0e9fa".toColorInt()),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(16.dp)
            )
            Text(
                text = "Business",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color("#521c98".toColorInt())
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(
                        color = Color("#f0e9fa".toColorInt()),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(16.dp)
            )
            Text(
                text = "Business",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color("#521c98".toColorInt())
            )
        }
    }
}
@Composable
fun PopularCourses() {
    Row(
        modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "PopularCourses",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "see all",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color("#521c98".toColorInt())
        )
    }
}













