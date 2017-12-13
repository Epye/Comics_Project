package nicolas.quillon.iem.gestion_comics.ui.Vue;

import android.app.ActionBar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import nicolas.quillon.iem.gestion_comics.ComicsApplication;
import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.R;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ComicDetailsActivity extends AppCompatActivity {

    private TextView textViewTitre ;
    private TextView textViewSynopsis;
    private TextView textViewInfo;
    private TextView textViewDate;
    private TextView textViewPrice;
    private TextView textViewNbPages;
    private TextView textViewDiamondCode;
    private TextView textViewCredit;
    private ImageView imageViewComic;

    private JSONManager jsonManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);

        initializeInjection();
        InitializeView();

    }

    private void InitializeView(){
        textViewTitre = (TextView) findViewById(R.id.textViewTitre);
        textViewSynopsis = (TextView) findViewById(R.id.Synopsis);
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        textViewNbPages = (TextView) findViewById(R.id.textViewNbPage);
        textViewDiamondCode = (TextView) findViewById(R.id.textViewDiamondCode);
        textViewCredit = (TextView) findViewById(R.id.textViewCredit);

        imageViewComic = (ImageView) findViewById(R.id.imageViewComic);
    }


    private void initializeInjection(){
        this.jsonManager = ComicsApplication.application().getJsonManager();
    }
}
