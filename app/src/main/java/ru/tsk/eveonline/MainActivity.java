package ru.tsk.eveonline;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import adapters.AccountCharactersAdapter;
import async.CharacterIconTask;
import async.CharacterSheetTask;
import async.ServerStatusTask;
import logic.Character;

public class MainActivity extends AppCompatActivity {

  private List<Character> characterList;

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

    TextView statusTV = (TextView) findViewById(R.id.serverStatus);
    TextView playersTV = (TextView) findViewById(R.id.onlinePlayers);
    new ServerStatusTask(statusTV, playersTV).execute();

    try {
      characterList = new CharacterSheetTask().execute().get();
      AccountCharactersAdapter adapter = new AccountCharactersAdapter(this, characterList);
      ListView listView = (ListView) findViewById(R.id.charListView);
      listView.setAdapter(adapter);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    for (Character character : characterList) {
      new CharacterIconTask(this).execute(character.getCharacterId(), "256");
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