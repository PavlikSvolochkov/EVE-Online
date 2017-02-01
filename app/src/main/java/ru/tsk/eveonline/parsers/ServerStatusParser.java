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

import ru.tsk.eveonline.logic.ServerStatus;

public class ServerStatusParser extends DefaultHandler {

    private String tempValue;
    private ServerStatus status;
    private InputStream inputStream;

    public ServerStatusParser(InputStream in) {
        this.inputStream = in;
    }

    public void parseDocument() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("ServerStatusParser", e.getMessage());
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("currentTime")) {
            status = new ServerStatus();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("serverOpen")) {
            status.setStatus(tempValue);
        }
        if (qName.equalsIgnoreCase("onlinePlayers")) {
            status.setPlayers(Integer.parseInt(tempValue));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempValue = new String(ch, start, length);
    }

    public ServerStatus getStatus() {
        return status;
    }
}
