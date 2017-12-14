package nicolas.quillon.iem.gestion_comics.ui.Composition;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by iem on 14/12/2017.
 */

public class ErrorModuleToastImpl implements ErrorModule {

    @Override
    public void displayError(Context context, String errorMsg) {
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show();
    }
}
