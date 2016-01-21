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

  private static final String API_KEY = "?keyID=4744217";
  private static final String vCODE = "&vCODE=7VHnHgo7X02AmGVUK8QSKHJ9xb0KD3zaVQ15zNGARZGiMgguWL3825TAkgAWWuK9";

  private static final String CHARACTER_LIST = "https://api.eveonline.com/account/characters.xml.aspx" + API_KEY + vCODE;
  private static final String CHARACTER = "https://api.eveonline.com/char/CharacterSheet.xml.aspx" + API_KEY + vCODE;

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
        charSheetParser.printData();
      }
    } catch (Exception e) {
      Log.d("debug", e.getMessage());
    }

    return charSheetParser.getCharList();
  }

  @Override
  protected void onPostExecute(List aVoid) {

  }
}
