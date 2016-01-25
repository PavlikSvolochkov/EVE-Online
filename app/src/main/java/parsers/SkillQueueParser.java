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

import logic.SkillQueueItem;

public class SkillQueueParser extends DefaultHandler {

  private SkillQueueItem item;
  private List<SkillQueueItem> items;

  private InputStream inputStream;

  public SkillQueueParser(InputStream inputStream) {
    this.items = new ArrayList<>();
    this.inputStream = inputStream;
  }

  public void parseDocument() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      Log.d("debug", getClass().getName() + "::Creating SkillQueueParser...");
      SAXParser parser = factory.newSAXParser();
      Log.d("debug", getClass().getName() + "::Parse document...");
      parser.parse(inputStream, this);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      Log.d("debug", e.getMessage());
    }
  }

  @Override
  public void startDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "START DOCUMENT PARSING");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("row")) {
      item = new SkillQueueItem();

      // <row queuePosition="0" typeID="3440" level="5" startSP="181020" endSP="1024000" startTime="2015-11-25 07:50:03" endTime="2015-12-11 14:06:09"/>
      item.setQueuePosition(attributes.getValue("queuePosition"));
      item.setTypeID(attributes.getValue("typeID"));
      item.setLevel(attributes.getValue("level"));
      item.setStartSP(attributes.getValue("startSP"));
      item.setStartSP(attributes.getValue("endSP"));
      item.setStartSP(attributes.getValue("startTime"));
      item.setStartSP(attributes.getValue("endTime"));
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {

  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    items.add(item);
  }

  @Override
  public void endDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "END DOCUMENT PARSING");
  }

  public List<SkillQueueItem> getItems() {
    return items;
  }
}
