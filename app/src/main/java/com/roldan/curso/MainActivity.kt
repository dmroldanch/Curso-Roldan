package com.roldan.curso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roldan.curso.ui.theme.CursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val selectedItem = remember { mutableStateOf(0) }
            val items = listOf("Home", "Favorites", "Profile")
            CursoTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting("People Nearby")
                        UserProfileCard()
                        ActionsButtons()
                        Spacer(Modifier.weight(1f)) // This pushes the navigation to the bottom
                        MyNavBar()

                    }
                }
            }
        }
    }
}

// Función para ajustar la transparencia de un color
fun adjustAlpha(color: Color, alpha: Float): Color {
    return color.copy(alpha = alpha)
}

// Uso de la función para crear un color con transparencia
val colorWithTransparency = adjustAlpha(androidx.compose.ui.graphics.Color.Black, 0.5f) // Color negro con 50% de transparencia

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Row {
        Text(
            text = "$text",
            fontSize = 30.sp,
            color = androidx.compose.ui.graphics.Color.White,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        IconButton(
            onClick = { /* TODO: Implement Like Action */ }) {
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp),
                shadowElevation = 2.dp,
                shape = CircleShape,
                border = BorderStroke(2.dp, androidx.compose.ui.graphics.Color.Black),
                color = colorWithTransparency // Usar el color con transparencia
            ) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Like",
                    tint = androidx.compose.ui.graphics.Color.Gray // Color del ícono dentro del botón
                )
            }
        }
    }

}

@Composable
fun UserProfileCard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color.Transparent),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium // Aplicar el mismo redondeo en las 4 esquinas
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(480.dp) // Ajusta la altura de la imagen según tu preferencia
        ) {
            Image(
                painter = painterResource(id = R.drawable.model),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = MaterialTheme.shapes.medium), // Aplicar el mismo redondeo en las 4 esquinas
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize() // El texto se superpone a la imagen
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom // Alinea el texto en la parte inferior
            ) {
                Text("Miriam, 24",color= androidx.compose.ui.graphics.Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Text("New York - 25 miles away",color= androidx.compose.ui.graphics.Color.White, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}


@Composable
fun ActionsButtons(modifier: Modifier = Modifier){
    Row {
        IconButton(
            onClick = { /* TODO: Implement Dislike Action */ }) {
            Surface(
                modifier = Modifier.size(64.dp), // Aumenta el tamaño del círculo del botón
                shadowElevation = 2.dp, // Ajusta la elevación según tus necesidades
                shape = CircleShape, // Cambia la forma del botón si es necesario
                border = BorderStroke(2.dp, androidx.compose.ui.graphics.Color.White) // Añade un borde al botón
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Dislike",
                    tint = androidx.compose.ui.graphics.Color.Red
                )
            }
        }

        IconButton(
            onClick = { /* TODO: Implement Like Action */ }) {
            Surface(
                modifier = Modifier.size(48.dp), // Tamaño del botón
                shadowElevation = 2.dp, // Elevación
                shape = CircleShape, // Forma del botón
                border = BorderStroke(2.dp, androidx.compose.ui.graphics.Color.White), // Borde
            ) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Like",
                    tint = androidx.compose.ui.graphics.Color.Magenta
                )
            }
        }


    }
}

@Composable
fun MyNavBar(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color.White),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .shadow(8.dp, shape = MaterialTheme.shapes.medium) // Agregar sombra y elevación
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // Centrar los elementos horizontalmente
        ) {
            FilledTonalButton(
                onClick = { onClick() },
                modifier = Modifier.padding(3.dp) // Agregar espacio entre los elementos
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Favorite, // Reemplaza con el icono que desees
                        contentDescription = "Icono",
                        tint = androidx.compose.ui.graphics.Color.Magenta,
                        modifier = Modifier.size(24.dp) // Ajusta el tamaño del icono
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Agrega espacio entre el icono y el texto
                    Text("Discover")
                }
            }
            IconButton(
                onClick = { onClick() },
                modifier = Modifier.padding(3.dp) // Agregar espacio entre los elementos
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.MailOutline, // Reemplaza con el icono que desees
                        contentDescription = "Icono",
                        tint = androidx.compose.ui.graphics.Color.Gray,
                        modifier = Modifier.size(24.dp) // Ajusta el tamaño del icono
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Agrega espacio entre el icono y el texto
                    Text("")
                }
            }
            IconButton(
                onClick = { onClick() },
                modifier = Modifier.padding(3.dp) // Agregar espacio entre los elementos
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Person, // Reemplaza con el icono que desees
                        contentDescription = "Icono",
                        tint = androidx.compose.ui.graphics.Color.Gray,
                        modifier = Modifier.size(24.dp) // Ajusta el tamaño del icono
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Agrega espacio entre el icono y el texto
                    Text("")
                }
            }
        }

    }
}


fun onClickTwo() {
    TODO("Not yet implemented")
}

fun onClickOne() {
    TODO("Not yet implemented")
}

fun onClick() {
    TODO("Not yet implemented")
}



