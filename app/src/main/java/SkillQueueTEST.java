import java.io.IOException;
import java.net.URL;

import parsers.SkillQueueParser;

public class SkillQueueTEST {

    private static String KEY_ID = "5040468";
    private static String vCODE = "Dw46k2jB9N5MHe15BcTdpBumTKFpBauFWP2eoWk3hRoPUn4zLKPmJuaMmbIfEoro";
    private static String CHAR_ID = "95767126";

    private static final String SKILL_QUEUE = "https://api.eveonline.com/char/SkillQueue.xml.aspx?"
            + "keyID=" + KEY_ID
            + "&vCODE=" + vCODE
            + "&characterID=" + CHAR_ID;

    public static void main(String[] args) throws IOException {

        System.out.println(SKILL_QUEUE);

        URL queueUrl = new URL(SKILL_QUEUE);

        SkillQueueParser parser = new SkillQueueParser(queueUrl.openStream());
        parser.parseDocument();
        parser.printQueue();
    }
}
