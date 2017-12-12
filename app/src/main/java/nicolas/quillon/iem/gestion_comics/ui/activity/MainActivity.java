package nicolas.quillon.iem.gestion_comics.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import nicolas.quillon.iem.gestion_comics.R;
import nicolas.quillon.iem.gestion_comics.model.manager.JSONManager;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation du fichier JSON
        JSONManager jsonManager=new JSONManager(this.getBaseContext(),"/data/sample-ok.json"); //dossier data à la racine du tel (pas sur SD)
        jsonManager.init();

        /*Pour accéder aux données du JSON:

        jsonManager.findAll() --> retourne l'objet "Comics" (contenant tous les comics)

        jsonManager.findById(id) --> retourne l'objet "Comic" à la position "id" de "Comics" (+ accès aux getters)

        */
    }
}
