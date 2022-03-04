package com.fahram.latihanrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahram.latihanrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Distro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvDistro.setHasFixedSize(true)

        list.addAll(listDistros)
        binding.rvDistro.layoutManager = LinearLayoutManager(this)
        val distroAdapter = DistroAdapter(list){
                data -> showSelectedDistro(data)
        }
        binding.rvDistro.adapter = distroAdapter
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

    private fun showSelectedDistro(data: Distro) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("DISTRO", data)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.profile)
        {
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}