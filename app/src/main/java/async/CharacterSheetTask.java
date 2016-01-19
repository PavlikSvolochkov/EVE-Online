package async;

import android.os.AsyncTask;

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

  private List<AccountCharacter> accountCharList;

  private AccountCharactersParser accountCharParser;
  private CharacterSheetParser characterSheetParser;

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    characterSheetParser = new CharacterSheetParser();
  }

  @Override
  protected List doInBackground(Void... params) {

    try {
      URL url = new URL(CHARACTER_LIST);
      HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
      accountCharParser = new AccountCharactersParser(conn.getInputStream());
      accountCharParser.parseDocument();
      accountCharParser.printData();

      accountCharList = accountCharParser.getCharList();
      for (AccountCharacter accChar : accountCharList) {
        URL charURL = new URL(CHARACTER + "&characterID=" + accChar.getCharacterID());
        HttpsURLConnection charConn = (HttpsURLConnection) charURL.openConnection();
        characterSheetParser.setInputStream(charConn.getInputStream());
        characterSheetParser.parseDocument();
        characterSheetParser.printData();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return characterSheetParser.getCharList();
  }

  @Override
  protected void onPostExecute(List aVoid) {

  }
}
