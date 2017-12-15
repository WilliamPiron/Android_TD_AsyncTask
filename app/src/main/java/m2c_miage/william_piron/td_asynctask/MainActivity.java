package m2c_miage.william_piron.td_asynctask;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int i = 0;
    private CustomAdapter adapter;
    private static final String url = "https://picsum.photos/200/300/?random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.deleteDatabase("films_database.db");
        SugarContext.init(this);

        // TEMPORAIRE, à remplacer avec AsyncTask
        /*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll()
                .build();
        StrictMode.setThreadPolicy(policy)*/
        // FIN TEMPORAIRE

        //final ArrayList<Film> films = new ArrayList<>();
        final List<Film> films = Film.listAll(Film.class);
        adapter = new CustomAdapter(this, films);

        ListView lv = findViewById(R.id.listview);
        lv.setAdapter(adapter);

        Button add = findViewById(R.id.button_add);
        Button update = findViewById(R.id.button_update);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Film tmp = new Film(null, "Film "+i, new Date(), "Producteur "+i);
                films.add(tmp);
                tmp.save();
                adapter.notifyDataSetChanged();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Film f : films){
                    DownloadImageTask task = new DownloadImageTask(MainActivity.this, adapter, f);
                    task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url);
                }
            }
        });

    }
}
