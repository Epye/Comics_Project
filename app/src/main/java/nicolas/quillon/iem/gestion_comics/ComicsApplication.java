package nicolas.quillon.iem.gestion_comics;

import android.app.Application;
import android.os.Build;
import android.support.annotation.RequiresApi;

import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.Presenter.MainPresenter;

/**
 * Created by Johan on 12/12/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ComicsApplication extends Application {
    // Variable privée qui retiendra l'instance de l'objet application
    private static ComicsApplication application;

    // getter public pour récupérer l'instance statique de l'objet application
    public static ComicsApplication application() {
        return application;
    }

    // Variable privée qui retiendra la seule instance du manager
    private JSONManager jsonManager;
    private MainPresenter mainPresenter;

    // getter public pour récupérer l'instance unique de l'objet manager
    public JSONManager getJsonManager() {
        return jsonManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        try{
            this.jsonManager = new JSONManager("/data/sample-ok.json");
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void resetJSONManager(){
        this.jsonManager = new JSONManager("/data/sample-ok.json");
    }
}
