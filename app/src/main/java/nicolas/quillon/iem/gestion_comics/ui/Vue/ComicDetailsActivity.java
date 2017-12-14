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
import nicolas.quillon.iem.gestion_comics.Presenter.DetailsPresenter;
import nicolas.quillon.iem.gestion_comics.Presenter.DetailsView;
import nicolas.quillon.iem.gestion_comics.R;
import com.squareup.picasso.Picasso;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ComicDetailsActivity extends AppCompatActivity implements DetailsView{

    private TextView textViewTitre ;
    private TextView textViewSynopsis;
    private TextView textViewInfo;
    private TextView textViewDate;
    private TextView textViewPrice;
    private TextView textViewNbPages;
    private TextView textViewDiamondCode;
    private TextView textViewCredit;
    private ImageView imageViewComic;

    private DetailsPresenter detailsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);

        initializeView();
    }

    @Override
    public void initializeView(){
        setTitle(R.string.title_details);

        detailsPresenter = new DetailsPresenter(this, this, (int) getIntent().getExtras().get("index"));

        textViewTitre = (TextView) findViewById(R.id.textViewTitre);
        textViewTitre.setText(detailsPresenter.getTitleComic());

        textViewSynopsis = (TextView) findViewById(R.id.Synopsis);
        textViewSynopsis.setText(detailsPresenter.getSynopsisComic());

        textViewInfo = (TextView) findViewById(R.id.textViewInfo);

        textViewDate = (TextView) findViewById(R.id.textViewDate);
        String date = detailsPresenter.getDateComic().split("T")[0];
        String dateresult = date.split("-")[2] + "-" + date.split("-")[1] + "-" + date.split("-")[0];
        textViewDate.setText(dateresult);

        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        textViewPrice.setText(detailsPresenter.getPriceComic());

        textViewNbPages = (TextView) findViewById(R.id.textViewNbPage);
        textViewNbPages.setText(detailsPresenter.getnbPageComic());

        textViewDiamondCode = (TextView) findViewById(R.id.textViewDiamondCode);
        textViewDiamondCode.setText(detailsPresenter.getDiamondComic());

        textViewCredit = (TextView) findViewById(R.id.textViewCredit);
        textViewCredit.setText(detailsPresenter.getCreditComic());

        imageViewComic = (ImageView) findViewById(R.id.imageViewComic);
        Picasso.with(this).load(detailsPresenter.getImageComic()).resize(100, 150).into(imageViewComic);


    }
}
