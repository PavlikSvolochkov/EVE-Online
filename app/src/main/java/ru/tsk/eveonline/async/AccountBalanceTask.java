package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.AccountBalance;
import ru.tsk.eveonline.parsers.AccountBalanceParser;

public class AccountBalanceTask extends AsyncTask<String, AccountBalance, AccountBalance> {

    private final String ACCOUNT_BALANCE = "https://api.eveonline.com/char/AccountBalance.xml.aspx"
            + APIKey.API_KEY + APIKey.vCODE
            + "&characterID=";

    private AccountBalance balance;
    private AccountBalanceParser parser;

    @Override
    protected AccountBalance doInBackground(String... account) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(ACCOUNT_BALANCE + account);
            con = (HttpsURLConnection) url.openConnection();
            parser = new AccountBalanceParser(con.getInputStream());
            parser.parseDocument();
            balance = parser.getBalance();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return balance;
    }
}
