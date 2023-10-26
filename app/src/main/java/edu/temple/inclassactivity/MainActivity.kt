package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instance of a view model scoped to THIS activity
        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]



        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()



        //Find the button
        val button = findViewById<Button>(R.id.buttonPresent)

        button.setOnClickListener{
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as ImageDisplayFragment).setImages(imageArray)
        }


        //val imageDisplayFragment = ImageDisplayFragment.newInstance(imageArray)
        // Attach an instance of ImageDisplayFragment using factory method
        //if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView) !is ImageDisplayFragment)
            //supportFragmentManager
                //.beginTransaction()
                //.add(R.id.fragmentContainerView, imageDisplayFragment)
                //.addToBackStack(null)
                //.setReorderingAllowed(true)
                //.commit()



        }


    }
