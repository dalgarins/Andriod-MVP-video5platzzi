package libro.test.com.video5platzzi.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import libro.test.com.video5platzzi.R;


/**
 * Created by NoaD on 20/11/2016.
 */

public class DataBindingUtils {

    /**
     * Carga una imagen en view especifico, este metodo es bindeado desde el layout
     * @param view ImageView donde se cargara la imagen
     * @param url String con la direccion de la imagen
     */
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .error(R.mipmap.ic_launcher)
                .fit()
                .into(view);
    }

}
