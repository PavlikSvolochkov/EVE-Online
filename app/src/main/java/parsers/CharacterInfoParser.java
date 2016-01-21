package parsers;

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

import logic.Character;

public class CharacterInfoParser extends DefaultHandler {

  private String tempValue;
  private InputStream inputStream;
  private List<EmploymentHistory> empHistoryList;

  private Character character;
  private EmploymentHistory empHistory;

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
      character = new Character();
    }
    if (qName.equalsIgnoreCase("rowset")) {
      empHistory = new EmploymentHistory();
      if (empHistoryList == null) {
        empHistoryList = new ArrayList<>();
      }
    }
    if (qName.equalsIgnoreCase("row")) {
      empHistory.setRecordID(attributes.getValue("recordID"));
      empHistory.setCorporationID(attributes.getValue("corporationID"));
      empHistory.setCorporationName(attributes.getValue("corporationName"));
      empHistory.setStartDate(attributes.getValue("startDate"));
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {

    if (qName.equalsIgnoreCase("row")) {
      empHistoryList.add(empHistory);
    }

    if (qName.equalsIgnoreCase("characterID")) {
      character.setCharacterId(tempValue);
    }
    if (qName.equalsIgnoreCase("characterName")) {
      character.setName(tempValue);
    }
    if (qName.equalsIgnoreCase("race")) {
      character.setRace(tempValue);
    }
    if (qName.equalsIgnoreCase("bloodlineID")) {
      character.setBloodlineId(tempValue);
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
    if (qName.equalsIgnoreCase("corporationID")) {
      character.setCorporationID(tempValue);
    }
    if (qName.equalsIgnoreCase("corporation")) {
      character.setCorporation(tempValue);
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    tempValue = new String(ch, start, length);
  }

  public void printData() {
    Log.d("debug", getClass().getName() + "::Character: " + character.toString());
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

  public Character getCharacter() {
    return character;
  }
}
