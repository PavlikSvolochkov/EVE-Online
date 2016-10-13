package async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import logic.SkillQueueItem;
import parsers.SkillQueueParser;

public class SkillQueueTask extends AsyncTask<Void, Void, List<SkillQueueItem>> {

    private static String KEY_ID = "5040468";
    private static String vCODE = "Dw46k2jB9N5MHe15BcTdpBumTKFpBauFWP2eoWk3hRoPUn4zLKPmJuaMmbIfEoro";
    private static String CHAR_ID = "95767126";

    private static final String SKILL_QUEUE = "https://api.eveonline.com/char/SkillQueue.xml.aspx?"
            + "keyID=" + KEY_ID
            + "&vCODE=" + vCODE
            + "&characterID=" + CHAR_ID;

    private List<SkillQueueItem> items;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        items = new ArrayList<>();
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
            items = parser.getItems();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return items;
    }

    @Override
    protected void onPostExecute(List serverStatus) {
        super.onPostExecute(serverStatus);
    }
}
