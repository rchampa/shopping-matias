package com.shopping_promotion_mvc_php.threads;

/**
 * Created by Matias on 11/06/2015.
 */
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import com.shopping_promotion_mvc_php.ListaOfertasActivity;
import com.shopping_promotion_mvc_php.LoginActivity;
import com.shopping_promotion_mvc_php.beans.Cliente;
import com.shopping_promotion_mvc_php.datos.ShoppingPromotionData;
import com.shopping_promotion_mvc_php.tools.Post;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.EditText;
import android.widget.Toast;

public class ServiceLogin{
    private final static Handler manejador = new Handler();
    private static String messageUser;
    private static JSONArray datos;
    private static Thread threadLogin;

    public static void accionLogin(final String user,final String pass){
        Toast.makeText(LoginActivity.getInstance().getBaseContext(),
                "Cargando Datos...", Toast.LENGTH_LONG).show();
        threadLogin = new Thread(){
            public void run(){
                ArrayList<String> parametros = new ArrayList<String>();
                parametros.add("email");
                parametros.add("matias01044@hotmail.com");
                parametros.add("clave");
                parametros.add("mmmm");
                // Llamada a Servidor Web PHP
                try {
                    Post post = new Post();
                    datos = post.getServerData(parametros,"http://www.agendafuneraria.es/loginShopping.php");
                } catch (Exception e) {
                    messageUser = "Error al conectar con el servidor. ";
                }
                manejador.post(proceso);
            }
        };
        threadLogin.start();
    }

    private final static Runnable proceso = new Runnable(){
        public void run() {
            try{
                Toast.makeText(LoginActivity.getInstance().getBaseContext(),
                        "Los datos se han cargado correctamente...", Toast.LENGTH_LONG).show();

                if (datos != null && datos.length() > 0) {
                    JSONObject json_data = datos.getJSONObject(0);
                    int numRegistrados = json_data.getInt("id_usuario");
                    if (numRegistrados > 0) {
                        Cliente cliente = new Cliente();
                        cliente.
                                setIdUsuario(numRegistrados);
                        cliente.
                                setEmail(json_data.getString("email"));
                        cliente.
                                setPass(json_data.getString("clave"));
                        ShoppingPromotionData.setCliente(cliente);
                        Toast.makeText(LoginActivity.getInstance().getBaseContext(),"" +
                                "Usuario correcto. ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.getInstance().getBaseContext(), ListaOfertasActivity.class);
                        // Aquí se le puede pasar información al intent como el id del elemento o la posición con
                        // los métodos putExtra
                        LoginActivity.getInstance().startActivity(intent);
                        LoginActivity.getInstance().finish();
                    }
                } else {
                    Toast.makeText(LoginActivity.getInstance().getBaseContext(),"" +
                            "Usuario incorrecto. ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.getInstance().getBaseContext(),
                            messageUser, Toast.LENGTH_SHORT).show();
                }
            }catch(Exception e){}
        }
    };
}


