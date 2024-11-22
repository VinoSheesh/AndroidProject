package com.tugasss.pjbl_vino

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class DashboardActivity : AppCompatActivity() {

    lateinit var cv1 : CardView
    lateinit var cv2 : CardView
    lateinit var cv3 : CardView
    lateinit var cv4 : CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        init()
        pindah()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun pindah () {
        cv1.setOnClickListener{
            val intent = Intent(this@DashboardActivity,KalkulatorActivity::class.java)
            startActivity(intent)
        }

        cv2.setOnClickListener{
            val intent = Intent (this@DashboardActivity,KonversiSuhuActivity::class.java)
            startActivity(intent)
        }

        cv3.setOnClickListener{
            val intent = Intent (this@DashboardActivity,FormulirActivity::class.java)
            startActivity(intent)
        }

        cv4.setOnClickListener{
            val intent = Intent (this@DashboardActivity,ProfilActivity::class.java)
            startActivity(intent)
        }
    }
    fun init() {
        cv1 = findViewById(R.id.cv1)
        cv2 = findViewById(R.id.cv2)
        cv3 = findViewById(R.id.cv3)
        cv4 = findViewById(R.id.cv4)
    }

}