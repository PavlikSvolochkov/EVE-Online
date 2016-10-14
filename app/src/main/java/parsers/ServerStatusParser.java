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

import logic.ServerStatus;

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
            Log.d("debug", getClass().getName() + "::Creating ServerStatusParser...");
            SAXParser parser = factory.newSAXParser();
            Log.d("debug", getClass().getName() + "::Parse document...");
            parser.parse(inputStream, this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("debug", e.getMessage());
        }
    }

    public void printStatus() {
        Log.d("debug", getClass().getName() + "::Server status: " + status.getStatus() + "\nPlayers online: " + status.getPlayers());
    }

    @Override
    public void startDocument() throws SAXException {
        Log.d("debug", getClass().getName() + "::START DOCUMENT PARSING (SERVER STATUS)");
    }

    @Override
    public void endDocument() throws SAXException {
        Log.d("debug", getClass().getName() + "::END DOCUMENT PARSING (SERVER STATUS)");
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
