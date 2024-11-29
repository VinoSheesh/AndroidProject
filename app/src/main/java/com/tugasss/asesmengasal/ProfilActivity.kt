package com.tugasss.pjbl_vino

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfilActivity : AppCompatActivity() {

    lateinit var back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profil)

        init()
        pindah()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun pindah() {
        back.setOnClickListener{
            val intent = Intent(this@ProfilActivity,DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init(){
        back = findViewById(R.id.back)
    }
}