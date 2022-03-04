package com.fahram.latihanrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fahram.latihanrecyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val (name, origin, base, logo, desc) =
            intent.getParcelableExtra<Distro>("DISTRO") as Distro
        binding.tvNameDetail.text = name
        binding.tvBaseDetail.text = base
        binding.tvOriginDetail.text = origin
        binding.tvDescDetail.text = desc
        binding.ivLogoDetail.setImageResource(logo)

    }
}