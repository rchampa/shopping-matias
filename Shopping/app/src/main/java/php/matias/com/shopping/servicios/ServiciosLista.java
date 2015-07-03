package php.matias.com.shopping.servicios;

/**
 * Created by Matias on 11/06/2015.
 */

import android.os.Handler;
import android.widget.Toast;


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

/*
import matias.shopping_promotion_mvc_php.com.shopping.R;
import php.matias.com.shopping.tools.Post;

public class ServiciosLista {
    final Handler handle = new Handler();
    private JSONArray datos;

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
*/