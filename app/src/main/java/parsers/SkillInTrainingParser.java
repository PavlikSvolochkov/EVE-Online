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

import logic.SkillInTraining;

public class SkillInTrainingParser extends DefaultHandler {

  private String tempValue;
  private SkillInTraining skill;
  private InputStream inputStream;

  public SkillInTrainingParser(InputStream in) {
    this.inputStream = in;
  }

  public void parseDocument() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      Log.d("debug", getClass().getName() + "::Creating parser...");
      SAXParser parser = factory.newSAXParser();
      Log.d("debug", getClass().getName() + "::Parse document...");
      parser.parse(inputStream, this);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      Log.d("debug", e.getMessage());
    }
  }

  @Override
  public void startDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "::START DOCUMENT PARSING");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("currentTQTime")) {
      skill = new SkillInTraining();
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    tempValue = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equalsIgnoreCase("currentTQTime")) {
      skill.setCurrentTQTime(tempValue);
    }
    if (qName.equalsIgnoreCase("trainingEndTime")) {
      skill.setTrainingEndTime(tempValue);
    }
    if (qName.equalsIgnoreCase("trainingStartTime")) {
      skill.setTrainingStartTime(tempValue);
    }
    if (qName.equalsIgnoreCase("trainingTypeID")) {
      skill.setTrainingTypeID(tempValue);
    }
    if (qName.equalsIgnoreCase("trainingStartSP")) {
      skill.setTrainingStartSP(tempValue);
    }
    if (qName.equalsIgnoreCase("trainingDestinationSP")) {
      skill.setTrainingDestinationSP(tempValue);
    }
    if (qName.equalsIgnoreCase("trainingToLevel")) {
      skill.setTrainingToLevel(tempValue);
    }
    if (qName.equalsIgnoreCase("skillInTraining")) {
      skill.setSkillInTraining(tempValue);
    }
  }

  @Override
  public void endDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "::END DOCUMENT PARSING");
  }

  public SkillInTraining getSkill() {
    return skill;
  }
}
