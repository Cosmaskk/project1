package com.Hama.schooladmission.models

class User {
    var name: String=""
    var pass: String=""
    var userid: String=""
    constructor(name: String,pass:String, userid:String){
        this.name =name
        this.pass=pass
        this.userid=userid
    }
    constructor()
}