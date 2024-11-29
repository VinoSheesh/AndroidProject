package com.tugasss.pjbl_vino

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class KonversiSuhuActivity : AppCompatActivity() {
    lateinit var spSuhuAwal: Spinner
    lateinit var spSuhuAkhir: Spinner
    lateinit var tvHasilSuhuAkhir: TextView
    lateinit var etSuhuAwal: EditText
    lateinit var btKonversi: Button
    lateinit var btBersih: Button
    lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konversi_suhu)
        init()
        pindah()
        etSuhuAwal = findViewById(R.id.etSuhuAwal)
        spSuhuAwal = findViewById(R.id.spSuhuAwal)
        spSuhuAkhir = findViewById(R.id.spSuhuAkhir)
        tvHasilSuhuAkhir = findViewById(R.id.tvHasilSuhuAkhir)
        btKonversi = findViewById(R.id.btKonversi)
        btBersih = findViewById(R.id.btBersihkan)

        btKonversi.setOnClickListener {
            konversiSuhu()
        }

        btBersih.setOnClickListener {
            bersihkanInput()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun pindah () {
        back.setOnClickListener{
            val intent = Intent(this@KonversiSuhuActivity,DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun konversiSuhu() {
        val decimalFormat = DecimalFormat("#.###")


        if (etSuhuAwal.text.isEmpty()) {
            Toast.makeText(this, "Tolong masukkan suhu", Toast.LENGTH_SHORT).show()
            tvHasilSuhuAkhir.text = "-"
            return
        }


        val suhuAwal = etSuhuAwal.text.toString().toDouble()

        val suhuAwalString = spSuhuAwal.selectedItem.toString()

        val suhuAkhirString = spSuhuAkhir.selectedItem.toString()

        var suhuAkhir = suhuAwal

        when (suhuAwalString) {
            "Celsius" -> {
                suhuAkhir = when (suhuAkhirString) {
                    "Celsius" -> suhuAwal
                    "Fahrenheit" -> (suhuAwal * 9 / 5) + 32
                    "Kelvin" -> suhuAwal + 273.15
                    else -> suhuAwal
                }
            }
            "Fahrenheit" -> {
                suhuAkhir = when (suhuAkhirString) {
                    "Celsius" -> (suhuAwal - 32) * 5 / 9
                    "Fahrenheit" -> suhuAwal
                    "Kelvin" -> (suhuAwal - 32) * 5 / 9 + 273.15
                    else -> suhuAwal
                }
            }
            "Kelvin" -> {
                suhuAkhir = when (suhuAkhirString) {
                    "Celsius" -> suhuAwal - 273.15
                    "Fahrenheit" -> (suhuAwal - 273.15) * 9 / 5 + 32
                    "Kelvin" -> suhuAwal
                    else -> suhuAwal
                }
            }
        }

        val hasilTerformat = decimalFormat.format(suhuAkhir)
        tvHasilSuhuAkhir.text = hasilTerformat
    }

    private fun bersihkanInput() {
        etSuhuAwal.text.clear()
        tvHasilSuhuAkhir.text = "-"
        spSuhuAwal.setSelection(0)
        spSuhuAkhir.setSelection(0)
    }

    private fun init() {
        back = findViewById(R.id.back)
    }
}
