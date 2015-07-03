package php.matias.com.shopping.servicios;

/**
 * Created by Matias on 11/06/2015.
 */
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.EditText;
import android.widget.Toast;

import php.matias.com.shopping.LoginActivity;
import php.matias.com.shopping.tools.Cliente;
import php.matias.com.shopping.tools.Post;


public class ServicioLogin {

    private final static Handler manejador = new Handler();
    private static String messageUser;
    private static JSONArray datos;
    private static Thread threadLogin;

    public static void accionLogin(final String user,final String pass){
        //Toast.makeText(LoginActivity.getInstance().getBaseContext(), "Cargando Datos...", Toast.LENGTH_LONG).show();

        final LoginActivity activity = LoginActivity.getInstance();

        threadLogin = new Thread(){
            public void run(){
                ArrayList<String> parametros = new ArrayList<String>();
                parametros.add("email");
                parametros.add(user);
                parametros.add("clave");
                parametros.add(pass);
                // Llamada a Servidor Web PHP
                try {
                    Post post = new Post();
                    datos = post.getServerData(parametros,"http://www.agendafuneraria.es/WEBShopping/loginShopping.php");
                    final JSONObject respuesta = datos.getJSONObject(0);

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                int codigo = respuesta.getInt("codigo");
                                String mensaje = respuesta.getString("mensaje");

                                if(codigo == 0){
                                    activity.loginOK(mensaje);
                                }else{
                                    activity.loginError(mensaje);
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });


                } catch (Exception e) {
                    messageUser = "Error al conectar con el servidor. ";
                }
            }
        };
        threadLogin.start();
    }


}


