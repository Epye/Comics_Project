package nicolas.quillon.iem.gestion_comics.ui.Vue;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.R;

public class MainActivity extends AppCompatActivity {

    //region Variables
    private ListView listViewComic;
    private Comics listComics;
    private JSONManager jsonManager;

    private ListAdapterComics adapterComics;

    //endregion

    //region Override
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askForPermission();

        //------------------------------------------------------------------>>>>>>>>>>>>>>> Desactiver JSON si permission refusée
        //Initialisation du fichier JSON
        jsonManager=new JSONManager("/data/sample-ok.json"); //dossier data à la racine du tel (pas sur SD)

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
        listComics = new Comics();

        adapterComics = new ListAdapterComics(this, jsonManager.getAll().getResults());

        listViewComic.setAdapter(adapterComics);

    }

    private void askForPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "L'accès aux données est nécessaire pour visualiser les comics", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // La permission est garantie
                } else {
                    Toast.makeText(this, "Les comics ne pourront pas être chargés", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    //endregion
}
