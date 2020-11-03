import main.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        game.registerPlayer("AA");
        game.registerPlayer("BB");
        game.registerPlayer("CC");
        game.registerPlayer("DD");

        game.start();
    }
}
