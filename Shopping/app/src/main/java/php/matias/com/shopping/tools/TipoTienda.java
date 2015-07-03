package php.matias.com.shopping.tools;

/**
 * Created by Ricardo on 03/07/15.
 */
public class TipoTienda {

    private int id;
    private String nombre;

    public TipoTienda(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
