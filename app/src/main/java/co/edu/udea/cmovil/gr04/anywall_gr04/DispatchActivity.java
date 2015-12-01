package co.edu.udea.cmovil.gr04.anywall_gr04;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.parse.ParseUser;
import com.parse.ParseAnonymousUtils;

public class DispatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {

            Intent intent = new Intent(DispatchActivity.this, LoginSignupActivity.class);
            startActivity(intent);
            finish();

        } else {

            ParseUser currentUser = ParseUser.getCurrentUser();
            //Verifica si hay usuario activo
            if (currentUser != null) {
                //Start an intent for the logged in activity
                Intent intent = new Intent(DispatchActivity.this, Welcome.class);
                startActivity(intent);
                finish();
            } else {
                //Start an intent for the logged out activity
                Intent intent = new Intent(DispatchActivity.this, LoginSignupActivity.class);
                startActivity(intent);
                finish();
            }
        }
        //setContentView(R.layout.activity_dispatch);
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

}
