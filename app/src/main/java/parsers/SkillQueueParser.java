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

    public SkillQueueParser() {
    }

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

            item.setQueuePosition(attributes.getValue("queuePosition"));
            item.setTypeID(attributes.getValue("typeID"));
            item.setLevel(attributes.getValue("level"));
            item.setStartSP(attributes.getValue("startSP"));
            item.setEndSP(attributes.getValue("endSP"));
            item.setStartTime(attributes.getValue("startTime"));
            item.setEndTime(attributes.getValue("endTime"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("row")) {
            items.add(item);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        Log.d("debug", getClass().getName() + "END DOCUMENT PARSING");
    }

    public List<SkillQueueItem> getItems() {
        return items;
    }

    public void printQueue() {
        for (SkillQueueItem item : items) {
            Log.d("debug", item.toString());
        }
    }
}
