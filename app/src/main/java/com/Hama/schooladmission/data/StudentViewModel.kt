package com.Hama.schooladmission.data

import android.app.ProgressDialog

import android.widget.Toast
import android.content.Context
import android.util.TypedValue
import androidx.navigation.NavHostController
import com.Hama.schooladmission.navigation.ROUTE_STUDENTLOGIN
import com.google.firebase.database.FirebaseDatabase
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.Hama.schooladmission.models.Student
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener



class StudentViewModel (var navController: NavHostController, var context: Context) {
    fun viewStudents(
        emptystudentState: Any,
        emptystudentsListState: SnapshotStateList<Student>
    ) {


    }

    val studentRepository: Unit
        get() {
            TODO()
        }
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_STUDENTLOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }}

fun student(
    studentName: String,
    studentAdm: Int,
    studentStream: Char,
    studentMarks: Int,
    id: String
): Any {
    TODO("Not yet implemented")
}

fun saveStudent(studentName: String, studentAdm: Int, studentMarks: Int, studentStream: Char, context: Context, progress) {
    var id = System.currentTimeMillis().toString()
    var studentData = student(studentName, studentAdm,  studentStream, studentMarks, id)
    var studentRef = FirebaseDatabase.getInstance().getReference()
        .child("Products/$id")
   progress.show()

    studentRef.setValue(studentData).addOnCompleteListener {
        progress.dismiss()
        if (it.isSuccessful) {
            Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
fun viewStudents(
    student: MutableState<Student>,context: Context, progress,
    students: SnapshotStateList<Student>
): SnapshotStateList<Student> {
    val ref = FirebaseDatabase.getInstance().getReference().child("Students")

    progress.show()
    ref.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            progress.dismiss()
            students.clear()
            for (snap in snapshot.children) {
                val value = snap.getValue(Student::class.java)
                student.value = value!!
//                student.add(value)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
        }
    })
    return students

}



fun deleteStudent(id: String, context: Context) {
    var delRef = FirebaseDatabase.getInstance().getReference()
        .child("Students/$id")
//    progress.show()
    delRef.removeValue().addOnCompleteListener {
//        progress.dismiss()
        if (it.isSuccessful) {
            Toast.makeText(context, "Student deleted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
        }
    }
}

//fun student(
//    studentName: String,
//    studentAdm: Int,
////    studentClass: String,
//    studentClass: String,
//    studentStream: Char,
//    studentMarks: Int,
//    id: String
//): Any {
//    TODO("Not yet implemented")
//}

