package matias.shopping_promotion_mvc_php.com.shopping;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import matias.shopping_promotion_mvc_php.com.shopping.servicios.ServiceLogin;

public class LoginActivity extends Activity {
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnLogin;

    private static LoginActivity loginActivity;
    //permite acceder desde cualquier punto a la ventana "LoginActivity"
    public static LoginActivity getInstance() {
        return loginActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //se almacena en la variable "loginActivity" la referencia de la ventana
        loginActivity = this;

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass = (EditText) findViewById(R.id.edtPass);

        edtEmail.setText("matias@hotmail.com");
        edtPass.setText("0000");
        btnLogin = (Button) findViewById(R.id.btnEnviar);

        btnLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String pass = edtPass.getText().toString();
                ServiceLogin.accionLogin(email, pass);
            }
        });
    }
}
