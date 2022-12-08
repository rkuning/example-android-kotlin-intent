package com.dicoding.myintentapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject : TextView = findViewById(R.id.tv_object_received)

//        jika objectnya 1
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person

//        jika ada array of obeject maka pakai dibawah ini
//        val persons = intent.getParcelableArrayListExtra<Person>(EXTRA_PERSON) as ArrayList<Person>
        val text = "Name : ${person.name.toString()},\n Email : ${person.email}, \n Age : ${person.age}, \n Location : ${person.city}"
        tvObject.text = text
    }

}