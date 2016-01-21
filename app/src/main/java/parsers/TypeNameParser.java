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

import logic.TypeName;

public class TypeNameParser extends DefaultHandler {

  private String tempValue;
  private TypeName typeName;
  private List<TypeName> typeNameList;
  private InputStream inputStream;

  public TypeNameParser(InputStream inputStream) {
    this.inputStream = inputStream;
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
    Log.d("debug", getClass().getName() + "::START DOCUMENT PARSING...");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("row")) {
      typeName = new TypeName();
      typeNameList = new ArrayList<>();
    }
    if (qName.equalsIgnoreCase("row")) {
      typeName.setTypeID(attributes.getValue("typeID"));
      typeName.setTypeName(attributes.getValue("typeName"));
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
//    tempValue = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equalsIgnoreCase("row")) {
      typeNameList.add(typeName);
    }
  }

  @Override
  public void endDocument() throws SAXException {
    Log.d("debug", getClass().getName() + "::END DOCUMENT PARSING.");
  }

  public List<TypeName> getTypeNameList() {
    return typeNameList;
  }

  public TypeName getTypeName() {
    return typeName;
  }

  public void printNames() {
    for (TypeName name : typeNameList) {
      Log.d("debug", getClass().getName() + "::" + name.toString());
    }
  }
}
