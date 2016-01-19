import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import parsers.AccountCharactersParser;
import parsers.CharacterInfoParser;

public class TESTS {

  private static final String CHAR_INFO = "https://api.eveonline.com/eve/CharacterInfo.xml.aspx?characterID=95764101&userID=4744217&API_KEY=1073741823";
  private static final String CHARACTERS = "https://api.eveonline.com/account/characters.xml.aspx" +
          "?keyID=4744217" +
          "&vCODE=7VHnHgo7X02AmGVUK8QSKHJ9xb0KD3zaVQ15zNGARZGiMgguWL3825TAkgAWWuK9";

  public static void main(String[] args) {

    URL url;
    HttpsURLConnection con;
    CharacterInfoParser characterInfoParser;
    AccountCharactersParser accountCharactersParser;

    try {

      url = new URL(CHAR_INFO);
      con = (HttpsURLConnection) url.openConnection();
      characterInfoParser = new CharacterInfoParser(con.getInputStream());
      characterInfoParser.parseDocument();
      characterInfoParser.printData();

      url = new URL(CHARACTERS);
      con = (HttpsURLConnection) url.openConnection();
      accountCharactersParser = new AccountCharactersParser(con.getInputStream());
      accountCharactersParser.parseDocument();
      accountCharactersParser.printData();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
