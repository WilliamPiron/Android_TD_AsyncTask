package m2c_miage.william_piron.td_asynctask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by William on 01/12/2017.
 *
 * Largely based on Remypoc's code on his GitHub repository.
 */

public class CustomAdapter extends ArrayAdapter<Film> {
    CustomAdapter(@NonNull Context context, List<Film> films) {
        super(context, R.layout.listview_films, films);
    }

    private class ViewHolder {
        ImageView image;
        TextView title;
        TextView date;
        TextView production;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Film film = getItem(position);
        View view = convertView;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.listview_films, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.image = view.findViewById(R.id.film_image);
        viewHolder.title = view.findViewById(R.id.film_text_title);
        viewHolder.date = view.findViewById(R.id.film_text_date);
        viewHolder.production = view.findViewById(R.id.film_text_production);

        Format formatter;
        formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm aa", Locale.ENGLISH);
        Date date = film.getDate();
        String s = formatter.format(date);


        viewHolder.title.setText(film.getTitre());
        viewHolder.date.setText(s);
        viewHolder.production.setText(film.getProduction());

        byte[] image = film.getImage();
        if (image != null && image.length>0) {
            //viewHolder.image.setImageBitmap(film.getImage());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(film.getImage());
            Bitmap bitmap = BitmapFactory.decodeStream(byteArrayInputStream);
            viewHolder.image.setImageBitmap(bitmap);
        }
        else {
            viewHolder.image.setImageResource(R.mipmap.ic_launcher);
        }

        /*
        DownloadImageTask downloadImage = new DownloadImageTask();
        try {
            viewHolder.image.setImageBitmap(downloadImage.downloadImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        return view;
    }
}
