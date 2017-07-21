package com.example.david.ADRS;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by david on 20/07/17.
 */

public class subscribe extends Activity{

    static final int REQUEST_TAKE_PHOTO = 1;
    String username;
    String password;
    String mCurrentPhotoPath;
    ImageView picture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mCurrentPhotoPath=null;

        Intent previousIntent = getIntent();
        Bundle data = previousIntent.getExtras();
        username = (String) data.get("username");
        password = (String) data.get("password");


        setContentView(R.layout.subscribe);
        picture = findViewById(R.id.myPicture);
        final Button takePhoto = (Button) findViewById(R.id.takePhoto);
        Button validate = (Button) findViewById(R.id.validateSubscribe);
        takePhoto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                dispatchTakePictureIntent();

            }
        });

        validate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                 toSearch();
            }
        });


    }

    private void toSearch(){
        Intent toSearch = (Intent) new Intent(subscribe.this,searchActivity.class);
        if(mCurrentPhotoPath!=null){
            toSearch.putExtra("photo_path",mCurrentPhotoPath);

        }else{
            toSearch.putExtra("photo_path","NO_PHOTO");
        }
        toSearch.putExtra("username",username);
        toSearch.putExtra("password",password);
        startActivity(toSearch);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Log.i("ERREUR CREATION PHOTO", "TEST TEST");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);

                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);


            }
        }


    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String imageFileName = "JPEG_profile_picture";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();

        return image;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            pictureManagement.updatePicture(picture,mCurrentPhotoPath);
        }
    }
}

