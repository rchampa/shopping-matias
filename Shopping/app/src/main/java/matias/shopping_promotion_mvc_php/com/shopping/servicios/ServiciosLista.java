package matias.shopping_promotion_mvc_php.com.shopping.servicios;

/**
 * Created by Matias on 11/06/2015.
 */

import android.os.Handler;
import android.widget.Toast;

import com.shopping_promotion_mvc_php.ListaOfertasActivity;
import com.shopping_promotion_mvc_php.MapaActivity;
import com.shopping_promotion_mvc_php.R;
import com.shopping_promotion_mvc_php.beans.Local;
import com.shopping_promotion_mvc_php.tools.Post;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.shopping_promotion_mvc_php.ListaOfertasActivity;
import com.shopping_promotion_mvc_php.MapaActivity;
import com.shopping_promotion_mvc_php.R;
import com.shopping_promotion_mvc_php.beans.Local;
import com.shopping_promotion_mvc_php.tools.Post;
import com.shopping_promotion_mvc_php.tools.Utils;

import matias.shopping_promotion_mvc_php.com.shopping.R;

public class ServiciosLista {
    final Handler handle = new Handler();
    private JSONArray datos;

    // private OverlayItem getOverlayItem( String nombre, String descripcion,
    // String latitud, String longitud, Drawable drawable){
    // String coordinates[] = {latitud,longitud};
    // double lat = Double.parseDouble(coordinates[0]);
    // double lng = Double.parseDouble(coordinates[1]);
    // GeoPoint point = new GeoPoint((int) (lng * 1E6),(int) (lat * 1E6));
    // OverlayItem overlayitem = new OverlayItem(point, nombre, descripcion);
    // overlayitem.setMarker(MapaActivity.getInstance().getItemizedoverlay().boundCenterBottomAux(drawable));
    // return overlayitem;
    // }

    public void miThread(final String tipo) {
        Thread t = new Thread() {
            public void run() {
                Post post = null;
                try {
                    ArrayList<String> parametros = new ArrayList<String>();
                    parametros.add("tipo");
                    parametros.add("Deportes");
                    // Llamada a Servidor Web PHP
                    post = new Post();
                    datos = post
                            .getServerData(parametros,
                                    "http://www.agendafuneraria.es/ofertasShopping.php");
                } catch (Exception e) {
                    Toast.makeText(MapaActivity.getInstance().getBaseContext(),
                            e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                handle.post(proceso);
            }
        };
        t.start();
    }

    final Runnable proceso = new Runnable() {
        public void run() {
            try {
                // ImageView imagenView = new
                // ImageView(MapaActivity.getInstance().getBaseContext());
                if (datos != null && datos.length() > 0) {
                    for (int i = 0; i < datos.length(); i++) {
                        JSONObject json_data = datos.getJSONObject(i);
                        // int idSitio = json_data.getInt("ID");
                        String nombre = json_data.getString("NOMBRE");
						/*
						 * String descripcion =
						 * json_data.getString("DESCRIPCION"); String longitud =
						 * json_data.getString("LONGITUD"); String latitud =
						 * json_data.getString("LATITUD"); String img =
						 * json_data.getString("IMAGEN"); String urlImagen =
						 * "http://192.168.1.3/Imagenes/Imagenes/" + img; Bitmap
						 * loadedImage = Utils.downloadFile(urlImagen);
						 * imagenView.setImageBitmap(loadedImage); OverlayItem
						 * overlay =
						 * getOverlayItem(nombre,descripcion,latitud,longitud
						 * ,imagenView.getDrawable());
						 * MapaActivity.getInstance()
						 * .anadePuntoAlMapaConItemizedOverlayEImagen(overlay );
						 */
                        Local o1 = new Local();
                        o1.setLocalName(nombre);
                        o1.setLocalImage(R.drawable.cesta_compra);
                        ListaOfertasActivity.getInstance().getM_locals()
                                .add(o1);
                    }
                }
                ListaOfertasActivity.getInstance().actualizarListaLocales();
            } catch (Exception e) {
            }
        }
    };
}
