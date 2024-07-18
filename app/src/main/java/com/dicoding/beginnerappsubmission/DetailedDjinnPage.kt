package com.dicoding.beginnerappsubmission

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailedDjinnPage : AppCompatActivity() {

    companion object {
        const val KEY_OBJECT = "key_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_djinn_page)

        //4 receiving parcelable data
        val dataDjinn = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_OBJECT, ListofDjinn::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_OBJECT)
        }

            val tvDetailName = findViewById<TextView>(R.id.tv_detailed_name)
            val tvDetailDescription = findViewById<TextView>(R.id.tv_detailed_desc)
            val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detailed_img)
            val tvDetailTagline = findViewById<TextView>(R.id.tv_detailed_tagline)
            val tvDetailLocation = findViewById<TextView>(R.id.tv_detailed_location)

            tvDetailName.text = dataDjinn?.name
            tvDetailDescription.text = dataDjinn?.description
            ivDetailPhoto.setImageResource(dataDjinn!!.photo)
            tvDetailTagline.text = dataDjinn.tagline
            tvDetailLocation.text = dataDjinn.location

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> {
                val shareIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,"Check out this awesome djinn!")
                    type = "text/plain"
                }
                val sendIntent = Intent.createChooser(shareIntent,null)
                startActivity(sendIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}