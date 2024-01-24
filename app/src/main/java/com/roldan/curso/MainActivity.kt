package com.roldan.curso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roldan.curso.ui.theme.CheckBlue
import com.roldan.curso.ui.theme.CursoTheme
import com.roldan.curso.ui.theme.TinderColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Roldan")
                    AboutUserView()


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun AboutUserView() {

    var isButtonClicked by remember { mutableStateOf(false) }
    val iconShop = painterResource(id = R.drawable.icon_shop)
    val iconMusic = painterResource(id = R.drawable.icon_music)
    val iconCoffee = painterResource(id = R.drawable.icon_coffee)
    val iconBook = painterResource(id = R.drawable.icon_book)
    val iconPiano = painterResource(id = R.drawable.icon_piano)
    val iconFootball = painterResource(id = R.drawable.icon_ball)
    val arrowBack: Int = R.drawable.icon_arrowback


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.White),
        ) {
            Image(
                painter = painterResource(R.drawable.woman),
                contentDescription = "Woman",
                modifier = Modifier.fillMaxSize()
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .background(Color.White, shape = CircleShape)
                    .size(48.dp)
            )  {
                val arrowPainter: Painter = painterResource(id = arrowBack)
                Icon(arrowPainter, contentDescription = "Arrow Back")

            }


        }

        //About User
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = TopStart
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(32.dp))
            ){
                Row{
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1F)
                            .fillMaxWidth()
                    ) {
                        Row {
                            Text(
                                style = MaterialTheme.typography.titleLarge,
                                text = "Miriam, 24"
                            )

                            WidthSpacer(size = 8)
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = "Location",
                                tint = CheckBlue
                            )
                        }
                        Row{
                            Icon(
                                Icons.Default.LocationOn,
                                contentDescription = "Location",
                                tint = TinderColor
                            )
                            Text(
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.LightGray,
                                text = "New York | 25 km"
                            )
                        }
                    }
                    Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(0.5F),
                                horizontalAlignment = End
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    color = Color.White,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "9.2",
                                color = Color.Black,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                    }
                }


                HeightSpacer(25)

                //Interests: First Line
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.5F)
                    ) {
                        Text(
                            style = MaterialTheme.typography.titleMedium,
                            text = "Interests"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.5F),
                        horizontalAlignment = End
                    ) {
                        Text(
                            style = MaterialTheme.typography.titleSmall,
                            color = TinderColor,
                            text = "Similar"
                        )
                    }
                }

                //First Line of Interests
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            Color.LightGray.copy(alpha = 0.5f),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = iconShop,
                                contentDescription = "Shopping",
                                tint = Color.Black
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                text = "Shop",

                                )
                        }
                    }

                    WidthSpacer(size = 8)

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            Color.LightGray.copy(alpha = 0.5f),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = iconMusic,
                                contentDescription = "Music",
                                tint = Color.Black
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                text = "Music",
                            )
                        }
                    }

                    WidthSpacer(size = 8)

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            Color.LightGray.copy(alpha = 0.5f),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = iconCoffee,
                                contentDescription = "Coffee",
                                tint = Color.Black
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                text = "Coffee",
                            )
                        }
                    }
                }

                //Interests: Second Line
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            Color.LightGray.copy(alpha = 0.5f),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = iconBook,
                                contentDescription = "Books",
                                tint = Color.Black
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                text = "Books",

                                )
                        }
                    }

                    WidthSpacer(size = 8)

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            Color.LightGray.copy(alpha = 0.5f),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = iconPiano,
                                contentDescription = "Piano",
                                tint = Color.Black
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                text = "Piano",
                            )
                        }
                    }

                    WidthSpacer(size = 8)

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            Color.LightGray.copy(alpha = 0.5f),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = iconFootball,
                                contentDescription = "Sports",
                                tint = Color.Black
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                text = "Sports",
                            )
                        }
                    }
                }

                HeightSpacer(size = 8)

                //Buttons to the bottom of the page
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    //Dislike button
                    FloatingActionButton(
                        onClick = { /* Acción cuando se hace clic en el botón X */ },
                        modifier = Modifier
                            .size(56.dp),
                        contentColor = TinderColor,
                        containerColor = Color.White
                    ) {
                        Icon(Icons.Default.Clear, contentDescription = "Close")
                    }

                    // Spacer between buttons
                    WidthSpacer(size = 16)

                    // Like button
                    FloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .size(56.dp),
                        contentColor = TinderColor,
                        containerColor = Color.White
                    ) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite")
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUserPreview() {
    CursoTheme {
        AboutUserView()
    }
}

@Composable
fun HeightSpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun WidthSpacer(size: Int) {
    Spacer(modifier = Modifier.width(size.dp))
}
