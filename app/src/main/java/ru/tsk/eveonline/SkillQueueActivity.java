package ru.tsk.eveonline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import async.SkillQueueTask;

public class SkillQueueActivity extends AppCompatActivity {

  private ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_skill_queue);

    listView = (ListView) findViewById(R.id.skillQueue);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), view.getId() + " " + position, Toast.LENGTH_SHORT).show();
      }
    });

    new SkillQueueTask().execute();
  }
}
