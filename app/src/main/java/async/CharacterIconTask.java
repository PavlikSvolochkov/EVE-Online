package async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

public class CharacterIconTask extends AsyncTask<String, Void, Bitmap> {

  private final String IMAGE_SERVER = "https://image.eveonline.com";
  private final String ALLIANCE = "/Alliance/";
  private final String CORPORATION = "/Corporation/";
  private final String CHARACTER = "/Character/";
  private final String TYPE = "/Type/";
  private final String RENDER = "/Render/";

  private String id;
  private String iconSize;
  private String iconType;

  private Bitmap bitmap;

  public CharacterIconTask(String id, String iconType, String iconSize) {
    this.id = id;
    this.iconType = iconType;
    this.iconSize = iconSize;
  }

  protected Bitmap doInBackground(String... params) {
    URL imageUrl;
    try {
      imageUrl = new URL(IMAGE_SERVER);
      if (iconType == "alli") {
        imageUrl = new URL(IMAGE_SERVER + ALLIANCE + id + "_" + iconSize + ".png");
      }
      if (iconType == "corp") {
        imageUrl = new URL(IMAGE_SERVER + CORPORATION + id + "_" + iconSize + ".png");
      }
      if (iconType == "char") {
        imageUrl = new URL(IMAGE_SERVER + CHARACTER + id + "_" + iconSize + ".jpg");
      }
      if (iconType == "type") {
        imageUrl = new URL(IMAGE_SERVER + TYPE + id + "_" + iconSize + ".png");
      }
      if (iconType == "rend") {
        imageUrl = new URL(IMAGE_SERVER + RENDER + id + "_" + iconSize + ".png");
      }

      bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());

    } catch (IOException e) {
      Log.e("debug", e.getMessage());
    }
    return bitmap;
  }

  protected void onPostExecute(Bitmap result) {

  }
}
