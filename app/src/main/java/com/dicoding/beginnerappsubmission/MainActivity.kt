package com.dicoding.beginnerappsubmission


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvDjinn: RecyclerView
    private val list = java.util.ArrayList<ListofDjinn>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDjinn = findViewById(R.id.rv_djinn)
        rvDjinn.setHasFixedSize(true)

        list.addAll(getListDjinn())
        showRecyclerList()
    }

    private fun getListDjinn(): ArrayList<ListofDjinn> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataTagline = resources.getStringArray(R.array.data_tagline)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listDjinn = ArrayList<ListofDjinn>()
        for (i in dataName.indices) {
            val djinn = ListofDjinn(dataName[i],dataDescription[i],dataTagline[i],dataLocation[i],dataPhoto.getResourceId(i,-1))
            listDjinn.add(djinn)
        }
        return listDjinn
    }

    private fun showRecyclerList(){
        rvDjinn.layoutManager = LinearLayoutManager(this)
        val listDjinnAdapter = DjinnListAdapter(list)
        rvDjinn.adapter =    listDjinnAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntentAbout = Intent(this@MainActivity,AboutPage::class.java )
                startActivity(moveIntentAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}