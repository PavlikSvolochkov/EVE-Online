package async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import logic.APIKey;
import logic.AccountBalance;
import parsers.AccountBalanceParser;

public class AccountBalanceTask extends AsyncTask<Void, AccountBalance, AccountBalance> {

    private final String ACCOUNT_BALANCE = "https://api.eveonline.com/char/AccountBalance.xml.aspx"
            + APIKey.API_KEY + APIKey.vCODE
            + "&characterID=95767126";

    private String characterId;

    private AccountBalance balance;
    private AccountBalanceParser parser;

    public AccountBalanceTask(String charId) {
        this.characterId = charId;
    }

    @Override
    protected AccountBalance doInBackground(Void... v) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(ACCOUNT_BALANCE);
            con = (HttpsURLConnection) url.openConnection();
            parser = new AccountBalanceParser(con.getInputStream());
            parser.parseDocument();
            parser.printData();
            balance = parser.getBalance();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return balance;
    }
}
