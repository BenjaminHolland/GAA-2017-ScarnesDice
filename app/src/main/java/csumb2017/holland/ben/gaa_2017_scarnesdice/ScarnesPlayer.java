package csumb2017.holland.ben.gaa_2017_scarnesdice;

/**
 * Created by Benjamin on 3/4/2017.
 */

public abstract class ScarnesPlayer {
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    private Integer score;
    protected final ScarnesGame gameContext;
    public ScarnesPlayer(ScarnesGame gameContext){
        this.gameContext=gameContext;
        score=0;
    }
    public abstract void beginTurn();
    public abstract  void endTurn();
}
