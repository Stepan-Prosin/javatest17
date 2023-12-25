import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Player player1 = new Player(
            1,
            "noobhunter",
            25

    );
    Player player2 = new Player(
            15,
            "winner",
            15

    );
    Player player3 = new Player(
            25,
            "newOne",
            15

    );

    @Test
    public void registerTest() {

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        ArrayList<Player> actual = game.getPlayerList();

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void roundCorrectTest() {

        int expected = 1;

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int actual = game.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
        expected = 2;
        actual = game.round(player3.getName(), player1.getName());

        Assertions.assertEquals(expected, actual);
        expected = 0;
        actual = game.round(player3.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void roundNotCorrectTest() {

        int expected = 1;

        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });

    }

}
