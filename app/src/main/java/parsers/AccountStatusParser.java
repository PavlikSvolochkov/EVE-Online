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

import logic.Account;

public class AccountStatusParser extends DefaultHandler {

  private String tempValue;

  private InputStream inputStream;
  private Account account;

  public AccountStatusParser(InputStream stream) {
    this.inputStream = stream;
  }

  public void parseDocument() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      SAXParser parser = factory.newSAXParser();
      parser.parse(inputStream, this);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      Log.d("debug", "ERROR PARSE DOCUMENT");
    }
  }

  @Override
  public void startDocument() throws SAXException {
    Log.d("debug", "START PARSING ACCOUNT STATUS");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("paidUntil")) {
      account = new Account();
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    tempValue = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equalsIgnoreCase("paidUntil")) {
      account.setPaidUntil(tempValue);
    }
    if (qName.equalsIgnoreCase("createDate")) {
      account.setCreateDate(tempValue);
    }
    if (qName.equalsIgnoreCase("logonCount")) {
      account.setLogonCount(tempValue);
    }
    if (qName.equalsIgnoreCase("logonMinutes")) {
      account.setLogonMinutes(tempValue);
    }
  }

  @Override
  public void endDocument() throws SAXException {
    Log.d("debug", "END PARSE ACCOUNT STATUS");
  }

  public Account getAccount() {
    return account;
  }
}
