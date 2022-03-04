package com.fahram.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDistro: RecyclerView
    private val list = ArrayList<Distro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvDistro = findViewById(R.id.rv_distro)
        rvDistro.setHasFixedSize(true)

        list.addAll(listDistros)
        rvDistro.layoutManager = LinearLayoutManager(this)
        val distroAdapter = DistroAdapter(list)
        rvDistro.adapter = distroAdapter
    }
    private val listDistros: ArrayList<Distro>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataOrigin = resources.getStringArray(R.array.data_origin)
            val dataBase = resources.getStringArray(R.array.data_base)
            val dataLogo = resources.obtainTypedArray(R.array.data_logo)
            val dataDesc = resources.getStringArray(R.array.data_desc)
            val listDistro= ArrayList<Distro>()
            for (i in dataName.indices) {
                val distro = Distro(
                    dataName[i],
                    dataOrigin[i],
                    dataBase[i],
                    dataLogo.getResourceId(i, -1),
                    dataDesc[i]
                )
                listDistro.add(distro)
            }
            return listDistro
        }
}