package ru.tsk.eveonline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import async.SkillInTrainingTask;
import logic.SkillInTraining;

public class CharActivity extends AppCompatActivity {

  private SkillInTraining skill;

  private TextView skillTrainTV;
  private TextView skillEndTimeTV;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cpp_like_char_item);

    skillTrainTV = (TextView) findViewById(R.id.skillName);
    skillEndTimeTV = (TextView) findViewById(R.id.timeLeft);

    try {
      skill = new SkillInTrainingTask(skillTrainTV).execute().get();
    } catch (InterruptedException | ExecutionException e) {
      Log.d("debug", e.getMessage());
    }
    skillTrainTV.setText(skill.getTrainingTypeID() + "* " + skill.getTrainingToLevel());


    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      Date date2 = sdf.parse(skill.getTrainingEndTime());

      Calendar stDate = Calendar.getInstance();
      Calendar enDate = Calendar.getInstance();
      enDate.setTime(date2);

      long differenceInMillis = enDate.getTime().getTime() - stDate.getTime().getTime();

      enDate.setTimeInMillis(differenceInMillis);

      Log.d("debug", getClass().getName() + "::\ncurrent: " + stDate + " endtime: " + enDate + "\n"
              + "time difference: " + differenceInMillis);

      String date = DateFormat.format("yyyy-MM-dd hh:mm:ss", enDate).toString();

      final String inputFormat = "yyyy-MM-dd hh:mm:ss";
      final String outputFormat = "HHч mmмин +";

      skillEndTimeTV.setText(TimeStampConverter(inputFormat, date, outputFormat));

      Log.d("debug", getClass().getName() + "::TimeStampConverter: " + TimeStampConverter(inputFormat, date, outputFormat));

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private static String TimeStampConverter(final String inputFormat, String inputTimeStamp, final String outputFormat) throws ParseException {
    return new SimpleDateFormat(outputFormat).format(new SimpleDateFormat(inputFormat).parse(inputTimeStamp));
  }

}
