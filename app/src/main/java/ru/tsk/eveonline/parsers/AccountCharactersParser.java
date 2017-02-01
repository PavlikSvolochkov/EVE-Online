package ru.tsk.eveonline.parsers;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ru.tsk.eveonline.logic.AccountCharacter;

public class AccountCharactersParser extends DefaultHandler {

    private InputStream inputStream;
    private List<AccountCharacter> characterList;
    private AccountCharacter character;

    public AccountCharactersParser(InputStream in) {
        inputStream = in;
        characterList = new ArrayList<>();
    }

    public void parseDocument() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("AccountCharactersParser", e.getMessage());
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("row")) {
            character = new AccountCharacter();

            character.setName(attributes.getValue("name"));
            character.setCharacterID(attributes.getValue("characterID"));
            character.setCorporationName(attributes.getValue("corporationName"));
            character.setCorporationID(attributes.getValue("corporationID"));
            character.setAllianceID(attributes.getValue("allianceID"));
            character.setAllianceName(attributes.getValue("allianceName"));
            character.setFactionID(attributes.getValue("factionID"));
            character.setFactionName(attributes.getValue("factionName"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("row")) {
            characterList.add(character);
        }
    }

    public List<AccountCharacter> getCharList() {
        return characterList;
    }
}
