package com.roldan.curso
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roldan.curso.ui.theme.CursoTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color.Magenta,
                                    Color.Cyan
                                )
                            )
                        ),
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                             horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "It's a match!",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            modifier = Modifier
                                .padding(start = 2.dp, bottom = 25.dp,top=100.dp)
                        )
                        Text(
                            text = "You and Julissa have liked each other",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.match),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .align(Alignment.Center)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(20.dp)
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(bottom = 6.dp),
                            onClick = {}
                        ) {
                            Text(
                                text = "Message her",
                                color = Color.Black,
                                fontSize = 16.sp,
                            )
                        }
                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black.copy(alpha = 0.5f)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(top = 6.dp),
                            onClick = {}
                        ) {
                            Text(
                                text = "Keep swiping",
                                color = Color.White,
                                fontSize = 16.sp,)
                        }
                    }
                }
            }
        }
    }
}