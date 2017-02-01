package ru.tsk.eveonline.logic;

public class APIKey {

    public static String API_KEY = "?keyID=5040468";
    public static String vCODE = "&vCODE=Dw46k2jB9N5MHe15BcTdpBumTKFpBauFWP2eoWk3hRoPUn4zLKPmJuaMmbIfEoro";
    private static String accessMask = "";
    private static String type = "";
    private static String expires = "";

    public static String getApiKey() {
        return API_KEY;
    }

    public static void setApiKey(String apiKey) {
        API_KEY = apiKey;
    }

    public static String getvCODE() {
        return vCODE;
    }

    public static void setvCODE(String vCODE) {
        APIKey.vCODE = vCODE;
    }

    public static String getAccessMask() {
        return accessMask;
    }

    public static void setAccessMask(String accessMask) {
        APIKey.accessMask = accessMask;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        APIKey.type = type;
    }

    public static String getExpires() {
        return expires;
    }

    public static void setExpires(String expires) {
        APIKey.expires = expires;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("APIKey{");
        sb.append("ApiKey: " + API_KEY);
        sb.append("vCode: " + vCODE);
        sb.append("AccessMask: " + accessMask);
        sb.append("Type: " + type);
        sb.append("Expires: " + expires);
        sb.append('}');
        return sb.toString();
    }
}
