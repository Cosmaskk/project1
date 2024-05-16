package com.Hama.schooladmission.ui.theme.Screens.SchoolAdministration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.Hama.schooladmission.data.StudentViewModel
import com.Hama.schooladmission.navigation.ROUTE_VIEW_STUDENTS
import org.w3c.dom.Text

@Composable
fun AddStudentScreen(navController: NavHostController){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var context = LocalContext.current
        Text(text = "Add Student",
            fontSize = 26.sp,
            modifier = Modifier.padding(20.dp),
            textDecoration = TextDecoration.Underline)
        var studentName by remember { mutableStateOf(TextFieldValue("")) }
        var studentAdm by remember { mutableStateOf(TextFieldValue("")) }
        var studentClass by remember { mutableStateOf(TextFieldValue("")) }
        var studentStream by remember { mutableStateOf(TextFieldValue("")) }
        var studentMarks by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(value = studentName, onValueChange = {studentName = it},
            label = { Text(text = "student Name *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = studentAdm, onValueChange = {studentAdm = it},
            label = { Text(text = "student Adm *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = studentMarks, onValueChange = {studentMarks = it},
            label = { Text(text = "student Marks *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = studentClass, onValueChange = {studentClass = it},
            label = { Text(text = "student Class *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = studentStream, onValueChange = {studentStream = it},
            label = { Text(text = "student Stream *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
//          studentRepository = StudentViewModel(navController,context)
            navController.navigate(ROUTE_VIEW_STUDENTS)
        }) {
            Text(text = "Upload")
        }
        Button(onClick = {
            //-----------WRITE THE UPLOAD LOGIC HERE---------------//

            navController.navigate(ROUTE_VIEW_STUDENTS)

        }) {
            Text(text = "view students")
        }
    }
}
@Preview
@Composable
fun AddStudentScreenPreview(){
    AddStudentScreen(rememberNavController())
}