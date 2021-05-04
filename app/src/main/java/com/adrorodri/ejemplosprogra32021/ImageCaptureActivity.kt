package com.adrorodri.ejemplosprogra32021

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_image_capture.*
import java.io.File

class ImageCaptureActivity : AppCompatActivity() {

    val requestCodeGallery = 123
    val requestCodeCamera = 456

    var fileUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_capture)

        buttonCamera.setOnClickListener {
            val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),"imageCamera" + System.currentTimeMillis() + ".jpg")
            fileUri = FileProvider.getUriForFile(this, "com.adrorodri.ejemplosprogra32021", file)

            val intent = Intent()
            intent.action = MediaStore.ACTION_IMAGE_CAPTURE
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
            startActivityForResult(intent, requestCodeCamera)
        }

        buttonGallery.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen!"), requestCodeGallery)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == requestCodeGallery) {
            imageView.setImageURI(data?.data)
        } else if(requestCode == requestCodeCamera) {
            imageView.setImageURI(fileUri)
        }
    }
}