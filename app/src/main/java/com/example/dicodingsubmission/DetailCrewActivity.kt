package com.example.dicodingsubmission

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailCrewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_crew)

    val dataCrew = if (Build.VERSION.SDK_INT >= 33) {
        intent.getParcelableExtra("key_crew", Crew::class.java)
    } else {
        @Suppress("DEPRECATION")
        intent.getParcelableExtra("key_crew")
    }

        val tvDetailName =findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val tvDetailImage = findViewById<ImageView>(R.id.imagebg)
        val tvDetailAge = findViewById<TextView>(R.id.tv_detail_age)
        val tvDetailBirthday = findViewById<TextView>(R.id.tv_detail_birthday)
        val tvDetailBounty = findViewById<TextView>(R.id.tv_detail_bounty)
        val tvDetailVa = findViewById<TextView>(R.id.tv_detail_va)

        if (dataCrew != null) {
            tvDetailName.text = dataCrew.name
            tvDetailDescription.text = dataCrew.description
            tvDetailImage.setImageResource(dataCrew.photoDetail)
            tvDetailAge.text = dataCrew.age
            tvDetailBirthday.text = dataCrew.birthday
            tvDetailBounty.text = dataCrew.bounty
            tvDetailVa.text = dataCrew.va
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}