package ru.tsk.eveonline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import adapters.SkillQueueAdapter;
import async.SkillQueueTask;
import logic.SkillQueueItem;

public class SkillQueueActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_queue);

        listView = (ListView) findViewById(R.id.skillQueue);
//    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//      @Override
//      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), view.getId() + " " + position, Toast.LENGTH_SHORT).show();
//      }
//    });

        try {
            List<SkillQueueItem> queue = new SkillQueueTask().execute().get();

            for (SkillQueueItem item : queue) {
                Log.d("debug", item.getTypeID());
            }

            SkillQueueAdapter adapter = new SkillQueueAdapter(this, queue);

            listView.setAdapter(adapter);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
