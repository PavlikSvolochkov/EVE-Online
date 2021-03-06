package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.AccountCharacter;
import ru.tsk.eveonline.logic.Links;
import ru.tsk.eveonline.parsers.CharacterSheetParser;

public class CharacterSheetTask extends AsyncTask<Void, List, List> {

    private static final String CHARACTER_SHEET = Links.CHARACTER_SHEET + APIKey.API_KEY + APIKey.vCODE;

    private List<AccountCharacter> accCharList;

    private CharacterSheetParser charSheetParser;

    public CharacterSheetTask(List<AccountCharacter> accCharList) {
        this.accCharList = accCharList;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List doInBackground(Void... params) {

        charSheetParser = new CharacterSheetParser();

        try {
            for (AccountCharacter accChar : accCharList) {
                URL charURL = new URL(CHARACTER_SHEET + "&characterID=" + accChar.getCharacterID());
                HttpsURLConnection charConn = (HttpsURLConnection) charURL.openConnection();
                charSheetParser.setInputStream(charConn.getInputStream());
                charSheetParser.parseDocument();
            }
        } catch (Exception e) {
            Log.d("CharacterSheetTask", e.getMessage());
        }
        return accCharList;
    }

    @Override
    protected void onPostExecute(List aVoid) {

    }
}
