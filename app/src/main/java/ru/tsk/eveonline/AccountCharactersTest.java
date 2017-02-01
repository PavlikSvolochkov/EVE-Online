package ru.tsk.eveonline;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.AccountCharacter;
import ru.tsk.eveonline.parsers.AccountCharactersParser;
import ru.tsk.eveonline.parsers.CharacterSheetParser;

public class AccountCharactersTest {

    private static final String CHARACTER_LIST = "https://api.eveonline.com/account/characters.xml.aspx" + APIKey.API_KEY + APIKey.vCODE;
    private static final String CHARACTER = "https://api.eveonline.com/char/CharacterSheet.xml.aspx" + APIKey.API_KEY + APIKey.vCODE;

    public static void main(String[] args) throws IOException {
        URL url = new URL(CHARACTER_LIST);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        AccountCharactersParser charactersParser = new AccountCharactersParser(conn.getInputStream());
        charactersParser.parseDocument();

        List<AccountCharacter> list = charactersParser.getCharList();
        for (AccountCharacter character : list) {
            URL charURL = new URL(CHARACTER + "&characterID=" + character.getCharacterID());
            HttpsURLConnection charConn = (HttpsURLConnection) charURL.openConnection();
            CharacterSheetParser parser = new CharacterSheetParser(charConn.getInputStream());
            parser.parseDocument();
        }
    }
}
