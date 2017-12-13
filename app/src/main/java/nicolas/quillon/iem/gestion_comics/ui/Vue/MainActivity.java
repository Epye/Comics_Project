package nicolas.quillon.iem.gestion_comics.ui.Vue;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import nicolas.quillon.iem.gestion_comics.ComicsApplication;
import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.R;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity {

    //region Variables
    private ListView listViewComic;
    private JSONManager jsonManager;

    private ListAdapterComics adapterComics;

    //endregion

    //region Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) { //obligation de demander les permissions
            askForPermission();
        }else{
            init();
        }
    }
    //endregion


    public void init(){
        //Initialisation du fichier JSON
        //jsonManager=new JSONManager("/data/sample-ok.json"); //dossier data à la racine du tel (pas sur SD)

        //ad - appel de la fonction d'initialisation
        initializeInjection();
        initializeView();
    }


    //region Methods
    private void initializeView(){
        listViewComic = (ListView) findViewById(R.id.listViewComics);
        adapterComics = new ListAdapterComics(this, jsonManager.getAll().getResults());
        listViewComic.setAdapter(adapterComics);
    }

    private void initializeInjection(){
        this.jsonManager = ComicsApplication.application().getJsonManager();
    }

    private void askForPermission(){
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else{
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ComicsApplication.application().resetJSONManager(); //car l'injection de dépendance a été créée avant le runtime permission, donc le JSONManager est égal à NULL
                    init();
                } else {
                    new AlertDialog.Builder(this)
                            .setTitle("Permission refusée")
                            .setMessage("Pour visualiser les comics, il est nécessaire d'autoriser l'accès aux données du téléphone.")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }
            }
        }
    }

    //endregion
}
