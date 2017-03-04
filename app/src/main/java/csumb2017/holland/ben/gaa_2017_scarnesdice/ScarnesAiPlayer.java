package csumb2017.holland.ben.gaa_2017_scarnesdice;

import android.os.AsyncTask;

/**
 * Created by Benjamin on 3/4/2017.
 */

public abstract class ScarnesAiPlayer extends ScarnesPlayer {
    public ScarnesAiPlayer(ScarnesGame gameContext) {
        super(gameContext);
    }

    @Override
    public void endTurn(){

    }
    @Override
    public void beginTurn() {
        gameContext.disableInteraction();
    }

}

