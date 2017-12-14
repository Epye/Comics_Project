package nicolas.quillon.iem.gestion_comics.Presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import nicolas.quillon.iem.gestion_comics.ComicsApplication;
import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.ui.Vue.ListAdapterComics;

/**
 * Created by paulg on 12/12/2017.
 */

public class MainPresenter {
    private JSONManager jsonManager;
    private final Context context;
    private final MainView mainView;
    private Comics listComics;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
        initializeInjection();
        this.listComics = jsonManager.getAll();
    }

    public Comics getComics() {
        return this.listComics;
    }

    public ListAdapterComics getListAdapterComics() {
        return new ListAdapterComics(this.context, jsonManager.getAll().getResults());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initializeInjection() {
        this.jsonManager = ComicsApplication.application().getJsonManager();
    }
}
