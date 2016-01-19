package parsers;

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

import logic.AccountCharacter;

public class AccountCharactersParser extends DefaultHandler {

  private String tmpValue;
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
//      Log.d("Response", "Creating parser...");
      SAXParser parser = factory.newSAXParser();
//      Log.d("Response", "Parse document...");
      parser.parse(inputStream, this);
//      printData();
    } catch (ParserConfigurationException | SAXException | IOException e) {
//      Log.d("Response", "ERROR PARSE DOCUMENT");
    }
  }

  @Override
  public void startDocument() throws SAXException {
//    Log.d("Response", "START DOCUMENT PARSING (ACCOUNT CHARACTERS)");
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
  public void characters(char[] ch, int start, int length) throws SAXException {
    tmpValue = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {

    if (qName.equals("row")) {
      characterList.add(character);
    }
  }

  @Override
  public void endDocument() throws SAXException {
//    Log.d("Response", "END DOCUMENT PARSING (ACCOUNT CHARACTERS)");
  }

  public void printData() {
    for (AccountCharacter character : characterList) {
//      Log.d("Response", character.toString());
      System.out.println(character.toString());
    }
  }

  public List<AccountCharacter> getCharList() {
    return characterList;
  }
}
