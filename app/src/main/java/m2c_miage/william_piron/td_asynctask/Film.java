package m2c_miage.william_piron.td_asynctask;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by William on 01/12/2017.
 */

public class Film {
    private Bitmap image;
    private String titre;
    private Date date;
    private String production;

    public Film(Bitmap image, String titre, Date date, String production) {
        this.image = image;
        this.titre = titre;
        this.date = date;
        this.production = production;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
