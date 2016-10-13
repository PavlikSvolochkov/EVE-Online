package parsers;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import logic.CharacterID;

public class CharacterIDParser extends DefaultHandler {

  /*
   <rowset name="characters" key="characterID" columns="name,characterID">
      <row name="Ito Saika" characterID="95985338" />
      <row name="Shion Saika" characterID="95991232" />
   </rowset>
  */

    private List<CharacterID> charIDList;

    public CharacterIDParser() {
        this.charIDList = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        Log.d("debug", getClass().getName() + "::" + "Start CharacterID parsing.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {
        Log.d("debug", getClass().getName() + "::" + "End CharacterID parsing.");
    }
}
