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

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.ApiKeyInfo;
import ru.tsk.eveonline.logic.CharacterLite;

public class ApiKeyInfoParser extends DefaultHandler {

    private String tempValue;

    private APIKey apiKey;
    private CharacterLite characterLite;
    private ApiKeyInfo apiKeyInfo;
    private InputStream inputStream;

    public ApiKeyInfoParser(InputStream stream) {
        this.inputStream = stream;
        this.apiKeyInfo = new ApiKeyInfo();
    }

    public void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            Log.d("debug", getClass().getName() + "::Creating ApiKeyInfoParser...");
            SAXParser parser = factory.newSAXParser();
            Log.d("debug", getClass().getName() + "::Parse document...");
            parser.parse(inputStream, this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("debug", e.getMessage());
        }
    }

    @Override
    public void startDocument() throws SAXException {
        Log.d("debug", getClass().getName() + "::START PARSING ACCOUNT STATUS");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        List<CharacterLite> characterLiteList = new ArrayList<>();

        if (qName.equalsIgnoreCase("key")) {
            this.apiKey = new APIKey();
        }
        if (qName.equalsIgnoreCase("row")) {
            this.characterLite = new CharacterLite();
        }
        if (qName.equals("key")) {
            apiKey.setAccessMask(attributes.getValue("accessMask"));
            apiKey.setType(attributes.getType("type"));
            apiKey.setExpires(attributes.getType("expires"));
            apiKeyInfo.setApiKey(apiKey);
        }
        if (qName.equalsIgnoreCase("row")) {
            characterLite.setCharacterID(attributes.getType("characterID"));
            characterLite.setCharacterName(attributes.getType("characterName"));
            characterLite.setCorporationID(attributes.getType("corporationID"));
            characterLite.setCorporationName(attributes.getType("corporationName"));
            characterLite.setAllianceID(attributes.getType("allianceID"));
            characterLite.setAllianceName(attributes.getType("allianceName"));
            characterLite.setFactionID(attributes.getType("factionID"));
            characterLite.setFactionName(attributes.getType("factionName"));
            characterLiteList.add(characterLite);
        }
        apiKeyInfo.setCharList(characterLiteList);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        Log.d("debug", getClass().getName() + "::END PARSE ACCOUNT STATUS");
    }
}
