package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.SkillQueueItem;
import ru.tsk.eveonline.parsers.SkillQueueParser;

public class SkillQueueTask extends AsyncTask<Void, Void, List<SkillQueueItem>> {

    private static String CHAR_ID = "95767126";

    private static final String SKILL_QUEUE = "https://api.eveonline.com/char/SkillQueue.xml.aspx"
            + APIKey.API_KEY
            + APIKey.vCODE
            + "&characterID=" + CHAR_ID;

    private List<SkillQueueItem> queueItemList;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        queueItemList = new ArrayList<>();
    }

    @Override
    protected List<SkillQueueItem> doInBackground(Void... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(SKILL_QUEUE);
            con = (HttpsURLConnection) url.openConnection();
            SkillQueueParser parser = new SkillQueueParser(con.getInputStream());
            parser.parseDocument();
            parser.printQueue();
            queueItemList = parser.getItems();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return queueItemList;
    }

    @Override
    protected void onPostExecute(List serverStatus) {
        super.onPostExecute(serverStatus);
    }
}
