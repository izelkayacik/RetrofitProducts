package com.izelkayacik.hizligeliyotest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.izelkayacik.hizligeliyotest.R

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

       val girisYap = findViewById<Button>(R.id.girisYap)

        girisYap.setOnClickListener{

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }

    }
