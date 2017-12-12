package nicolas.quillon.iem.gestion_comics.ui.Vue;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.R;

public class MainActivity extends AppCompatActivity {

    //region Variables
    private ListView listViewComic;
    private JSONManager jsonManager;

    private ListAdapterComics adapterComics;

    //endregion

    //region Override
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation du fichier JSON
        jsonManager=new JSONManager("/data/sample-ok.json"); //dossier data à la racine du tel (pas sur SD)
        jsonManager.init();

        //ad - appel de la fonction d'initialisation
        InitializeView();
    }

    //endregion


    //region Methods
    /***
     * Initialise les éléments de la vue
     * @author Adeline Dumas Création 08/12/2017
     */
    private void InitializeView(){
        listViewComic = (ListView) findViewById(R.id.listViewComics);

        adapterComics = new ListAdapterComics(this, jsonManager.getAll().getResults());

        listViewComic.setAdapter(adapterComics);

    }

    //endregion
}
