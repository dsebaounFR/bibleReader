package com.example.david.ADRS;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by david on 21/07/17.
 */

public class pictureManagement {
    static protected void updatePicture(ImageView picture, String mCurrentPhotoPath){
        Bitmap myBitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
        picture.setImageBitmap(myBitmap);

    }
}
