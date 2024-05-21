package com.Hama.schooladmission.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.Hama.schooladmission.navigation.ROUTE_STUDENTLOGIN
import com.Hama.schooladmission.navigation.ROUTE_VIEW_STUDENTS
import com.google.firebase.auth.FirebaseAuth


class AuthViewModel (var navController: NavController, var context: Context){

    var mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth= FirebaseAuth.getInstance()
        progress= ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait.....")
    }
    fun login(name: String, pass: String){
        progress.show()

        mAuth.signInWithEmailAndPassword(name, pass.toString()).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_VIEW_STUDENTS)
//                navController.navigate(ROUTE_HOME)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_STUDENTLOGIN)
            }
        }

    }
    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_STUDENTLOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}
