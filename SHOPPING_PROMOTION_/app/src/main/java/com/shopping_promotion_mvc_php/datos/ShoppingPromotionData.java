package com.shopping_promotion_mvc_php.datos;

/**
 * Created by Matias on 11/06/2015.
 */
import java.util.ArrayList;

import com.shopping_promotion_mvc_php.beans.Cliente;
import com.shopping_promotion_mvc_php.beans.Local;

public class ShoppingPromotionData {
    private static Cliente cliente;
    private static ArrayList<Local> lstLocales;
    private static Local localSeleccionado;

    public static ArrayList<Local> getLstLocales() {
        return lstLocales;
    }

    public static void setLstLocales(ArrayList<Local> lstLocales) {
        ShoppingPromotionData.lstLocales = lstLocales;
    }

    public static Local getLocalSeleccionado() {
        return localSeleccionado;
    }

    public static void setLocalSeleccionado(Local localSeleccionado) {
        ShoppingPromotionData.localSeleccionado = localSeleccionado;
    }
    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        ShoppingPromotionData.cliente = cliente;
    }

}

