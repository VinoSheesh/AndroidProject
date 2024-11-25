package com.tugasss.pjbl_vino

import android.content.Intent
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FormulirActivity : AppCompatActivity() {

    lateinit var back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulir)

        init()
        pindah()

        // Deklarasi elemen input
        val cardView: CardView = findViewById(R.id.cardView)
        val etName: EditText = findViewById(R.id.etName)
        val etAddress: EditText = findViewById(R.id.etAddress)
        val etPhone: EditText = findViewById(R.id.etPhone)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val spOptions: Spinner = findViewById(R.id.spOptions)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        // Tambahkan efek blur pada CardView (Glassmorphism)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            cardView.setRenderEffect(
                RenderEffect.createBlurEffect(25f, 25f, Shader.TileMode.CLAMP)
            )
        }

        // Handle tombol Submit
        btnSubmit.setOnClickListener {
            // Ambil nilai input
            val name = etName.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val selectedOption = spOptions.selectedItem.toString()

            // Validasi input
            if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || selectedGenderId == -1) {
                // Tampilkan pesan jika ada data yang kosong
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                // Ambil gender berdasarkan ID
                val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

                // Tampilkan notifikasi berhasil
                Toast.makeText(
                    this,
                    "Data anda telah diinput:\n" +
                            "Nama: $name\n" +
                            "Alamat: $address\n" +
                            "Telepon: $phone\n" +
                            "Jenis Kelamin: $gender\n" +
                            "Kategori: $selectedOption",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun pindah() {
        back.setOnClickListener{
            val intent = Intent(this@FormulirActivity,DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        back = findViewById(R.id.back)
    }
}
