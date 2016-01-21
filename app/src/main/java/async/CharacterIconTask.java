package async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import logic.AccountCharacter;

public class CharacterIconTask extends AsyncTask<String, Void, List> {

  private String ICON_URL = "https://image.eveonline.com/Character/";
  private String picSize;
  private List<Bitmap> bitmapList;
  private List<AccountCharacter> accCharList;


  public CharacterIconTask(List<AccountCharacter> accChars, String picSize) {
    this.bitmapList = new ArrayList<>();
    this.accCharList = accChars;
    this.picSize = picSize;
  }

  protected List doInBackground(String... params) {
    try {
      for (AccountCharacter character : accCharList) {
        URL imageUrl = new URL(ICON_URL + character.getCharacterID() + "_" + picSize + ".jpg");
        Bitmap bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
        bitmapList.add(bitmap);
      }
    } catch (IOException e) {
      Log.d("debug", e.getMessage());
    }
    return bitmapList;
  }

  protected void onPostExecute(Bitmap result) {
//    bmImage.setImageBitmap(result);
  }
}
