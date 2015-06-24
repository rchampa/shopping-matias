package com.shopping_promotion_mvc_php;

/**
 * Created by Matias on 11/06/2015.
 */
import java.util.ArrayList;

import com.shopping_promotion_mvc_php.adaptadores.AdaptadorLocales;
import com.shopping_promotion_mvc_php.beans.Local;
import com.shopping_promotion_mvc_php.datos.ShoppingPromotionData;
import com.shopping_promotion_mvc_php.threads.ServiciosLista;
import com.shopping_promotion_mvc_php.threads.ServiciosPromocionLocation;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListaOfertasActivity extends Activity {
    // Para vosotros Ofertas
    private ArrayList<Local> m_locals = null;

    public ArrayList<Local> getM_locals() {
        return m_locals;
    }

    public void setM_locals(ArrayList<Local> m_locals) {
        this.m_locals = m_locals;
    }

    private AdaptadorLocales adaptadorLocales;
    private ServiciosLista serviciosLista = new ServiciosLista();

    private static ListaOfertasActivity listaOfertasActivity = null;

    public static ListaOfertasActivity getInstance() {
        return listaOfertasActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_oferta);
        listaOfertasActivity = this;

        ListView lv = (ListView) findViewById(R.id.listView);

        m_locals = new ArrayList<Local>();
        actualizarListaLocales();
        serviciosLista.miThread("Deportes");

        // Almaceno el ArrayList para que sea accesible
        // desde cualquier punto de la aplicacion
        ShoppingPromotionData.setLstLocales(m_locals);
        // getBaseContext()
        adaptadorLocales = new AdaptadorLocales(this, R.layout.list_item,
                m_locals);
        lv.setAdapter(this.adaptadorLocales);
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Local local = (Local) parent.getItemAtPosition(position);

                // Almaceno el Local seleccionado para que sea accesible
                // desde cualquier punto de la aplicación
                ShoppingPromotionData.setLocalSeleccionado(local);

                Intent myIntent = new Intent(getBaseContext(),
                        MapaActivity.class);
                startActivity(myIntent);

                // Bundle bundle = new Bundle();
                // bundle.putString(myKey, local.getLocalName());
                // myIntent.putExtras(bundle);

            }

        });

    }

    public void actualizarListaLocales() {
        // Debería venir desde el Servidor Web PHP
        try {
            m_locals = new ArrayList<Local>();
            Local o1 = new Local();
            o1.setLocalName("Atletismo");
            o1.setLocalImage(R.drawable.atletismo);
            Local o2 = new Local();
            o2.setLocalName("Baloncesto");
            o2.setLocalImage(R.drawable.baloncesto);
            Local o3 = new Local();
            o3.setLocalName("Balonmano");
            o3.setLocalImage(R.drawable.balonmano);
            Local o4 = new Local();
            o4.setLocalName("Bicicleta");
            o4.setLocalImage(R.drawable.bicicleta);
            Local o5 = new Local();
            o5.setLocalName("Boleisbol");
            o5.setLocalImage(R.drawable.boleisbol);
            Local o6 = new Local();
            o6.setLocalName("Esquis");
            o6.setLocalImage(R.drawable.esquis);
            Local o7 = new Local();
            o6.setLocalName("Futbol");
            o6.setLocalImage(R.drawable.futbol);
            Local o8 = new Local();
            o8.setLocalName("Halterofilia");
            o8.setLocalImage(R.drawable.halterofilia);
            Local o9 = new Local();
            o9.setLocalName("Hipica");
            o9.setLocalImage(R.drawable.hipica);
            Local o10 = new Local();
            o10.setLocalName("Jokey");
            o10.setLocalImage(R.drawable.jokey);
            Local o11 = new Local();
            o11.setLocalName("Judo");
            o11.setLocalImage(R.drawable.judo);
            Local o12 = new Local();
            o12.setLocalName("Remo");
            o12.setLocalImage(R.drawable.remo);
            Local o13 = new Local();
            o13.setLocalName("Tenis");
            o13.setLocalImage(R.drawable.tenis);
            Local o14 = new Local();
            o14.setLocalName("Tiros");
            o14.setLocalImage(R.drawable.tiros);
            Local o15 = new Local();
            o15.setLocalName("Velas");
            o15.setLocalImage(R.drawable.velas);


            Local o16 = new Local();
            o16.setLocalName("Todos");
            o16.setLocalImage(R.drawable.ok);


            // añadimos los sitios al array
            m_locals.add(o1);
            m_locals.add(o8);
            m_locals.add(o2);
            m_locals.add(o9);
            m_locals.add(o3);
            m_locals.add(o10);
            m_locals.add(o4);
            m_locals.add(o11);
            m_locals.add(o5);
            m_locals.add(o12);
            m_locals.add(o6);
            m_locals.add(o13);
            m_locals.add(o7);
            m_locals.add(o14);
            m_locals.add(o15);
            m_locals.add(o16);
        } catch (Exception e) {
            Log.e("BACKGROUND_PROC", e.getMessage());
        }

        if (m_locals != null && m_locals.size() > 0) {
            for (int i = 0; i < m_locals.size(); i++) {
                adaptadorLocales.add(m_locals.get(i));
            }
            adaptadorLocales.notifyDataSetChanged();
        }
    }
}

