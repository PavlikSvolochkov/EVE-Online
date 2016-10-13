package logic;

public class ServerStatus {

    private int players;
    private String status;
    private String currentTime;
    private String cachedUntil;

    public ServerStatus() {
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCachedUntil() {
        return cachedUntil;
    }

    public void setCachedUntil(String cachedUntil) {
        this.cachedUntil = cachedUntil;
    }
}
