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

import ru.tsk.eveonline.logic.AccountStatus;

public class AccountStatusParser extends DefaultHandler {

    private String tempValue;

    private InputStream inputStream;
    private AccountStatus accountStatus;

    public AccountStatusParser(InputStream stream) {
        this.inputStream = stream;
    }

    public void parseDocument() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("AccountStatusParser", e.getMessage());
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("paidUntil")) {
            accountStatus = new AccountStatus();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("paidUntil")) {
            accountStatus.setPaidUntil(tempValue);
        }
        if (qName.equalsIgnoreCase("createDate")) {
            accountStatus.setCreateDate(tempValue);
        }
        if (qName.equalsIgnoreCase("logonCount")) {
            accountStatus.setLogonCount(tempValue);
        }
        if (qName.equalsIgnoreCase("logonMinutes")) {
            accountStatus.setLogonMinutes(tempValue);
        }
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }
}
