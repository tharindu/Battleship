package ase.battleship.api;

/**
 * Game class that stores game details. Game ID, etc.
 * @author tharindu
 */
public class Game {
    private String gameId;
    /**
     * Constructs a game with given game id.
     * @param gameId unique id for the game
     */
    public Game(String gameId) {
        this.gameId = gameId;
    }
    /**
     * Returns the unique game id of the game instance.
     * @return game id
     */
    public String getGameId() {
        return gameId;
    }
}
