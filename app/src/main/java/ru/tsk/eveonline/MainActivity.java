package ru.tsk.eveonline;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ru.tsk.eveonline.adapters.AccountCharactersAdapter;
import ru.tsk.eveonline.async.AccountCharactersTask;
import ru.tsk.eveonline.async.CharacterIconTask;
import ru.tsk.eveonline.async.CharacterInfoTask;
import ru.tsk.eveonline.async.CharacterSheetTask;
import ru.tsk.eveonline.async.ServerStatusTask;
import ru.tsk.eveonline.logic.AccountCharacter;
import ru.tsk.eveonline.logic.CharacterInfo;
import ru.tsk.eveonline.logic.ServerStatus;

public class MainActivity extends AppCompatActivity {

    // Access Mask: 1073741823

    private ServerStatus serverStatus;
    private List<AccountCharacter> accCharList;
    private List<CharacterInfo> charList;
    private List<Bitmap> charIcons;

    private TextView status;
    private TextView players;
    private Button openSkillBtn;
    private ListView listView;

    private AccountCharactersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        charIcons = new ArrayList<>();
        accCharList = new ArrayList<>();

        status = (TextView) findViewById(R.id.serverStatus);
        players = (TextView) findViewById(R.id.onlinePlayers);

        openSkillBtn = (Button) findViewById(R.id.openSkillsBtn);
        openSkillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SkillQueueActivity.class);
//                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.charListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        try {

            new ServerStatusTask(status, players).execute().get();

            accCharList = new AccountCharactersTask().execute().get();
            charList = new CharacterSheetTask(accCharList).execute().get();

            for (AccountCharacter character : accCharList) {
                charList.add(new CharacterInfoTask(character.getCharacterID()).execute().get());
                charIcons.add(new CharacterIconTask(character.getCharacterID(), "char", "512").execute().get());
            }

            adapter = new AccountCharactersAdapter(this, charList, charIcons);
            listView.setAdapter(adapter);

        } catch (InterruptedException | ExecutionException e) {
            Log.d("debug", e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}