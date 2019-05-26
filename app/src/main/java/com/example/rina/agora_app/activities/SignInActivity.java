package com.example.rina.agora_app.activities;
import android.accounts.Account;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.rina.agora_app.R;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {



    private EditText editTextAdress, editTextPassword;
    private Button buttonSignIn;




    private TextView sigh_up;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextAdress = (EditText) findViewById(R.id.editTextAdress);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        sigh_up =(TextView)findViewById(R.id.sigh_up);

        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);

        buttonSignIn.setOnClickListener(this);
        System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.wire", "DEBUG");

        Admin web3 = Admin.build(new HttpService("https://rinkeby.infura.io/v3/668457c0a6114bbd85551b53353ada9a"));
        try{
            Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();
            if(!clientVersion.hasError()){
                Toast.makeText(getApplicationContext(),"connection established",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                             PersonalUnlockAccount personalUnlockAccount = null;
                try {

                    personalUnlockAccount = web3.personalUnlockAccount(editTextAdress.
                            getText().toString(), editTextPassword.getText().toString()).sendAsync().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),personalUnlockAccount.getJsonrpc(),Toast.LENGTH_LONG).show();


//                    Log.i(TAG,"Rabotaet");
////                        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
////                        WalletUtils.generateWalletFile(editTextPassword.getText().toString(),ecKeyPair, new File(getCacheDir(),"wallet"), false);
//                    Toast.makeText(getApplicationContext(),"UNLOCKED",Toast.LENGTH_LONG).show();
//
                Intent intent = new Intent(SignInActivity.this, Home_activity.class);
                intent.putExtra("hello", String.valueOf(editTextPassword));
                intent.putExtra("bye", String.valueOf(editTextAdress));
                startActivity(intent);
//                }else{
//                    Log.i(TAG,"ne Rabotaet");
//                   Toast.makeText(getApplicationContext(),"PROBLEM",Toast.LENGTH_LONG).show();
//               }



           }
        });
    }



    @Override
    public void onClick(View view) {
        if (view == sigh_up) {
//            userSignIn();
            startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));

        }
    }


    @Override
    public void onBackPressed() {

    }
}