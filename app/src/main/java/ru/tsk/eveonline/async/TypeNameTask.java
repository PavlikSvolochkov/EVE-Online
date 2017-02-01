package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.TypeName;
import ru.tsk.eveonline.parsers.TypeNameParser;

public class TypeNameTask extends AsyncTask<Void, String, String> {

    private final String TYPE_NAME = "https://api.eveonline.com/eve/TypeName.xml.aspx?ids=";
    private String types;
    private TypeName typeName;

    public TypeNameTask() {
        this.typeName = new TypeName();
    }

    public TypeNameTask(String types) { // Comma-separated list of typeIDs to query
        this.types = types;
    }

    @Override
    protected String doInBackground(Void... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(TYPE_NAME + types);
            con = (HttpsURLConnection) url.openConnection();
            TypeNameParser parser = new TypeNameParser(con.getInputStream());
            parser.parseDocument();
            typeName = parser.getTypeName();
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return typeName.getTypeName();
    }
}
