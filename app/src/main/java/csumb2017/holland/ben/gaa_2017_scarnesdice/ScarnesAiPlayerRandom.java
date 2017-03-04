package csumb2017.holland.ben.gaa_2017_scarnesdice;

/**
 * Created by Benjamin on 3/4/2017.
 */

public class ScarnesAiPlayerRandom extends ScarnesAiPlayer {
    public ScarnesAiPlayerRandom(ScarnesGame gameContext) {
        super(gameContext);
    }

    @Override
    public void beginTurn() {
        super.beginTurn();
        int loops=1+gameContext.getChaos().nextInt(10);
        for(int i=0;i<loops;i++){
            if(!gameContext.handleRoll()){
                break;
            }
        }
    }
}
