package async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import logic.APIKey;
import logic.CharacterInfo;
import parsers.CharacterInfoParser;

public class CharacterInfoTask extends AsyncTask<String, Void, CharacterInfo> {

    private static String CHAR_ID = "95767126";

    private String CHARACTER_INFO = "https://api.eveonline.com/eve/CharacterInfo.xml.aspx"
            + APIKey.API_KEY + APIKey.vCODE
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
            parser.printData();
            character = parser.getCharacter();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return character;
    }
}
