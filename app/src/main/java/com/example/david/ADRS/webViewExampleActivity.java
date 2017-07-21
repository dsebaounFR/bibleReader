package com.example.david.ADRS;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by david on 15/07/17.
 */

public class searchActivity extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_search);
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String profilePictureURL = getIntent().getStringExtra("photo_path");
        TextView usrname = (TextView) findViewById(R.id.username);
        TextView pasword = (TextView) findViewById(R.id.password);
        usrname.setText(username);
        pasword.setText(password);
        ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);
        pictureManagement.updatePicture(profilePicture,profilePictureURL);
        TextView paragraphe = (TextView) findViewById(R.id.testText);
        /*
        ListView listView=(ListView) findViewById(R.id.listview);

        String[][] repertoire = new String[][]{

                {"Bill Gates", "06 06 06 06 06","hello"},

                {"Niels Bohr", "05 05 05 05 05","test"},

                {"Alexandre III de Macédoine", "04 04 04 04 04","does it work"}};

        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> element;
        //Pour chaque personne dans notre répertoire…
        for(int i = 0 ; i < repertoire.length ; i++) {
            //… on crée un élément pour la liste…
            element = new HashMap<String, String>();
      /*
       * … on déclare que la clé est « text1 » (j'ai choisi ce mot au hasard, sans sens technique particulier)
       * pour le nom de la personne (première dimension du tableau de valeurs)…

            element.put("text1", repertoire[i][0]);
      /*
       * … on déclare que la clé est « text2 »
       * pour le numéro de cette personne (seconde dimension du tableau de valeurs)

            element.put("text2", repertoire[i][1]);
            element.put("text3", repertoire[i][2]);

            liste.add(element);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                //Valeurs à insérer
                liste,
      /*
       * Layout de chaque élément (là, il s'agit d'un layout par défaut
       * pour avoir deux textes l'un au-dessus de l'autre, c'est pourquoi on
       * n'affiche que le nom et le numéro d'une personne)

                android.R.layout.simple_list_item_2,
      /*
       * Les clés des informations à afficher pour chaque élément :
       *  - la valeur associée à la clé « text1 » sera la première information
       *  - la valeur associée à la clé « text2 » sera la seconde information

                new String[] {"text1", "text2","text3"},
      /*
       * Enfin, les layouts à appliquer à chaque widget de notre élément
       * (ce sont des layouts fournis par défaut) :
       *  - la première information appliquera le layout « android.R.id.text1 »
       *  - la seconde information appliquera le layout « android.R.id.text2 »

                new int[] {android.R.id.text1, android.R.id.text2 });
        //Pour finir, on donne à la ListView le SimpleAdapter
        listView.setAdapter(adapter);
        */


    }



}

