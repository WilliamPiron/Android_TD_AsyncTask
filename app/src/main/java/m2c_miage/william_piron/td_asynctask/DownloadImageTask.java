package m2c_miage.william_piron.td_asynctask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Adapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;


/**
 * Created by William on 01/12/2017.
 */


class DownloadImageTask extends AsyncTask<String, Void, Void>{

    private WeakReference<Activity> activity;
    private WeakReference<CustomAdapter> adapter;
    private WeakReference<Film> film;

    /*
    private static String IMAGE_URL = "https://picsum.photos/200/300/?random";

    public Bitmap downloadImage() throws IOException {
        URL url = new URL(IMAGE_URL);
        return BitmapFactory.decodeStream(url.openConnection().getInputStream());
    }
    */

    public DownloadImageTask(Activity activity, CustomAdapter adapter, Film film) {
        this.activity = new WeakReference<Activity>(activity);
        this.adapter = new WeakReference<CustomAdapter>(adapter);
        this.film = new WeakReference<Film>(film);
    }

    @Override
    protected Void doInBackground(String... urls) {
        URL url = null;
        try {
            url = new URL(urls[0]);
            //return BitmapFactory.decodeStream(url.openConnection().getInputStream());
            Bitmap tmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            ByteArrayOutputStream res = new ByteArrayOutputStream();
            tmp.compress(Bitmap.CompressFormat.PNG, 100, res);
            Film f = film.get();
            if (f != null){
                f.setImage(res.toByteArray());
                f.save();
            }
            return null;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void aVoid) {
        //Activity act = activity.get();
        CustomAdapter ada = adapter.get();
        //Film fil = film.get();
        /*
        if (act != null && ada != null && fil != null){
            //fil.setImage(image);
            ada.notifyDataSetChanged();
        }*/
        if (ada != null){
            //fil.setImage(image);
            ada.notifyDataSetChanged();
        }
    }
}

