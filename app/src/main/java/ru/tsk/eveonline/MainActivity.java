package ru.tsk.eveonline;

import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import adapters.AccountCharactersAdapter;
import async.AccountCharactersTask;
import async.CharacterIconTask;
import async.CharacterSheetTask;
import async.ServerStatusTask;
import logic.AccountCharacter;
import logic.Character;
import logic.ServerStatus;

public class MainActivity extends AppCompatActivity {

  private ServerStatus serverStatus;
  private List<AccountCharacter> accCharList;
  private List<Character> charList;
  private List<Bitmap> charIcons;

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
    accCharList = new ArrayList<AccountCharacter>();

    TextView statusTV = (TextView) findViewById(R.id.serverStatus);
    TextView playersTV = (TextView) findViewById(R.id.onlinePlayers);

    try {
      charIcons = new CharacterIconTask(accCharList, "256").execute().get();
      serverStatus = new ServerStatusTask(statusTV, playersTV).execute().get();
      accCharList = new AccountCharactersTask().execute().get();
      charList = new CharacterSheetTask(accCharList).execute().get();
      AccountCharactersAdapter adapter = new AccountCharactersAdapter(this, charList, charIcons);
      ListView listView = (ListView) findViewById(R.id.charListView);
      listView.setAdapter(adapter);
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          Intent intent = new Intent(MainActivity.this, CharActivity.class);
          MainActivity.this.startActivity(intent);
        }
      });
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