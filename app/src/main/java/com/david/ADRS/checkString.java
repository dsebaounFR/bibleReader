package com.example.david.ADRS;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by david on 21/07/17.
 */

public class checkString {


    static protected boolean checkPassword(String password){
        if(true){
            return true;
        }else{
            return false;

        }
    }

    static protected boolean checkUsername(String username){
        if(username.matches("[a-zA-Z0-9]{2,}")){
            return true;
        }else{
            return false;

        }
    }
}
