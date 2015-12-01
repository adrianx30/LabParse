package co.edu.udea.cmovil.gr04.anywall_gr04;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Adrián on 01/12/2015.
 */
public class ParseApp extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        Parse.initialize(this, "XyBu52xBVKyoK5nkw0EJVbb6NHvtzq2VIx8JWhyl", "BsVktKgKS7u35Y3TLdUTW0SEqn1S30yU0e0KOr4J");

        ParseUser.enableAutomaticUser();
        ParseACL defauAcl = new ParseACL();

        defauAcl.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defauAcl, true);


    }
}
