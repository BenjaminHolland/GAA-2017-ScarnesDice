package csumb2017.holland.ben.gaa_2017_scarnesdice;

import android.os.AsyncTask;

/**
 * Created by Benjamin on 3/4/2017.
 */

public class ScarnesAiPlayerGreedy  extends  ScarnesAiPlayer{
    public ScarnesAiPlayerGreedy(ScarnesGame gameContext) {
        super(gameContext);
    }

    @Override
    public void beginTurn() {
        super.beginTurn();
        while(gameContext.handleRoll()){

        }
    }


}
