package com.tugasss.pjbl_vino

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class KalkulatorActivity : AppCompatActivity() {

    lateinit var clear: Button
    lateinit var divide: Button
    lateinit var multiply: Button
    lateinit var delete: Button
    lateinit var minus: Button
    lateinit var plus: Button
    lateinit var equal: Button
    lateinit var dot: Button
    lateinit var percent: Button
    lateinit var zero: Button
    lateinit var btn0: Button
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var back : ImageView

    lateinit var tvDisplay: EditText

    var NilaiAwal: Double = 0.0
    var aksi: String = ""
    var koma: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        init()
        pencet()
        pindah()
    }

    fun pindah () {
        back.setOnClickListener{
            val intent = Intent(this@KalkulatorActivity,DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isiData() {
        if (tvDisplay.text.isNotEmpty()) {
            NilaiAwal = tvDisplay.text.toString().toDouble()
        }
    }

    private fun hitungHasilSementara() {
        val decimalFormat = DecimalFormat("#.###")
        val nilaiInput = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        val hasil = when (aksi) {
            "tambah" -> NilaiAwal + nilaiInput
            "kurang" -> NilaiAwal - nilaiInput
            "kali" -> NilaiAwal * nilaiInput
            "bagi" -> NilaiAwal / nilaiInput
            "persen" -> NilaiAwal * nilaiInput / 100
            else -> nilaiInput
        }
        NilaiAwal = hasil
        tvDisplay.setText(decimalFormat.format(hasil))
    }

    private fun pencet() {
        clear.setOnClickListener {
            koma = false
            aksi = ""
            NilaiAwal = 0.0
            tvDisplay.text.clear()
        }

        delete.setOnClickListener {
            val currentText = tvDisplay.text.toString()
            if (currentText.isNotEmpty()) {
                tvDisplay.setText(currentText.substring(0, currentText.length - 1))
            }
        }

        btn1.setOnClickListener { tambahAngka("1") }
        btn2.setOnClickListener { tambahAngka("2") }
        btn3.setOnClickListener { tambahAngka("3") }
        btn4.setOnClickListener { tambahAngka("4") }
        btn5.setOnClickListener { tambahAngka("5") }
        btn6.setOnClickListener { tambahAngka("6") }
        btn7.setOnClickListener { tambahAngka("7") }
        btn8.setOnClickListener { tambahAngka("8") }
        btn9.setOnClickListener { tambahAngka("9") }
        btn0.setOnClickListener { tambahAngka("0") }
        zero.setOnClickListener { tambahAngka("00") }

        dot.setOnClickListener {
            if (!tvDisplay.text.contains(".")) {
                tambahAngka(".")
            }
        }

        plus.setOnClickListener { operasi("tambah") }
        minus.setOnClickListener { operasi("kurang") }
        multiply.setOnClickListener { operasi("kali") }
        divide.setOnClickListener { operasi("bagi") }
        percent.setOnClickListener { operasi("persen") }

        equal.setOnClickListener {
            if (aksi.isNotEmpty() && tvDisplay.text.isNotEmpty()) {
                hitungHasilSementara()
                aksi = "" // Reset operasi setelah hasil ditampilkan
            }
        }
    }

    private fun tambahAngka(angka: String) {
        tvDisplay.setText("${tvDisplay.text}$angka")
    }

    private fun operasi(operasi: String) {
        if (tvDisplay.text.isNotEmpty()) {
            if (aksi.isNotEmpty()) {
                hitungHasilSementara()
            } else {
                isiData()
            }
            aksi = operasi
            tvDisplay.text.clear()
        }
    }

    private fun init() {
        back = findViewById(R.id.back)
        clear = findViewById(R.id.clear)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        delete = findViewById(R.id.delete)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)
        dot = findViewById(R.id.dot)
        percent = findViewById(R.id.percent)
        zero = findViewById(R.id.zero)
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        tvDisplay = findViewById(R.id.tvDisplay)
    }
}
