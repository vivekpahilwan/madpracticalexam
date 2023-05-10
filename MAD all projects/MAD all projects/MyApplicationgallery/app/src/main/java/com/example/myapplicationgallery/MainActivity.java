package com.codingninjas.galleryviewcn

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.Gallery
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
        lateinit var my_imageView: ImageView
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val my_galleryView = findViewById<Gallery>(R.id.my_galleryView)
        my_imageView = findViewById(R.id.my_imageView)
        my_galleryView.setSpacing(2)
        val myGalleryViewAdapter = GalleryImageAdapter(applicationContext)
        my_galleryView.adapter = myGalleryViewAdapter
        my_galleryView.onItemClickListener =
        OnItemClickListener { parent, v, position, id ->
        // to show the selected image in my_imageView
        my_imageView.setImageResource(myGalleryViewAdapter.n_ImageIds[position])
        }
        }
        }