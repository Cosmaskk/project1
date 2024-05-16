package com.Hama.schooladmission.ui.theme.Screens.Home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.Hama.schooladmission.R
import com.Hama.schooladmission.navigation.ROUTE_ADD_STUDENTS
//import com.Hama.schooladmission.navigation.ROUTE_SCHOOLADMINISTRATION
import com.Hama.schooladmission.navigation.ROUTE_STUDENTLOGIN

@Composable
fun HomeScreen(navController: NavController){
    Image(painter = painterResource(id = R.drawable.app), contentDescription = "icon", modifier = Modifier.size(300.dp).clip(shape = CircleShape), contentScale = ContentScale.Crop)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Welcome",
            color = Color.Red,
            fontSize = 25.sp)
        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_STUDENTS)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Are you an Institution")}
        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            navController.navigate(ROUTE_STUDENTLOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Are you a student")
        }
        }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}