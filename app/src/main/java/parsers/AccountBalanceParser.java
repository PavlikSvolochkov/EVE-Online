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

import logic.AccountBalance;

public class AccountBalanceParser extends DefaultHandler {

  private String tempValue;
  private AccountBalance balance;
  private InputStream inputStream;

  public AccountBalanceParser(InputStream in) {
    this.inputStream = in;
  }

  public void parseDocument() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      Log.d("Response", "Creating parser...");
      SAXParser parser = factory.newSAXParser();
      Log.d("Response", "Parse document...");
      parser.parse(inputStream, this);
      printData();
    } catch (ParserConfigurationException | SAXException | IOException e) {
      Log.d("Response", "ERROR PARSE DOCUMENT");
    }
  }

  @Override
  public void startDocument() throws SAXException {
    Log.d("parser", "START DOCUMENT PARSING (ACCOUNT BALANCE)");
  }

  @Override
  public void endDocument() throws SAXException {
    Log.d("parser", "END DOCUMENT PARSING (ACCOUNT BALANCE)");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("row")) {
      balance = new AccountBalance();
      balance.setAccountID(attributes.getValue("accountID"));
      balance.setAccountKey(attributes.getValue("accountKey"));
      balance.setBalance(attributes.getValue("balance"));
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {

  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    tempValue = new String(ch, start, length);
  }

  public AccountBalance getBalance() {
    return balance;
  }

  public void printData() {
    Log.d("Response", "Balance: " + balance.toString());
  }
}
