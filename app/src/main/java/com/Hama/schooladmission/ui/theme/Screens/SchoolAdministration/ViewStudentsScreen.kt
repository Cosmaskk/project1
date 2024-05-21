package com.Hama.schooladmission.ui.theme.Screens.SchoolAdministration



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.Hama.schooladmission.data.StudentViewModel
import com.Hama.schooladmission.models.Student
import com.Hama.schooladmission.navigation.ROUTE_ADD_STUDENTS


val Any.name: String
    get() {
        return name
    }
val Any.admission: String
    get() {
        return admission
    }
val Any.marks:String
    get(){
        return marks
    }
val Any.stream:String
    get() {
        return stream
    }
val Any.id:String
    get(){
        return id
    }

@Composable
fun ViewStudentsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val studentRepository = StudentViewModel(navController, context)
        val emptystudentState = remember { mutableStateOf(Student("","","","")) }
        val emptystudentsListState = remember { mutableStateListOf<Student>() }

        val students = studentRepository.viewStudents(emptystudentState, emptystudentsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All students",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(students){
                    StudentItem(name = it.name, admission = it.admission, marks = it.marks, stream = it.stream, id = it.id, navController = navController, studentRepository = studentRepository)
                }
            }
        }
    }

}

fun items(students: Any, itemContent: @Composable() (LazyItemScope.(index: Int) -> Unit)) {
    TODO("Not yet implemented")
}

//fun <LazyListScope> LazyListScope.items(count: Unit, itemContent: @Composable LazyItemScope.(index: Int) -> Unit) {
//
//}


fun Student(name: String, admission: String, marks: String, stream: String) {

}

@Composable
fun StudentItem(name:String, admission: String,marks: String, stream:String, id:String,
                navController:NavHostController, studentRepository:StudentViewModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = admission)
        Text(text = marks)
        Text(text = stream)
        Text(text = id)
        Button(onClick = {
            studentRepository.deleteStudent(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_ADD_STUDENTS+"/$id")
        }) {
            Text(text = "Add")
        }
    }

}

@Preview
@Composable
fun view() {
    ViewStudentsScreen(rememberNavController())

}