package ru.tsk.eveonline.logic;

public class ServerStatus {

    private int players;
    private String status;

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

    @Override
    public String toString() {
        return "ServerStatus{" +
                "players=" + players +
                ", status='" + status + '\'' +
                '}';
    }
}
