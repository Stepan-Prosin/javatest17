import java.util.ArrayList;

public class Game {
    ArrayList<Player> playerList = new ArrayList<>();

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = playerSearch(playerName1);
        Player player2 = playerSearch(playerName2);
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }

    public Player playerSearch(String playerName) {

        for (Player player : playerList) { // перебираем все билеты
            if (player.getName().equals(playerName)) { // совпадает аэропорт вылета
                return player;
            }

        }
        throw new NotRegisteredException("Player with name: " + playerName + " not found");
    }
}
