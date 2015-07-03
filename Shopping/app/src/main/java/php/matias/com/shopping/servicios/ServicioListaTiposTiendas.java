package php.matias.com.shopping.servicios;

/**
 * Created by Matias on 11/06/2015.
 */

import android.os.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import php.matias.com.shopping.LoginActivity;
import php.matias.com.shopping.MainActivity;
import php.matias.com.shopping.tools.Post;
import php.matias.com.shopping.tools.TipoTienda;


public class ServicioListaTiposTiendas {

    private final static Handler manejador = new Handler();
    private static String messageUser;
    private static JSONArray datos;
    private static Thread threadLogin;

    public static void accionLista(){

        final MainActivity activity = MainActivity.getInstance();

        threadLogin = new Thread(){
            public void run(){
                ArrayList<String> parametros = new ArrayList<String>();
                // Llamada a Servidor Web PHP
                try {
                    Post post = new Post();
                    datos = post.getServerData(parametros,"http://www.agendafuneraria.es/WEBShopping/lista_tipo_tiendas.php");

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            List<TipoTienda> tipos = new ArrayList<TipoTienda>();
                            try {
                                for (int i = 0; i < datos.length(); i++) {
                                    JSONObject tipo = datos.getJSONObject(i);
                                    int id = tipo.getInt("id_tipo");
                                    String nombre = tipo.getString("nombre");
                                    TipoTienda nuevo_tipo_tienda = new TipoTienda(id, nombre);
                                    tipos.add(nuevo_tipo_tienda);
                                }

                                activity.pintarLista(tipos);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                    messageUser = "Error al conectar con el servidor. ";
                }
            }
        };
        threadLogin.start();
    }


}


