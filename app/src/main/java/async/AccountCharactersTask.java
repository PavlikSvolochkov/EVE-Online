package async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import logic.AccountCharacter;
import parsers.AccountCharactersParser;

public class AccountCharactersTask extends AsyncTask<Void, List, List> {

  private static final String CHARACTERS = "https://api.eveonline.com/account/characters.xml.aspx" +
          "?keyID=4744217" +
          "&vCODE=7VHnHgo7X02AmGVUK8QSKHJ9xb0KD3zaVQ15zNGARZGiMgguWL3825TAkgAWWuK9";

  private AccountCharactersParser parser;

  public AccountCharactersTask() {

  }

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

  @Override
  protected void onPostExecute(List aVoid) {

  }
}
