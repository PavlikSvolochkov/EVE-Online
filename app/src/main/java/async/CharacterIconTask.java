package async;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CharacterIconTask extends AsyncTask<String, Void, Bitmap> {

  private String ICON_URL = "https://image.eveonline.com/Character/";

  private ImageView bmImage;
  private Context context;

  public CharacterIconTask(Context context) {
    this.context = context;
  }

  protected Bitmap doInBackground(String... params) {
    String charId = params[0];
    String imageWidth = params[1];
    Bitmap icon = null;
    try {
//      URL url = new URL(ICON_URL + width[0] + "_" + width[1] + ".jpg");
//      Log.d("response", "****** Initialize InputStream ******");
//      InputStream in = url.openStream();
//      Log.d("response", "DECODE STREAM...");
//      icon = BitmapFactory.decodeStream(in);

      URL imageUrl = new URL(ICON_URL + charId + "_" + imageWidth + ".jpg");
      Bitmap bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());

      FileOutputStream output = context.openFileOutput(charId + "_" + imageWidth + ".jpg", Context.MODE_PRIVATE);

      byte[] data = new byte[1024];
      output.write(data);
      output.flush();
      output.close();

//      in.close();
    } catch (IOException e) {
      Log.e("Error", e.getMessage());
      e.printStackTrace();
    }
    return icon;
  }

  protected void onPostExecute(Bitmap result) {
//    bmImage.setImageBitmap(result);
  }

  public static void productLookup(String productID, Context c) throws IOException {
    URL url = new URL("http://www.samplewebsite.com/" + productID + ".jpg");

    URLConnection connection = url.openConnection();
    InputStream input = connection.getInputStream();

    FileOutputStream output = c.openFileOutput(productID + "_" + ".jpg", Context.MODE_PRIVATE);
    byte[] data = new byte[1024];

    output.write(data);
    output.flush();
    output.close();
    input.close();
  }
}
