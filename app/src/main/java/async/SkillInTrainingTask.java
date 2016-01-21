package async;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import logic.SkillInTraining;
import parsers.SkillInTrainingParser;

public class SkillInTrainingTask extends AsyncTask<Void, Void, SkillInTraining> {

  private String SKILL_TRAINING = "https://api.eveonline.com/char/SkillInTraining.xml.aspx";
  private String API_KEY = "?keyID=4744217";
  private String vCODE = "&vCODE=7VHnHgo7X02AmGVUK8QSKHJ9xb0KD3zaVQ15zNGARZGiMgguWL3825TAkgAWWuK9";
  private String CHAR_ID = "&characterID=95767126";

  private TextView skillTV;
  private SkillInTraining skill;

  public SkillInTrainingTask(TextView skillTV) {
//    this.skillTV = skillTV;
    this.skill = new SkillInTraining();
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
  }

  @Override
  protected SkillInTraining doInBackground(Void... params) {
    URL url;
    HttpsURLConnection con;
    try {
      url = new URL(SKILL_TRAINING + API_KEY + vCODE + CHAR_ID);
      Log.d("debug", getClass().getName() + "::Open connection for: " + url.toString());
      con = (HttpsURLConnection) url.openConnection();
      SkillInTrainingParser parser = new SkillInTrainingParser(con.getInputStream());
      parser.parseDocument();
      skill = parser.getSkill();
      Log.d("debug", getClass().getName() + "::Skill: " + skill.toString());
    } catch (IOException e) {
      Log.d("debug", e.getMessage());
    }
    return skill;
  }

  @Override
  protected void onPostExecute(SkillInTraining skillInTraining) {
    super.onPostExecute(skillInTraining);
//    skillTV.setText(skill.getTrainingTypeID());
  }
}
