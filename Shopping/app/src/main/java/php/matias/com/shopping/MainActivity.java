package php.matias.com.shopping;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import php.matias.com.shopping.servicios.ServicioListaTiposTiendas;
import php.matias.com.shopping.tools.TipoTienda;


public class MainActivity extends Activity {

    private static MainActivity activity;
    //permite acceder desde cualquier punto a la ventana "activity"
    public static MainActivity getInstance() {
        return activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        ServicioListaTiposTiendas.accionLista();
    }


   public void pintarLista(List<TipoTienda> tipos_tiendas){
       ArrayAdapter<TipoTienda> adapter = new ArrayAdapter<TipoTienda>(this,android.R.layout.simple_list_item_1, tipos_tiendas);
       ListView lista = (ListView)findViewById(R.id.lista_tipos);
       lista.setAdapter(adapter);

   }
}
