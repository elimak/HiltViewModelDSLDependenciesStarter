package com.codingwithmitch.food2forkcompose.presentation.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.codingwithmitch.food2forkcompose.presentation.components.DefaultSnackbar
import kotlinx.coroutines.launch
import java.util.*

private val LightThemeColors = lightColors(
  primary = Blue600,
  primaryVariant = Blue400,
  onPrimary = Black2,
  secondary = Color.White,
  secondaryVariant = Teal300,
  onSecondary = Color.Black,
  error = RedErrorDark,
  onError = RedErrorLight,
  background = Grey1,
  onBackground = Color.Black,
  surface = Color.White,
  onSurface = Black2,
)

private val DarkThemeColors = darkColors(
  primary = Blue700,
  primaryVariant = Color.White,
  onPrimary = Color.White,
  secondary = Black1,
  onSecondary = Color.White,
  error = RedErrorLight,
  background = Color.Black,
  onBackground = Color.White,
  surface = Black1,
  onSurface = Color.White,
)

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun AppTheme(
  darkTheme: Boolean,

  scaffoldState: ScaffoldState,
  content: @Composable () -> Unit,
) {

  val coroutineScope = rememberCoroutineScope() // NEW TEST
  MaterialTheme(
    colors = if (darkTheme) DarkThemeColors else LightThemeColors,
    typography = QuickSandTypography,
    shapes = AppShapes
  ){
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(color = if (!darkTheme) Grey1 else Color.Black)
    ){
      Column{

        content()
      }

      /////////////////////////////////////////////////// NEW
      Button(
        onClick = {
          coroutineScope.launch { // using the `coroutineScope` to `launch` showing the snackbar
            // taking the `snackbarHostState` from the attached `scaffoldState`
            val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
              message = "This is your message",
              actionLabel = "Do something."
            )
            when (snackbarResult) {
              SnackbarResult.Dismissed -> Log.d("SnackbarDemo", "Dismissed")
              SnackbarResult.ActionPerformed -> Log.d("SnackbarDemo", "Snackbar's button clicked")
            }
          }
        }
      ) {
        Text(text = "A button that shows a Snackbar")
      }
    //}/////////////////////////////////////////////   NEW

      DefaultSnackbar(
        snackbarHostState = scaffoldState.snackbarHostState,
        onDismiss = {
          scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
        },
        modifier = Modifier.align(Alignment.BottomCenter)
      )

    }
  }
}






































