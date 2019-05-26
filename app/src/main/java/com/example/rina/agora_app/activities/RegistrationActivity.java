package com.example.rina.agora_app.activities;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rina.agora_app.R;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECDSASignature;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class RegistrationActivity extends AppCompatActivity {
Wallet1 wallet=new Wallet1();
    private String source;

    private Button buttonSignUp;
    private EditText editTextName, editTextEmail, editTextPW1,editTextPW2;
    private Button cont;
    private TextView signin;
    private TextView adress;
    private TextView pk;
    private final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Security.addProvider(new
                org.bouncycastle.jce.provider.BouncyCastleProvider());
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        buttonSignUp = (Button) findViewById(R.id.buttonSignUper);
        Toast.makeText(getApplicationContext(),"WORKS",Toast.LENGTH_LONG);
        Log.i(TAG,"LOGI NORM");
        cont=(Button)findViewById(R.id.cont);
        editTextPW1 = (EditText) findViewById(R.id.editTextPW1);
        editTextPW2 = (EditText) findViewById(R.id.editTextPW2);
        pk=(TextView)findViewById(R.id.pk);
        adress=(TextView)findViewById(R.id.adress);


        signin = (TextView)findViewById(R.id.SignIn);


buttonSignUp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"WORKS",Toast.LENGTH_LONG);
        Log.i(TAG,"KNOPKA RABOTAET");
            if(editTextPW1.getText().toString().equals(editTextPW2.getText().toString())){

                Log.i(TAG,"USLOVIE RABOTAET");
                String pw1 = editTextPW2.getText().toString();
                try {
                    String fileName = wallet.createWallet(pw1);
                    source=fileName;
                    Toast.makeText(getApplicationContext(),fileName,Toast.LENGTH_LONG);
                    Log.i(TAG,"Исключения пойманы не были");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
                    Log.i(TAG,"LOOK HERE:"+e.toString());
                }


////if (credentials!=null)Toast.makeText(getApplicationContext(),"f",Toast.LENGTH_LONG);
//            Toast.makeText(getApplicationContext(),source,Toast.LENGTH_LONG);
//            pk.setText(credentials.getEcKeyPair().getPrivateKey().toString(16));
//            adress.setText(credentials.getAddress());
//if (credentials!=null)Toast.makeText(getApplicationContext(),"f",Toast.LENGTH_LONG);

//                      cont.setOnClickListener(new View.OnClickListener() {
//                          @Override
//                          public void onClick(View view) {Intent intent = new Intent(RegistrationActivity.this, SignInActivity.class);
//                              intent.putExtra("hello", String.valueOf(pw1));
//
//                              startActivity(intent);
//                          }
//                      });

            }else{
                Toast.makeText(getApplicationContext(),"Ключевая фраза продублирована неверно",Toast.LENGTH_LONG);
            }




    }

});


//        signin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }







    @Override
    public void onBackPressed() {

    }
    public String createWallet(String pass) throws Exception {
        String path = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getPath();
        String fileName = WalletUtils.generateLightNewWalletFile(pass, new File(path));
        return path + fileName;
    }

    public Credentials loadCredentials1(String password,String source) throws Exception {
        Credentials credentials = WalletUtils.loadCredentials(
                password,source
        );
        Log.i("Loading credentials", "Credentials loaded");
        return credentials;
    }

}