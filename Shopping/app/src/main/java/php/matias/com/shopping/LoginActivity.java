package php.matias.com.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import php.matias.com.shopping.servicios.ServicioLogin;


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
                ServicioLogin.accionLogin(email, pass);
            }
        });
    }

    public void loginOK(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void loginError(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
