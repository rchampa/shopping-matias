package com.shopping_promotion_mvc_php;

import com.shopping_promotion_mvc_php.threads.ServiceLogin;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnLogin;

    private static LoginActivity loginActivity;

    public static LoginActivity getInstance() {
        return loginActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginActivity = this;

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass = (EditText) findViewById(R.id.edtPass);

        edtEmail.setText("matias01044@hotmail.com");
        edtPass.setText("mmmm");
        btnLogin = (Button) findViewById(R.id.btnEnviar);

        btnLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String pass = edtPass.getText().toString();
                ServiceLogin.accionLogin(email, pass);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

}
