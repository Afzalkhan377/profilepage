package com.example.profilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilepage.ui.theme.ProfilePageTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.runtime.*
import androidx.compose.foundation.shape.CircleShape


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
      ProfileScreen()
        }
    }
}
@Composable
fun ProfileScreen() {
    //variable that tracks if following
    //made it false for now so when pressed becomes true and the snack bar pops up
    var isFollowing by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.lebron),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(200.dp)
                    //gives circular shape
                    .clip(CircleShape)
            )
            //add space
            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Lebron James", fontSize = 20.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "The best hooper of all time and",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Follow Button
            Button(onClick = {
                //when button clicked the variable becomes true
                isFollowing = true
            }) {
                Text("Follow")
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        // Show Snackbar when following
        if (isFollowing) {
            Snackbar(
                modifier = Modifier
                    //appears at bottom
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text("Following")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfilePageTheme {
        ProfileScreen()
    }
}