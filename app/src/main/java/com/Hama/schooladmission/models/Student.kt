package com.Hama.schooladmission.models

class Student {
    var name: String=""
    var admission: String = ""
    var marks: String=""
    var stream: String=""
    var id: String=""
    constructor(name:String,admission:String,marks:String,stream:String,id:String){
        this.name=name
        this.admission=admission
        this.marks=marks
        this.stream=stream
        this.id=id


    }
    constructor()
}