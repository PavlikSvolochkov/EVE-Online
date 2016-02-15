package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class DBHelper extends SQLiteOpenHelper {

  private static String DBPath = "/data/data/EVE-Online/databases";
  private static String DBName = "sqlite-latest";

  private SQLiteDatabase database;

  private final Context context;

  public DBHelper(Context context) {
    super(context, DBName, null, 1);
    this.context = context;
  }

  public void createDataBase() throws IOException {
    boolean dbExist = checkDB();

    if (dbExist) {
      this.getReadableDatabase();
      try {
        copyDB();
      } catch (IOException e) {
        throw new Error("Error copying database");
      }
    }
  }

  private boolean checkDB() {
    SQLiteDatabase checkDB = null;

    try {
      String myPath = DBPath + DBName;
      checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    } catch (SQLiteException e) {
      e.printStackTrace();
    }
    if (checkDB != null) {
      checkDB.close();
    }
    return checkDB != null ? true : false;
  }

  private void copyDB() throws IOException{
    InputStream input = context.getAssets().open(DBName);
    String outFileName = DBPath + DBName;

    OutputStream output = new FileOutputStream(outFileName);

    byte[] buffer = new byte[1024];
    int length;
    while ((length = input.read(buffer)) > 0) {
      output.write(buffer, 0, length);
    }

    output.flush();
    output.close();
    input.close();
  }

  public void openDB() throws SQLException {
    String myPath = DBPath + DBName;
    database = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
  }

  @Override
  public void onOpen(SQLiteDatabase db) {
    super.onOpen(db);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  @Override
  public synchronized void close() {
    if (database != null) {
      database.close();
    }
    super.close();
  }
}
