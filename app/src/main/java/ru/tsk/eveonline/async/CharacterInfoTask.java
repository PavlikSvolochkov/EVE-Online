package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.CharacterInfo;
import ru.tsk.eveonline.logic.Links;
import ru.tsk.eveonline.parsers.CharacterInfoParser;

public class CharacterInfoTask extends AsyncTask<String, Void, CharacterInfo> {

    private String CHAR_ID = "95767126";

    private String CHARACTER_INFO = Links.CHARACTER_INFO + APIKey.API_KEY + APIKey.vCODE
            + "&characterID=";

    private CharacterInfo character;
    private CharacterInfoParser parser;

    public CharacterInfoTask(String charId) {
        this.CHAR_ID = charId;
        this.character = new CharacterInfo();
    }

    @Override
    protected CharacterInfo doInBackground(String... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(CHARACTER_INFO + CHAR_ID);
            con = (HttpsURLConnection) url.openConnection();
            parser = new CharacterInfoParser(con.getInputStream());
            parser.parseDocument();
            character = parser.getCharacter();
        } catch (IOException e) {
            Log.d("CharacterInfoTask", e.getMessage());
        }
        return character;
    }
}
