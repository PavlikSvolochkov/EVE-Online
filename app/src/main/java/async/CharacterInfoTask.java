package async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import logic.CharacterInfo;
import parsers.CharacterInfoParser;

public class CharacterInfoTask extends AsyncTask<String, Void, CharacterInfo> {

  private static final String API_KEY = "?keyID=4744217";
  private static final String vCODE = "&vCODE=7VHnHgo7X02AmGVUK8QSKHJ9xb0KD3zaVQ15zNGARZGiMgguWL3825TAkgAWWuK9";

  private String CHARACTER_INFO = "https://api.eveonline.com/eve/CharacterInfo.xml.aspx";
  private String CHAR_ID = "&characterID=";

  private CharacterInfo character;
  private CharacterInfoParser parser;

  public CharacterInfoTask(String charId) {
    this.CHAR_ID += charId;
    this.character = new CharacterInfo();
  }

  @Override
  protected void onPreExecute() {
  }

  @Override
  protected CharacterInfo doInBackground(String... params) {
    URL url;
    HttpsURLConnection con;
    try {
      url = new URL(CHARACTER_INFO + API_KEY + vCODE + CHAR_ID);
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

  @Override
  protected void onPostExecute(CharacterInfo aVoid) {

  }
}
