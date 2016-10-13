package async;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import logic.AccountCharacter;
import parsers.AccountCharactersParser;
import parsers.CharacterSheetParser;

public class CharacterSheetTask extends AsyncTask<Void, List, List> {

    private static String KEY_ID = "5040468";
    private static String vCODE = "Dw46k2jB9N5MHe15BcTdpBumTKFpBauFWP2eoWk3hRoPUn4zLKPmJuaMmbIfEoro";

    private static final String CHARACTER_LIST = "https://api.eveonline.com/account/characters.xml.aspx" + KEY_ID + vCODE;
    private static final String CHARACTER = "https://api.eveonline.com/char/CharacterSheet.xml.aspx"
            + "?keyID=" + KEY_ID
            + "&vCODE=" + vCODE;

    private List<AccountCharacter> accCharList;

    private AccountCharactersParser accCharParser;
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
                URL charURL = new URL(CHARACTER + "&characterID=" + accChar.getCharacterID());
                HttpsURLConnection charConn = (HttpsURLConnection) charURL.openConnection();
                charSheetParser.setInputStream(charConn.getInputStream());
                charSheetParser.parseDocument();
            }
        } catch (Exception e) {
            Log.e("debug", e.getMessage());
        }

        return accCharList;
    }

    @Override
    protected void onPostExecute(List aVoid) {

    }
}
