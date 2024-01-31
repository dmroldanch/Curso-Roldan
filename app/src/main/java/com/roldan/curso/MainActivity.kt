package com.roldan.curso
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.roldan.curso.screens.MatchScreen
import com.roldan.curso.ui.theme.CursoTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val matchScreen = MatchScreen()
        setContent {
            CursoTheme {
                matchScreen.CreateMatchScreen()
            }
        }
    }
}