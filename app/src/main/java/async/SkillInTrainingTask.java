package async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import logic.APIKey;
import logic.SkillInTraining;
import parsers.SkillInTrainingParser;

public class SkillInTrainingTask extends AsyncTask<Void, Void, SkillInTraining> {

    private String SKILL_TRAINING = "https://api.eveonline.com/char/SkillInTraining.xml.aspx"
            + APIKey.API_KEY + APIKey.vCODE
            + "&characterID=95767126";

    private SkillInTraining skill;

    public SkillInTrainingTask(String charId) {
        this.skill = new SkillInTraining();
    }

    @Override
    protected SkillInTraining doInBackground(Void... params) {
        URL url;
        HttpsURLConnection con;
        try {
            url = new URL(SKILL_TRAINING);
            Log.d("debug", getClass().getName() + "::Open connection for: " + url.toString());
            con = (HttpsURLConnection) url.openConnection();
            SkillInTrainingParser parser = new SkillInTrainingParser(con.getInputStream());
            parser.parseDocument();
            skill = parser.getSkill();
            Log.d("debug", getClass().getName() + "::Skill: " + skill.toString());
        } catch (IOException e) {
            Log.e("debug", e.getMessage());
        }
        return skill;
    }
}
