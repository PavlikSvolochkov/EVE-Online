package async;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

import logic.CharInfoViewHolder;
import logic.Character;
import parsers.CharacterInfoParser;
import ru.tsk.eveonline.R;

public class CharacterInfoTask extends AsyncTask<String, Void, Void> {

  private final String CHAR_INFO = "https://api.eveonline.com/eve/CharacterInfo.xml.aspx?characterID=95767126&userID=4744217&API_KEY=1073741823";

  private Character character;
  private CharInfoViewHolder viewHolder;
  private CharacterInfoParser parser;

  public CharacterInfoTask(CharInfoViewHolder viewHolder) {
    this.character = new Character();
    this.viewHolder = viewHolder;
  }

  @Override
  protected void onPreExecute() {
  }

  @Override
  protected Void doInBackground(String... params) {
    URL url;
    HttpsURLConnection con;
    try {
      url = new URL(CHAR_INFO);
      con = (HttpsURLConnection) url.openConnection();
      parser = new CharacterInfoParser(con.getInputStream());
      parser.parseDocument();
      parser.printData();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  protected void onPostExecute(Void aVoid) {
    character = parser.getCharacter();
    viewHolder.imageView.setImageResource(R.drawable.ps_128);
    viewHolder.characterName.setText(character.getName());
    viewHolder.charRace.setText(character.getRace() + " - " + character.getBloodline() + " - " + character.getAncestry());
    viewHolder.corporation.append(character.getCorporation());
    try {
      viewHolder.balance.append(String.valueOf(new AccountBalanceTask("").execute().get().getBalance()));
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
