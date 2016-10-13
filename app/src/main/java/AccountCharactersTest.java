import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import logic.APIKeyInfo;
import logic.AccountCharacter;
import parsers.AccountCharactersParser;
import parsers.CharacterSheetParser;

public class AccountCharactersTest {

    private static final String CHARACTER_LIST = "https://api.eveonline.com/account/characters.xml.aspx" + APIKeyInfo.API_KEY + APIKeyInfo.vCODE;
    private static final String CHARACTER = "https://api.eveonline.com/char/CharacterSheet.xml.aspx" + APIKeyInfo.API_KEY + APIKeyInfo.vCODE;

    public static void main(String[] args) throws IOException {
        URL url = new URL(CHARACTER_LIST);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        AccountCharactersParser charactersParser = new AccountCharactersParser(conn.getInputStream());
        charactersParser.parseDocument();
        charactersParser.printData();

        List<AccountCharacter> list = charactersParser.getCharList();
        for (AccountCharacter character : list) {
            URL charURL = new URL(CHARACTER + "&characterID=" + character.getCharacterID());
            HttpsURLConnection charConn = (HttpsURLConnection) charURL.openConnection();
            CharacterSheetParser parser = new CharacterSheetParser(charConn.getInputStream());
            parser.parseDocument();
            charactersParser.printData();
        }
    }
}
