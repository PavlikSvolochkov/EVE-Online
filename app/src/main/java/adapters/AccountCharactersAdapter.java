package adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

  private List<Bitmap> charIcons;

  public AccountCharactersAdapter(Activity activity, List<logic.Character> values, List<Bitmap> charIcons) {
    super();
    this.characters = values;
    this.activity = activity;
    this.charIcons = charIcons;
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

//    charIcon.setImageBitmap();

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
