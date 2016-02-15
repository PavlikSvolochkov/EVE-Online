package async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import logic.ServerStatus;
import parsers.SkillQueueParser;

public class SkillQueueTask extends AsyncTask<Void, Void, ServerStatus> {

  private static final String API_KEY = "?keyID=4744217";
  private static final String vCODE = "&vCODE=7VHnHgo7X02AmGVUK8QSKHJ9xb0KD3zaVQ15zNGARZGiMgguWL3825TAkgAWWuK9";
  public static final String CHAR_ID = "&characterID=95767126";

  private String SKILL_QUEUE = "https://api.eveonline.com/char/SkillQueue.xml.aspx";

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
  }

  @Override
  protected ServerStatus doInBackground(Void... params) {
    URL url;
    HttpsURLConnection con;
    try {
      url = new URL(SKILL_QUEUE + API_KEY + vCODE + CHAR_ID);
      con = (HttpsURLConnection) url.openConnection();
      SkillQueueParser parser = new SkillQueueParser(con.getInputStream());
      parser.parseDocument();
      parser.printQueue();
    } catch (IOException e) {
      Log.e("debug", e.getMessage());
    }
    return null;
  }

  @Override
  protected void onPostExecute(ServerStatus serverStatus) {
    super.onPostExecute(serverStatus);
  }
}
