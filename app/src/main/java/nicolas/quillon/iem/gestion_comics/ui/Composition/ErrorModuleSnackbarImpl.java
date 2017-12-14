package nicolas.quillon.iem.gestion_comics.ui.Composition;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import nicolas.quillon.iem.gestion_comics.R;

/**
 * Created by iem on 14/12/2017.
 */

public class ErrorModuleSnackbarImpl implements ErrorModule {

    @Override
    public void displayError(Context context, String errorMsg) {
        Activity activity=(Activity) context;
        Snackbar.make(activity.findViewById(R.id.mainLayout), errorMsg, Snackbar.LENGTH_LONG).show();
    }
}