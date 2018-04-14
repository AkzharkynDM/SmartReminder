package com.example.android.smartreminder;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.android.smartreminder.database_sql.DatabaseHandler;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class AuthenticationTest {

    private Authenication a;

    @Before
    public void init(){
        a= new Authenication();
    }

    @Test
    public void testAuthenication() throws Exception{
        Context context=null;
        try {
            boolean negativeresult = a.authenication(context, null, null);
            assertEquals(false, negativeresult);

            boolean positiveresult = a.authenication(context, "Smart Reminder user", "password");
            assertEquals(true, positiveresult);
        } catch (NoSuchAlgorithmException e1){

        }
        catch (InvalidKeySpecException e2){

        }
    }
}