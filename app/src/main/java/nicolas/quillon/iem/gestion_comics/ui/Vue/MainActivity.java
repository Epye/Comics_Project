package nicolas.quillon.iem.gestion_comics.ui.Vue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.R;

public class MainActivity extends AppCompatActivity {

    //region Variables
    private ListView listViewComic;
    private Comics listComics;

    private ListAdapterComics adapterComics;

    //endregion

    //region Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        adapterComics = new ListAdapterComics(this, listComics);

        listViewComic.setAdapter(adapterComics);

    }

    //endregion
}
