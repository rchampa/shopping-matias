package php.matias.com.shopping.tools;

/**
 * Created by Ricardo on 03/07/15.
 */
public class Cliente {

    private String email;
    private String clave;

    public Cliente(String email, String clave){
        this.email = email;
        this.clave = clave;
    }


    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }
}
