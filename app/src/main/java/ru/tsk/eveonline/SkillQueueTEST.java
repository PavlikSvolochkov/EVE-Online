package ru.tsk.eveonline;

import java.io.IOException;
import java.net.URL;

import ru.tsk.eveonline.logic.APIKey;
import ru.tsk.eveonline.logic.Links;
import ru.tsk.eveonline.logic.SkillQueueItem;
import ru.tsk.eveonline.parsers.SkillQueueParser;

public class SkillQueueTEST {

    private static String CHAR_ID = "95767126";

    private static final String SKILL_QUEUE = Links.SKILL_QUEUE + APIKey.API_KEY + APIKey.vCODE
            + "&characterID=" + CHAR_ID;

    public static void main(String[] args) throws IOException {

        System.out.println(SKILL_QUEUE);

        URL queueUrl = new URL(SKILL_QUEUE);

        SkillQueueParser parser = new SkillQueueParser(queueUrl.openStream());
        parser.parseDocument();

        System.out.println(parser.getCurrentTime());
        for (SkillQueueItem skillQueueItem : parser.getQueueItemList()) {
            System.out.println(skillQueueItem.toString());
        }
    }
}
