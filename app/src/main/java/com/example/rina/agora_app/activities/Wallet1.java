package com.example.rina.agora_app.activities;

import android.os.Environment;
import android.util.Log;

import org.web3j.crypto.Bip39Wallet;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.File;
import java.math.BigDecimal;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Wallet1 {
    public String createWallet(String pass) throws Exception {
        String path = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getPath();
        String fileName = WalletUtils.generateLightNewWalletFile(pass, new File(path));
        return path + fileName;
    }

    public Credentials loadCredentials(String password, String source) throws Exception {
        Credentials credentials = WalletUtils.loadCredentials(
                password,source
        );
        Log.i("Loading credentials", "Credentials loaded");
        return credentials;
    }



    public String sendTransaction(Web3j web3, Credentials credentials,String adress) throws Exception {
        TransactionReceipt transferReceipt = Transfer.sendFunds(web3, credentials,
                adress,  // you can put any address here
                BigDecimal.ONE, Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
                .send();
        return transferReceipt.getTransactionHash();
    }

    public String createBipWallet() throws Exception {
        String path = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getPath();
        Bip39Wallet bip39Wallet = WalletUtils.generateBip39Wallet("password", new File(path));
        String filename = bip39Wallet.getFilename();
        String mnemonic = bip39Wallet.getMnemonic();
        return "Success";
    }

    public void checkWalletExist() {

    }
}
