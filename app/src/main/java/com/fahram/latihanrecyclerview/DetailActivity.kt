package com.fahram.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvName: TextView = findViewById(R.id.tv_name_detail)
        val tvDesc: TextView = findViewById(R.id.tv_desc_detail)
        val tvOrigin: TextView = findViewById(R.id.tv_origin_detail)
        val tvBase: TextView = findViewById(R.id.tv_base_detail)
        val ivLogo: ImageView = findViewById(R.id.iv_logo_detail)

        val (name, origin, base, logo, desc) =
            intent.getParcelableExtra<Distro>("DISTRO") as Distro
        tvName.text = name
        tvBase.text = base
        tvOrigin.text = origin
        tvDesc.text = desc
        ivLogo.setImageResource(logo)

    }
}