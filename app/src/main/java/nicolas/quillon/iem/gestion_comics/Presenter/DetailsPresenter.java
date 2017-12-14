package nicolas.quillon.iem.gestion_comics.Presenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import nicolas.quillon.iem.gestion_comics.ComicsApplication;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comic;

/**
 * Created by iem on 14/12/2017.
 */

public class DetailsPresenter{

    private final Context context;
    private final DetailsView detailsView;
    private final Comic comic;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public DetailsPresenter(Context context, DetailsView detailsView, int index) {
        this.context = context;
        this.detailsView = detailsView;
        this.comic = ComicsApplication.application().getJsonManager().findByIndex(index);
    }

    public String getTitleComic(){
        return comic.getTitle();
    }

    public String getSynopsisComic(){
        return comic.getDescription();
    }

    public String getDateComic(){
        return comic.getDate();
    }

    public String getPriceComic(){
        return Float.toString(comic.getPrice());
    }

    public String getnbPageComic(){
        return Integer.toString(comic.getPageCount());
    }

    public String getDiamondComic(){
        return comic.getDiamondCode();
    }

    public String getCreditComic(){
        return comic.getCreators().toString();
    }

    public String getImageComic(){
        return comic.getImage();
    }

}
