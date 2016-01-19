package async;

import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import logic.ServerStatus;
import parsers.ServerStatusParser;

public class ServerStatusTask extends AsyncTask<Void, Void, Void> {

  private final String SERVER_STATUS = "https://api.eveonline.com/server/ServerStatus.xml.aspx";

  private ServerStatus serverStatus;

  private TextView status;
  private TextView players;

  public ServerStatusTask(TextView status, TextView players) {
    this.status = status;
    this.players = players;
    this.serverStatus = new ServerStatus();
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
  }

  @Override
  protected Void doInBackground(Void... params) {
    URL url;
    HttpsURLConnection con;
    try {
      url = new URL(SERVER_STATUS);
      con = (HttpsURLConnection) url.openConnection();
      ServerStatusParser parser = new ServerStatusParser(con.getInputStream());
      parser.parseDocument();
      parser.printStatus();
      serverStatus = parser.getStatus();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  protected void onPostExecute(Void aVoid) {
    if ("True".equals(serverStatus.getStatus())) {
      status.setTextColor(Color.GREEN);
      status.setText("Online");
      players.append(String.valueOf(serverStatus.getPlayers()));
    } else {
      status.setTextColor(Color.RED);
      status.setText("Offline");
    }
  }
}
