package csumb2017.holland.ben.gaa_2017_scarnesdice;

/**
 * Created by Benjamin on 3/4/2017.
 */

public class ScarnesHumanPlayer extends ScarnesPlayer {
    public ScarnesHumanPlayer(ScarnesGame gameContext) {
        super(gameContext);
    }

    @Override
    public void beginTurn() {
        gameContext.enableInteratcion();
    }

    @Override
    public void endTurn() {

    }
}
