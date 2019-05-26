package com.example.rina.agora_app.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.EditText;

import com.example.rina.agora_app.R;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static org.web3j.tx.Transfer.GAS_LIMIT;
import static org.web3j.tx.gas.DefaultGasProvider.GAS_PRICE;

public class VoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle arguments = getIntent().getExtras();
        String password = arguments.get("hello1").toString();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(VoteActivity.this);
                View promptsView = li.inflate(R.layout.dialog_send_vote, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(VoteActivity.this);
                alertDialogBuilder.setView(promptsView);

                final EditText editTextTitle = (EditText) promptsView.findViewById(R.id.editTextTitle);
                final EditText editTextMessage = (EditText) promptsView.findViewById(R.id.editTextMessage);

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Отправить",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BigInteger param1= BigInteger.valueOf(6);
                                        BigInteger param2= BigInteger.valueOf(5);
                                        BigInteger param3= BigInteger.valueOf(0);
                                        String title = editTextTitle.getText().toString();
                                        String message = editTextMessage.getText().toString();
                                        Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/668457c0a6114bbd85551b53353ada9a"));

                                        String passwordText = password;
                                        Credentials credentials = null;
//                                        try {
//                                            credentials=WalletUtils.g
//                                           // credentials = WalletUtils.loadCredentials( password, Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS));
//                                        } catch (IOException e) {
//                                            e.printStackTrace();
//                                        } catch (CipherException e) {
//                                            e.printStackTrace();
//                                        }


//                                        Congress congress = null;
//                                        try {
//                                            congress = Congress.deploy(web3j, credentials,
//                                                    GAS_PRICE, GAS_LIMIT,param1,param2,param3).send();
//                                        } catch (Exception e) {
//                                            e.printStackTrace();
//                                        }
//                                        congress.getContractAddress();

                                    }
                                })
                        .setNegativeButton("Закрыть",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }
        });
    }




        
}
