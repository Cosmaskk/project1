package com.Hama.schooladmission.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Hama.schooladmission.ui.theme.Screens.Home.HomeScreen
import com.Hama.schooladmission.ui.theme.Screens.SchoolAdministration.AddStudentScreen
import com.Hama.schooladmission.ui.theme.Screens.SchoolAdministration.ViewStudentsScreen
import com.Hama.schooladmission.ui.theme.Screens.StudentLogin.LoginScreen
//import com.Hama.schooladmission.ui.theme.Screens.SchoolAdministration.ViewStudentsScreen

@Composable
fun AppNavHost(
    modifier: androidx.compose.ui.Modifier.Companion,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME
){
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination){
        composable(ROUTE_HOME){ HomeScreen(navController)}
        composable(ROUTE_ADD_STUDENTS){ AddStudentScreen(navController)}
        composable(ROUTE_STUDENTLOGIN){ LoginScreen(navController)
    }
        composable(ROUTE_VIEW_STUDENTS){ ViewStudentsScreen(navController)}

}}