package nicolas.quillon.iem.gestion_comics.ui.Vue;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import nicolas.quillon.iem.gestion_comics.Presenter.MainPresenter;
import nicolas.quillon.iem.gestion_comics.Presenter.MainView;
import nicolas.quillon.iem.gestion_comics.R;
import nicolas.quillon.iem.gestion_comics.ui.Composition.ErrorModule;
import nicolas.quillon.iem.gestion_comics.ui.Composition.ErrorModuleSnackbarImpl;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity implements MainView {

    //region Variables
    private ListView listViewComic;
    private ListAdapterComics adapterComics;
    private MainPresenter mainPresenter;
    private ErrorModule errorModule;

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
        initializeView();
    }


    //region Methods
    @Override
    public void initializeView(){
        mainPresenter = new MainPresenter(this, this);
        listViewComic = (ListView) findViewById(R.id.listViewComics);

        if(mainPresenter.isEmpty()){
            errorModule =new ErrorModuleSnackbarImpl();
            errorModule.displayError(this, "Impossible de lire les données (fichier JSON corrompu)");
        }else {
            adapterComics = mainPresenter.getListAdapterComics();
            listViewComic.setAdapter(adapterComics);

            listViewComic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent().setClass(MainActivity.this, ComicDetailsActivity.class);
                    intent.putExtra("index", i);
                    startActivity(intent);
                }
            });
        }
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
