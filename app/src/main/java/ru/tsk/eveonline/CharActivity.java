package ru.tsk.eveonline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

import async.SkillInTrainingTask;
import async.TypeNameTask;
import logic.SkillInTraining;

public class CharActivity extends AppCompatActivity {

    private SkillInTraining skill;

    private TextView skillTrainTV;
    private TextView skillEndTimeTV;
    private TextView skillPoints;
    private TextView balanceTV;

    private static String TimeStampConverter(final String inputFormat, String inputTimeStamp, final String outputFormat) throws ParseException {
        return new SimpleDateFormat(outputFormat).format(new SimpleDateFormat(inputFormat).parse(inputTimeStamp));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpp_like_char_item);

        skillTrainTV = (TextView) findViewById(R.id.skillName);
        skillEndTimeTV = (TextView) findViewById(R.id.timeLeft);
        skillPoints = (TextView) findViewById(R.id.skillPoints);
        balanceTV = (TextView) findViewById(R.id.charBalance);

        String charId = getIntent().getExtras().getString("ID");
        String charName = getIntent().getExtras().getString("CHAR_NAME");
        String sp = getIntent().getExtras().getString("SKILL_POINTS");
        String balance = getIntent().getExtras().getString("BALANCE");

        setTitle(charName);

        try {
            skill = new SkillInTrainingTask(charId).execute().get();

            if ("0".equalsIgnoreCase(skill.getSkillInTraining())) {
                skillTrainTV.setText("Освоение навыков приостановлено");
                skillEndTimeTV.setText("");
            } else {
                skillTrainTV.setText(new TypeNameTask(skill.getTrainingTypeID()).execute().get() + "* " + skill.getTrainingToLevel());
                skillPoints.setText(sp);
                balanceTV.setText(balance);
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.d("debug", e.getMessage());
        }

//    try {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//      Date date2 = sdf.parse(skill.getTrainingEndTime());
//
//      Calendar stDate = Calendar.getInstance();
//      Calendar enDate = Calendar.getInstance();
//      enDate.setTime(date2);
//
//      long differenceInMillis = enDate.getTime().getTime() - stDate.getTime().getTime();
//
//      enDate.setTimeInMillis(differenceInMillis);
//
//      Log.d("debug", getClass().getName() + "::\ncurrent: " + stDate + " endtime: " + enDate + "\n"
//              + "time difference: " + differenceInMillis);
//
//      String date = DateFormat.format("yyyy-MM-dd hh:mm:ss", enDate).toString();
//
//      final String inputFormat = "yyyy-MM-dd hh:mm:ss";
//      final String outputFormat = "HHч mmмин";
//
//      skillEndTimeTV.setText(TimeStampConverter(inputFormat, date, outputFormat));
//
//      Log.d("debug", getClass().getName() + "::TimeStampConverter: " + TimeStampConverter(inputFormat, date, outputFormat));
//
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
    }

}
