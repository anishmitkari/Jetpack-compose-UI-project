package com.anish.jetpackcompose.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.anish.jetpackcompose.R

@Preview
@Composable
fun Dashboard() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(android.graphics.Color.parseColor("#ede7f8")))
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {

            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clickable { })

            Column(
                modifier = Modifier
                    .height(100.dp)
                    .padding(start = 14.dp)
                    .weight(0.7f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start


            ) {
                Text(
                    text = "Anish",
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "anish.mitkari@gmail.com",
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 1.dp)
                )
            }
        }
        var text by rememberSaveable { mutableStateOf("") }

        TextField(value = text,
            onValueChange = { text = it },
            label = { Text(text = "Searching for") },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .height(45.dp)
                        .width(45.dp)
                        .background(
                            Color(android.graphics.Color.parseColor("#fe5b52"))
                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(end = 6.dp)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                unfocusedLabelColor = Color(
                    android.graphics.Color.parseColor("#5e5e5e")
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .background(
                    Color.White, CircleShape
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)

        ) {
            Column(
                Modifier
                    .weight(0.5f)
                    .padding(end = 12.dp)

                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_1),
                        contentDescription = null
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Messenger",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#5e5e5e"))
                    )
                }
            }
            Column(
                Modifier
                    .weight(0.5f)
                    .padding(start = 12.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_2),
                        contentDescription = null
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Messenger",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#5e5e5e"))
                    )
                }
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)

        ) {
            Column(
                Modifier
                    .weight(0.5f)
                    .padding(end = 12.dp)

                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_3),
                        contentDescription = null
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Messenger",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#5e5e5e"))
                    )
                }
            }
            Column(
                Modifier
                    .weight(0.5f)
                    .padding(start = 12.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_4),
                        contentDescription = null
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Messenger",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#5e5e5e"))
                    )
                }
            }


        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(120.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(
                                android.graphics.Color.parseColor("#BFA3EF")
                            ), Color(
                                android.graphics.Color.parseColor("#7E57C2")
                            )
                        )

                    ), shape = RoundedCornerShape(25.dp)
                )
        ) {
            val (img, text1, text2) = createRefs()

            Image(
                modifier = Modifier.constrainAs(img) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }, painter = painterResource(
                    id = R.drawable.arc
                ), contentDescription = ""
            )
            Text(text = "To Get Unlimited",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                        start.linkTo(img.end)
                        end.linkTo(parent.end)
                    })

            Text(text = "Upgrade your account",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(text2) {
                        top.linkTo(text1.bottom)
                        start.linkTo(text1.start)
                        end.linkTo(text1.end)
                        bottom.linkTo(parent.bottom)
                    })
        }


    }
}
