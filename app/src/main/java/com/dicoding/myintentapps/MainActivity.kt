package com.dicoding.myintentapps

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var btnMoveActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activiity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

//        tvResult = findViewById(R.id.tv_result)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
//                explicit intent
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
//                explicit intent mengirimkan data ke page baru
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dicoding Academy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activiity_object -> {
                val person = Person(
                    "Dicoding Academy",
                    5,
                    "danangipulbasrin@gmail.com",
                    "Bandung"
                )

//                val persons = Person(
//                    "Dicoding Academy",
//                    5,
//                    "danangipulbasrin@gmail.com",
//                    "Bandung"
//                )

                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
//                jika data object hanya 1
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
//                jika data berupa array of object, maka pakai yang bawah
//                moveWithObjectIntent.putParcelableArrayListExtra(MoveWithObjectActivity.EXTRA_PERSON, persons)
                startActivity(moveWithObjectIntent)

            }

//            implicit intent
            R.id.btn_dial_number -> {
                val phoneNumber = "085867438757"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
//                resultLauncher.launch(moveForResultIntent)
            }


        }
    }
}