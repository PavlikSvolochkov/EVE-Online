package ru.tsk.eveonline.parsers;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ru.tsk.eveonline.logic.AccountBalance;

public class AccountBalanceParser extends DefaultHandler {

    private AccountBalance balance;
    private InputStream inputStream;

    public AccountBalanceParser(InputStream in) {
        this.inputStream = in;
    }

    public void parseDocument() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("AccountBalanceParser", e.getMessage());
        }
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

    public AccountBalance getBalance() {
        return balance;
    }
}
