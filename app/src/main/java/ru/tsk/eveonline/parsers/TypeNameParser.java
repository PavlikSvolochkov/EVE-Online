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

import ru.tsk.eveonline.logic.TypeName;

public class TypeNameParser extends DefaultHandler {

    private TypeName typeName;
    private List<TypeName> typeNameList;
    private InputStream inputStream;

    public TypeNameParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parseDocument() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            Log.d("TypeNameParser", e.getMessage());
        }
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
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("row")) {
            typeNameList.add(typeName);
        }
    }

    public List<TypeName> getTypeNameList() {
        return typeNameList;
    }

    public TypeName getTypeName() {
        return typeName;
    }

}
