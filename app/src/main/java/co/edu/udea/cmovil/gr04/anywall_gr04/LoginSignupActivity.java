package co.edu.udea.cmovil.gr04.anywall_gr04;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginSignupActivity extends AppCompatActivity {

    Button loginButton;
    Button signupButton;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);
        signupButton = (Button) findViewById(R.id.signup);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                ParseUser.logInInBackground(usernametxt, passwordtxt,
                        new LogInCallback() {

                            @Override

                            public void done(ParseUser user, ParseException e) {

                                if (user != null) {
                                    Intent intent = new Intent(LoginSignupActivity.this, Welcome.class);
                                    startActivity(intent);
                                    finish();

                                } else {

                                    Toast.makeText(getApplicationContext(),
                                            "Este usuario no existe, por favor registrarse", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                if (usernametxt.equals("") && passwordtxt.equals("")) {

                    Toast.makeText(getApplicationContext(),
                            "Por favor complete el formulario de registro",
                            Toast.LENGTH_SHORT).show();
                } else {
                    ParseUser user = new ParseUser();
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);

                    user.signUpInBackground(new SignUpCallback() {

                        @Override
                        public void done(ParseException e) {
                            if (e == null) {

                                Toast.makeText(getApplicationContext(),
                                        "Registro Exitoso!",
                                        Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(getApplicationContext(),
                                        "Error en el Registro", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
                }
            }
        });
    }
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
}


