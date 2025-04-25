package com.example.modernuidashboards
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
fun MyUI() {
    Scaffold { paddingValues ->
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
    Row(){
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













