package com.Hama.schooladmission.ui.theme.Screens.SchoolAdministration

//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import coil.compose.rememberAsyncImagePainter
//import com.Hama.schooladmission.data.StudentViewModel
//import com.Hama.schooladmission.models.Add
//import com.Hama.schooladmission.navigation.ROUTE_ADD_STUDENTS
//
//
//private val Any.imageUrl: Any
//    get() {
//        return imageUrl
//    }
//
//@Composable
//fun UploadItem(
//    name: Any,
//    admission: Any,
//    stream: Any,
//    imageUrl: Any,
//    id: Any,
//    marks: Any,
//    navController: NavHostController,
//    studentRepository: StudentViewModel
//) {
//    TODO("Not yet implemented")
//}
//
//@Composable
//fun ViewUploadsScreen(navController:NavHostController) {
//    Column(modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//
//        var context = LocalContext.current
//        var studentRepository = StudentViewModel(navController, context)
//
//
//        val emptyUploadState = remember { mutableStateOf(Add("","","","","")) }
//        var emptyUploadsListState = remember { mutableStateListOf<Add>() }
//
//        var uploads = studentRepository.viewStudents(emptyUploadState, emptyUploadsListState)
//
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "All uploads",
//                fontSize = 30.sp,
//                fontFamily = FontFamily.Cursive,
//                color = Color.Red)
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            LazyColumn(){
//                items(uploads){
//                    UploadItem(name = it.name, admission = it.admission, stream = it.stream, imageUrl = it.imageUrl, id = it.id, marks = it.marks, navController = navController, studentRepository = studentRepository)
//
//                }
//            }
//        }
//    }
//
//
//
//
//
//@Composable
//fun UploadItem(name:String, admission:String, stream: String, imageUrl:String, id:String,marks: String,
//               navController:NavHostController, studentRepository:StudentViewModel) {
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        Text(text = name)
//        Text(text = admission)
//        Text(text = stream)
//        Image(
//            painter = rememberAsyncImagePainter(imageUrl),
//            contentDescription = null,
//            modifier = Modifier.size(128.dp)
//        )
//        Button(onClick = {
//            //studentRepository.deleteStudent(id)
//        }) {
//            Text(text = "Delete")
//        }
//        Button(onClick = {
//            navController.navigate(ROUTE_ADD_STUDENTS+"/$id")
//        }) {
//            Text(text = "Update")
//        }
//    }
//}}