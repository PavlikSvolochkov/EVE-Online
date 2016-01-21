package parsers;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import logic.CharacterInfo;

public class CharacterInfoParser extends DefaultHandler {

  private String tempValue;
  private InputStream inputStream;
  private CharacterInfo character;

  public CharacterInfoParser(InputStream in) {
    this.inputStream = in;
  }

  public void parseDocument() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      SAXParser parser = factory.newSAXParser();
      parser.parse(inputStream, this);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      Log.d("debug", e.getMessage());
    }
  }

  @Override
  public void startDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "::START CHARACTER_INFO PARSING");
  }

  @Override
  public void endDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "::END CHARACTER_INFO PARSING");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("result")) {
      character = new CharacterInfo();
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {

    if (qName.equalsIgnoreCase("characterID")) {
      character.setCharacterID(tempValue);
    }
    if (qName.equalsIgnoreCase("characterName")) {
      character.setCharacterName(tempValue);
    }
    if (qName.equalsIgnoreCase("race")) {
      character.setRace(tempValue);
    }
    if (qName.equalsIgnoreCase("bloodlineID")) {
      character.setBloodlineID(tempValue);
    }
    if (qName.equalsIgnoreCase("bloodline")) {
      character.setBloodline(tempValue);
    }
    if (qName.equalsIgnoreCase("ancestryID")) {
      character.setAncestryID(tempValue);
    }
    if (qName.equalsIgnoreCase("ancestry")) {
      character.setAncestry(tempValue);
    }
    if (qName.equalsIgnoreCase("accountBalance")) {
      character.setAccountBalance(tempValue);
    }
    if (qName.equalsIgnoreCase("corporationID")) {
      character.setCorporationID(tempValue);
    }
    if (qName.equalsIgnoreCase("corporation")) {
      character.setCorporation(tempValue);
    }
    if (qName.equalsIgnoreCase("skillPoints")) {
      character.setSkillPoints(tempValue);
    }
    if (qName.equalsIgnoreCase("nextTrainingEnds")) {
      character.setNextTrainingEnds(tempValue);
    }
    if (qName.equalsIgnoreCase("shipName")) {
      character.setShipName(tempValue);
    }
    if (qName.equalsIgnoreCase("shipTypeID")) {
      character.setShipTypeID(tempValue);
    }
    if (qName.equalsIgnoreCase("shipTypeName")) {
      character.setShipTypeName(tempValue);
    }
    if (qName.equalsIgnoreCase("corporationDate")) {
      character.setCorporationDate(tempValue);
    }
    if (qName.equalsIgnoreCase("allianceID")) {
      character.setAllianceID(tempValue);
    }
    if (qName.equalsIgnoreCase("alliance")) {
      character.setAlliance(tempValue);
    }
    if (qName.equalsIgnoreCase("allianceDate")) {
      character.setAllianceDate(tempValue);
    }
    if (qName.equalsIgnoreCase("lastKnownLocation")) {
      character.setLastKnownLocation(tempValue);
    }
    if (qName.equalsIgnoreCase("securityStatus")) {
      character.setSecurityStatus(tempValue);
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    tempValue = new String(ch, start, length);
  }

  public void printData() {
    Log.d("debug", getClass().getName() + "::Character: " + character.toString());
  }

  public CharacterInfo getCharacter() {
    return character;
  }

  public class EmploymentHistory {

    private String recordID;
    private String corporationID;
    private String corporationName;
    private String startDate;

    public String getRecordID() {
      return recordID;
    }

    public void setRecordID(String recordID) {
      this.recordID = recordID;
    }

    public String getCorporationID() {
      return corporationID;
    }

    public void setCorporationID(String corporationID) {
      this.corporationID = corporationID;
    }

    public String getCorporationName() {
      return corporationName;
    }

    public void setCorporationName(String corporationName) {
      this.corporationName = corporationName;
    }

    public String getStartDate() {
      return startDate;
    }

    public void setStartDate(String startDate) {
      this.startDate = startDate;
    }
  }
}
