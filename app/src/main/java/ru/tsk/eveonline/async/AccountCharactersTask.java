package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.AccountCharacter;
import ru.tsk.eveonline.parsers.AccountCharactersParser;

public class AccountCharactersTask extends AsyncTask<Void, List, List> {

    private static final String CHARACTERS = "https://api.eveonline.com/account/characters.xml.aspx" + APIKey.API_KEY + APIKey.vCODE;

    private AccountCharactersParser parser;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<AccountCharacter> doInBackground(Void... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(CHARACTERS);
            Log.d("debug", getClass().getName() + "::Opening connection...");
            con = (HttpsURLConnection) url.openConnection();
            Log.d("debug", getClass().getName() + "::Connection opened.");
            parser = new AccountCharactersParser(con.getInputStream());
            parser.parseDocument();
            parser.printData();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return parser.getCharList();
    }
}
