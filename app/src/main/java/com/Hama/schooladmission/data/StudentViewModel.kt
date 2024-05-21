package com.Hama.schooladmission.data


import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.Hama.schooladmission.models.Add
import com.Hama.schooladmission.models.Student
import com.Hama.schooladmission.navigation.ROUTE_STUDENTLOGIN
import com.Hama.schooladmission.navigation.ROUTE_VIEW_UPLOAD
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class StudentViewModel (var navController: NavHostController, var context: Context){

    fun deleteStudent(id: String, context: Context, progress:ProgressDialog) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Students/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Student deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun updateStudent(name: String, admission: String, stream: String, marks: String, id: String, context: Context, progress: ProgressDialog) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Students/$id")
        progress.show()
        var updateData = Student(name, admission , stream, marks, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }



    fun viewStudents(
        emptystudentState: MutableState<Unit>, emptystudentsListState: SnapshotStateList<Student>,
        emptyUploadState: MutableState<Unit>, emptyUploadsListState: SnapshotStateList<Student>

    ) {

    }

    fun viewStudents(emptyUploadState: MutableState<Unit>, emptyUploadsListState: SnapshotStateList<Student>){

    }

    fun deleteStudent(id: String) {

    }


    val UploadStudent: Unit
        get() {
            TODO()
        }
    val studentRepository: Unit = Unit
    var authRepository: AuthViewModel = AuthViewModel(navController, context)
    var progress: ProgressDialog

    init {
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_STUDENTLOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }}

fun student(
    studentname: String,
    studentadmission: String,
    studentstream: String,
    studentmarks: String,
    id: String
): Any {
    TODO("Not yet implemented")
}

fun saveStudent(studentname: String, studentadmission: String, studentmarks: String, studentstream: String, context: Context, progress:ProgressDialog) {
    var id = System.currentTimeMillis().toString()
    var studentData = student(studentname, studentadmission,  studentstream, studentmarks, id)
    var studentRef = FirebaseDatabase.getInstance().getReference()
        .child("Students/$id")
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





fun saveStudentWithImage(studentname:String, studentadmission: String, studentstream: String, studentmarks: String, filePath: Uri, progress: ProgressDialog, context: Context, navController: NavHostController){
    var id = System.currentTimeMillis().toString()
    var storageReference = FirebaseStorage.getInstance().getReference().child("Uploads/$id")
    progress.show()

    storageReference.putFile(filePath).addOnCompleteListener{
        progress.dismiss()
        if (it.isSuccessful){
            // Proceed to store other data into the db
            storageReference.downloadUrl.addOnSuccessListener {
                var imageUrl = it.toString()
                var houseData = Add(studentname,studentadmission,
                    studentmarks,imageUrl,id)
                var dbRef = FirebaseDatabase.getInstance()
                    .getReference().child("Uploads/$id")
                dbRef.setValue(houseData)
                Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_VIEW_UPLOAD)
            }
        }else{
            Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
        }
    }
}


fun viewUploads(upload:MutableState<Add>, uploads:SnapshotStateList<Add>, progress: ProgressDialog, context: Context): SnapshotStateList<Add> {
    var ref = FirebaseDatabase.getInstance().getReference().child("Uploads")

    progress.show()
    ref.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            progress.dismiss()
            uploads.clear()
            for (snap in snapshot.children){
                val value = snap.getValue(Add::class.java)
                upload.value = value!!
                uploads.add(value)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
        }
    })
    return uploads
}
fun viewStudents(
    emptyUploadState: MutableState<Unit>, emptyUploadsListState: SnapshotStateList<Student>,
    emptystudentState: MutableState<Add>, emptystudentsListState: SnapshotStateList<Add>,
    student: MutableState<Student>, context: Context, progress:ProgressDialog,
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
//                student.Add(value)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
        }
    })
    return students

}
