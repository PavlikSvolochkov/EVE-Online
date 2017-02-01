package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.AccountCharacter;
import ru.tsk.eveonline.logic.Links;
import ru.tsk.eveonline.parsers.AccountCharactersParser;

public class AccountCharactersTask extends AsyncTask<Void, List, List> {

    private final String CHARACTERS = Links.CHARACTERS + APIKey.API_KEY + APIKey.vCODE;

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
            con = (HttpsURLConnection) url.openConnection();
            parser = new AccountCharactersParser(con.getInputStream());
            parser.parseDocument();
        } catch (IOException e) {
            Log.d("AccountCharactersTask", e.getMessage());
        }
        return parser.getCharList();
    }
}
