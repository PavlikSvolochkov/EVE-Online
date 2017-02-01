package ru.tsk.eveonline;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.AccountCharacter;
import ru.tsk.eveonline.logic.Links;
import ru.tsk.eveonline.parsers.AccountCharactersParser;
import ru.tsk.eveonline.parsers.CharacterInfoParser;

public class TESTS {

    public static final String CHAR_ID = "95764101";
    private static final String CHAR_INFO = Links.CHARACTER_INFO
            + "?characterID=" + CHAR_ID + "&userID=4744217&API_KEY=1073741823";
    private static final String CHARACTERS = Links.CHARACTERS + APIKey.API_KEY + APIKey.vCODE;

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
            System.out.println("TESTS" + characterInfoParser.getCharacter().toString());

            url = new URL(CHARACTERS);
            con = (HttpsURLConnection) url.openConnection();
            accountCharactersParser = new AccountCharactersParser(con.getInputStream());
            accountCharactersParser.parseDocument();
            for (AccountCharacter accountCharacter : accountCharactersParser.getCharList()) {
                System.out.println("TESTS" + accountCharacter.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
