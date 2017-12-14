package nicolas.quillon.iem.gestion_comics.Presenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import nicolas.quillon.iem.gestion_comics.ComicsApplication;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.ui.Vue.ListAdapterComics;

/**
 * Created by paulg on 12/12/2017.
 */

public class MainPresenter {
    private final Context context;
    private final MainView mainView;
    private Comics listComics;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public MainPresenter(Context context, MainView mainView) {
        ComicsApplication.application().initJSONManager("/data/sample-ok.json");
        this.context = context;
        this.mainView = mainView;
        this.listComics = ComicsApplication.application().getJsonManager().getAll();
    }

    public Comics getComics() {
        return this.listComics;
    }

    public ListAdapterComics getListAdapterComics() {
        return new ListAdapterComics(this.context, this.listComics.getResults());
    }

    public boolean isEmpty(){
        return this.listComics.getResults().isEmpty();
    }
}
