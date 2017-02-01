package ru.tsk.eveonline.parsers;

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

import ru.tsk.eveonline.logic.SkillQueueItem;

public class SkillQueueParser extends DefaultHandler {

    private String tempValue;
    private String currentTime;

    private InputStream inputStream;

    private SkillQueueItem queueItem;
    private List<SkillQueueItem> queueItemList;

    public SkillQueueParser(InputStream inputStream) {
        this.queueItemList = new ArrayList<>();
        this.inputStream = inputStream;
    }

    public void parseDocument() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("SkillQueueParser", e.getMessage());
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("row")) {
            queueItem = new SkillQueueItem();

            queueItem.setQueuePosition(attributes.getValue("queuePosition"));
            queueItem.setTypeID(attributes.getValue("typeID"));
            queueItem.setLevel(attributes.getValue("level"));
            queueItem.setStartSP(attributes.getValue("startSP"));
            queueItem.setEndSP(attributes.getValue("endSP"));
            queueItem.setStartTime(attributes.getValue("startTime"));
            queueItem.setEndTime(attributes.getValue("endTime"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("currentTime")) {
            currentTime = tempValue;
        }
        if (qName.equalsIgnoreCase("row")) {
            queueItemList.add(queueItem);
        }
    }

    public List<SkillQueueItem> getQueueItemList() {
        return queueItemList;
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
