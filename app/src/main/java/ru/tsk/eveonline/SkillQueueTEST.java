package ru.tsk.eveonline;

import java.io.IOException;
import java.net.URL;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.parsers.SkillQueueParser;

public class SkillQueueTEST {

    private static String CHAR_ID = "95767126";

    private static final String SKILL_QUEUE = "https://api.eveonline.com/char/SkillQueue.xml.aspx"
            + APIKey.API_KEY
            + APIKey.vCODE
            + "&characterID=" + CHAR_ID;

    public static void main(String[] args) throws IOException {

        System.out.println(SKILL_QUEUE);

        URL queueUrl = new URL(SKILL_QUEUE);

        SkillQueueParser parser = new SkillQueueParser(queueUrl.openStream());
        parser.parseDocument();
        parser.printQueue();
    }
}
