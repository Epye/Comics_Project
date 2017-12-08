package nicolas.quillon.iem.gestion_comics.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nicolas.quillon.iem.gestion_comics.R;
import nicolas.quillon.iem.gestion_comics.model.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.model.pojo.Comic;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONManager jsonManager=new JSONManager(this.getBaseContext(),"/data/sample-ok.json");
        jsonManager.init();
        TextView tv=(TextView) findViewById(R.id.hello);
        try {
            tv.setText(jsonManager.findById(0).getDescription());
        }
        catch(Exception e){}
    }
}
