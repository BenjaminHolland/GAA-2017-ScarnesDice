package csumb2017.holland.ben.gaa_2017_scarnesdice;

import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Benjamin on 3/4/2017.
 */

public class ScarnesGame {
    private final Random chaos=new Random();
    private final MainActivity appContext;
    private TurnSpec turn;
    private final ScarnesPlayer human;
    private final ScarnesPlayer ai;

    public void enableInteratcion(){
        appContext.enableInteraction();
    }

    public void disableInteraction(){
       appContext.disableInteraction();
    }

    public void invokeRollForCurrentPlayer(){
        appContext.pressRollButton();
    }
    public void invokeHoldForCurrentPlayer(){
        appContext.pressHoldButton();
    }
    public TurnSpec getTurn(){
        return turn;
    }

    public Random getChaos(){
        return chaos;
    }
    public Boolean handleRoll(){
        Integer roll=1+chaos.nextInt(6);
        appContext.setDieImage(roll);
        if(roll==1){
            getCurrentPlayer().setScore(0);
            invokeHoldForCurrentPlayer();

            appContext.updateScores(human.getScore(),ai.getScore());
            return false;
        }else{
            getCurrentPlayer().setScore(getCurrentPlayer().getScore()+roll);
            appContext.updateScores(human.getScore(),ai.getScore());
            return true;
        }
    }

    private void handleHold(){
        transitionToNextPlayer();
    }

    private void handleReset(){
        human.setScore(0);
        ai.setScore(0);
        appContext.updateScores(0,0);
        if(turn!=TurnSpec.Human){
            transitionToNextPlayer();
        }
    }

    private void transitionToNextPlayer(){
        getCurrentPlayer().endTurn();
        switch (turn){
            case Ai:
                turn=TurnSpec.Human;
                break;
            case Human:
                turn=TurnSpec.Ai;
                break;
        }
        getCurrentPlayer().beginTurn();
    }
    private ScarnesPlayer getCurrentPlayer(){
        switch (turn){
            case Ai:
                return ai;
            case Human:
                return human;
            default:
                throw new Error("Assertion Failure.");
        }
    }

    public ScarnesGame(MainActivity appContext,ScarnesPlayer ai) {
        this.appContext=appContext;
        this.human=new ScarnesHumanPlayer(this);
        this.ai=new ScarnesAiPlayerRandom(this);
        this.turn=TurnSpec.Human;

        appContext.setRollHandler(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRoll();
            }
        });
        appContext.setHoldHandler(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleHold();
            }
        });

        appContext.setResetHandler(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleReset();
            }
        });
    }

}
