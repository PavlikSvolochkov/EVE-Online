package adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import logic.Character;
import ru.tsk.eveonline.R;

public class AccountCharactersAdapter extends BaseAdapter {

  private TextView charName;
  private TextView corpName;
  private TextView ancestry;
  private TextView balance;
  private TextView training;

  private ImageView charIcon;

  private List<Character> characters;

  private Activity activity;
  private LayoutInflater inflater;


  public AccountCharactersAdapter(Activity activity, List<logic.Character> values) {
    super();
    this.characters = values;
    this.activity = activity;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    inflater = activity.getLayoutInflater();

    if (convertView == null) {
      convertView = inflater.inflate(R.layout.char_item, null);

      charName = (TextView) convertView.findViewById(R.id.charName);
      ancestry = (TextView) convertView.findViewById(R.id.ancestry);
      corpName = (TextView) convertView.findViewById(R.id.corpName);
      balance = (TextView) convertView.findViewById(R.id.accBalance);
      training = (TextView) convertView.findViewById(R.id.skillTraining);
      charIcon = (ImageView) convertView.findViewById(R.id.charIcon);
    }

    Character character = characters.get(position);

    charName.setText(character.getName());
    corpName.setText(character.getCorporation());
    ancestry.setText(character.getRace() + " - " + character.getBloodline() + " - " + character.getAncestry());
    balance.setText("Balance: " + character.getBalance());
    training.setText(character.getFreeRespecs());

    File image = new File(character.getCharacterId() + "_256.jpeg");

    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
    Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), bmOptions);
    charIcon.setImageBitmap(bitmap);

    return convertView;
  }

  @Override
  public int getCount() {
    return characters.size();
  }

  @Override
  public Object getItem(int position) {
    return characters.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

}
