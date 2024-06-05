package com.example.dicodingsubmission

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvCrews : RecyclerView
    private val list = ArrayList<Crew>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCrews = findViewById(R.id.rv_onepice)
        rvCrews.setHasFixedSize(true)

        list.addAll(getListCrews())
        showRecyclerList()
    }
    private fun getListCrews(): ArrayList<Crew>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDetailPhoto = resources.obtainTypedArray(R.array.data_detail_photo)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataAge = resources.getStringArray(R.array.data_age)
        val dataBounty = resources.getStringArray(R.array.data_bounty)
        val dataVa = resources.getStringArray(R.array.data_va)
        val listCrew = ArrayList<Crew>()
        for (i in dataName.indices) {
            val crew = Crew(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),dataDetailPhoto.getResourceId(i, -1), dataBirthday[i], dataAge[i],dataBounty[i],dataVa[i])
            listCrew.add(crew)
        }
        return listCrew
    }
    private fun showRecyclerList() {
        rvCrews.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCrewAdapter(list)
        rvCrews.adapter = listHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when (item.itemId){
            R.id.about ->{
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}