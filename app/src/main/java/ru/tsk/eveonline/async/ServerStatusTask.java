package ru.tsk.eveonline.async;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.Links;
import ru.tsk.eveonline.logic.ServerStatus;
import ru.tsk.eveonline.parsers.ServerStatusParser;

public class ServerStatusTask extends AsyncTask<Void, Void, ServerStatus> {

    private ServerStatus serverStatus;

    private TextView status;
    private TextView players;

    public ServerStatusTask(TextView status, TextView players) {
        this.status = status;
        this.players = players;
        this.serverStatus = new ServerStatus();
    }

    @Override
    protected ServerStatus doInBackground(Void... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(Links.SERVER_STATUS);
            con = (HttpsURLConnection) url.openConnection();
            ServerStatusParser parser = new ServerStatusParser(con.getInputStream());
            parser.parseDocument();
            serverStatus = parser.getStatus();
        } catch (IOException e) {
            Log.d("ServerStatusTask", e.getMessage());
        }
        return serverStatus;
    }

    @Override
    protected void onPostExecute(ServerStatus aVoid) {
        if ("True".equals(serverStatus.getStatus())) {
            status.setTextColor(Color.GREEN);
            status.setText("Online");
            players.setText(String.valueOf(serverStatus.getPlayers()));
        } else {
            status.setTextColor(Color.RED);
            status.setText("Offline");
            players.setText("Offline");
        }
    }
}
