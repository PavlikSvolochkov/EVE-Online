package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.AccountStatus;
import ru.tsk.eveonline.parsers.AccountStatusParser;


public class AccountStatusTask extends AsyncTask<Void, Void, AccountStatus> {

    private final String ACCOUNT_STATUS = "https://api.eveonline.com/account/AccountStatus.xml.aspx"
            + APIKey.API_KEY + APIKey.vCODE;

    private AccountStatus status;
    private AccountStatusParser statusParser;

    @Override
    protected AccountStatus doInBackground(Void... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(ACCOUNT_STATUS);
            con = (HttpsURLConnection) url.openConnection();
            statusParser = new AccountStatusParser(con.getInputStream());
            statusParser.parseDocument();
            status = statusParser.getAccountStatus();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return status;
    }
}
