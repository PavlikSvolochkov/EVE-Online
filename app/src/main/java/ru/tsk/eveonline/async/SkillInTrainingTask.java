package ru.tsk.eveonline.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.Links;
import ru.tsk.eveonline.logic.SkillInTraining;
import ru.tsk.eveonline.parsers.SkillInTrainingParser;

public class SkillInTrainingTask extends AsyncTask<Void, Void, SkillInTraining> {

    private String CHAR_ID = "95767126";
    private String SKILL_TRAINING = Links.SKILL_TRAINING + APIKey.API_KEY + APIKey.vCODE
            + "&characterID=";

    private SkillInTraining skill;

    public SkillInTrainingTask(String charId) {
        this.skill = new SkillInTraining();
    }

    @Override
    protected SkillInTraining doInBackground(Void... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(SKILL_TRAINING + CHAR_ID);
            con = (HttpsURLConnection) url.openConnection();
            SkillInTrainingParser parser = new SkillInTrainingParser(con.getInputStream());
            parser.parseDocument();
            skill = parser.getSkill();
        } catch (IOException e) {
            Log.d("SkillInTrainingTask", e.getMessage());
        }
        return skill;
    }
}
