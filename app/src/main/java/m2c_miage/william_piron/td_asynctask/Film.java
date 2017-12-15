package m2c_miage.william_piron.td_asynctask;

import android.graphics.Bitmap;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by William on 01/12/2017.
 */

public class Film extends SugarRecord{
    @Ignore
    private Bitmap image;
    private byte[] imageByte;
    private String titre;
    private Date date;
    private String production;

    public Film(byte[] imageByte, String titre, Date date, String production) {
        this.imageByte = imageByte;
        this.titre = titre;
        this.date = date;
        this.production = production;
    }

    //Necessaire à SugarRecord
    public Film() {
        super();
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public byte[] getImage() {
        return imageByte;
    }

    public void setImage(byte[] imageByte) {
        this.imageByte = imageByte;
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
