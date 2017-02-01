package ru.tsk.eveonline;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.parsers.AccountCharactersParser;
import ru.tsk.eveonline.parsers.CharacterInfoParser;

public class TESTS {

    private static String KEY_ID = "5040468";
    private static String vCODE = "Dw46k2jB9N5MHe15BcTdpBumTKFpBauFWP2eoWk3hRoPUn4zLKPmJuaMmbIfEoro";

    private static final String CHAR_INFO = "https://api.eveonline.com/eve/CharacterInfo.xml.aspx?characterID=95764101&userID=4744217&API_KEY=1073741823";
    private static final String CHARACTERS = "https://api.eveonline.com/account/characters.xml.aspx" +
            "?keyID=" + KEY_ID +
            "&vCODE=" + vCODE;

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

            url = new URL(CHARACTERS);
            con = (HttpsURLConnection) url.openConnection();
            accountCharactersParser = new AccountCharactersParser(con.getInputStream());
            accountCharactersParser.parseDocument();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
