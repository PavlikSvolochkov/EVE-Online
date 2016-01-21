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

public class CharacterSheetParser extends DefaultHandler {

  private String tempValue;

  private Character character;
  private List<Character> charList;

  private InputStream inputStream;

  public CharacterSheetParser() {
    this.charList = new ArrayList<>();
  }

  public CharacterSheetParser(InputStream stream) {
    this.charList = new ArrayList<>();
    this.inputStream = stream;
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
    Log.d("debug", getClass().getName() + "::START DOCUMENT PARSING...");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("result")) {
      character = new Character();
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    tempValue = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equalsIgnoreCase("result")) {
      charList.add(character);
    }
    if (qName.equalsIgnoreCase("characterID")) {
      character.setCharacterId(tempValue);
    }
    if (qName.equalsIgnoreCase("name")) {
      character.setName(tempValue);
    }
    if (qName.equalsIgnoreCase("homeStationID")) {
      character.setHomeStationId(tempValue);
    }
    if (qName.equalsIgnoreCase("DoB")) {
      character.setDoB(tempValue);
    }
    if (qName.equalsIgnoreCase("race")) {
      character.setRace(tempValue);
    }
    if (qName.equalsIgnoreCase("bloodLineID")) {
      character.setBloodlineId(tempValue);
    }
    if (qName.equalsIgnoreCase("bloodLine")) {
      character.setBloodline(tempValue);
    }
    if (qName.equalsIgnoreCase("ancestryID")) {
      character.setAncestryID(tempValue);
    }
    if (qName.equalsIgnoreCase("ancestry")) {
      character.setAncestry(tempValue);
    }
    if (qName.equalsIgnoreCase("gender")) {
      character.setGender(tempValue);
    }
    if (qName.equalsIgnoreCase("corporationName")) {
      character.setCorporation(tempValue);
    }
    if (qName.equalsIgnoreCase("corporationID")) {
      character.setCorporationID(tempValue);
    }
    if (qName.equalsIgnoreCase("allianceName")) {
      character.setAllianceName(tempValue);
    }
    if (qName.equalsIgnoreCase("allianceID")) {
      character.setAllianceId(tempValue);
    }
    if (qName.equalsIgnoreCase("factionName")) {
      character.setFactionName(tempValue);
    }
    if (qName.equalsIgnoreCase("factionID")) {
      character.setFactionId(tempValue);
    }
    if (qName.equalsIgnoreCase("cloneTypeID")) {
      character.setCloneTypeId(tempValue);
    }
    if (qName.equalsIgnoreCase("cloneName")) {
      character.setCloneName(tempValue);
    }
    if (qName.equalsIgnoreCase("cloneSkillPoints")) {
      character.setCloneSkillPoints(tempValue);
    }
    if (qName.equalsIgnoreCase("freeSkillPoints")) {
      character.setFreeSkillPoints(tempValue);
    }
    if (qName.equalsIgnoreCase("freeRespecs")) {
      character.setFreeRespecs(tempValue);
    }
    if (qName.equalsIgnoreCase("cloneJumpDate")) {
      character.setCloneJumpDate(tempValue);
    }
    if (qName.equalsIgnoreCase("lastRespecDate")) {
      character.setLastRespecDate(tempValue);
    }
    if (qName.equalsIgnoreCase("lastTimedRespec")) {
      character.setLastTimeRespec(tempValue);
    }
    if (qName.equalsIgnoreCase("remoteStationDate")) {
      character.setRemoteStationDate(tempValue);
    }

    /**TODO
     * jumpClones
     * jumpCloneImplants
     */

    if (qName.equalsIgnoreCase("jumpActivation")) {
      character.setJumpActivation(tempValue);
    }
    if (qName.equalsIgnoreCase("jumpFatigue")) {
      character.setJumpFatigue(tempValue);
    }
    if (qName.equalsIgnoreCase("jumpLastUpdate")) {
      character.setJumpLastUpdate(tempValue);
    }
    if (qName.equalsIgnoreCase("balance")) {
      character.setBalance(tempValue);
    }

    /**TODO
     * implants
     * attributes
     * skills
     * certificates
     * corporationRoles
     * corporationRolesAtHQ
     * corporationRolesAtBase
     * corporationRolesAtOther
     * corporationTitles
     */
  }

  @Override
  public void endDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "::END DOCUMENT PARSING.");
  }

  public void printData() {
    for (Character character : charList) {
      Log.d("debug", getClass().getName() + "::Character: " + character.toString());
    }
  }

  public Character getCharacter() {
    return character;
  }

  public List<Character> getCharList() {
    return charList;
  }

  public void  setInputStream(InputStream stream) {
    this.inputStream = stream;
  }
}
