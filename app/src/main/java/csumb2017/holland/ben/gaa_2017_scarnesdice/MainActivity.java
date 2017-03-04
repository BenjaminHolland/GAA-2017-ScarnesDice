package csumb2017.holland.ben.gaa_2017_scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ImageView dieImage;
    private ScarnesGame gameContext;
    private Button rollButton;
    private Button holdButton;
    private Button resetButton;
    private LinearLayout buttonsLayout;
    private TextView playerScoreLabel;
    private TextView aiScoreLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton = (Button) findViewById(R.id.btnRoll);
        holdButton = (Button) findViewById(R.id.btnHold);
        resetButton = (Button) findViewById(R.id.btnReset);
        buttonsLayout = (LinearLayout) findViewById(R.id.layoutButtons);
        dieImage = (ImageView) findViewById((R.id.imgDie));
        playerScoreLabel=(TextView)findViewById(R.id.lblPlayerScore);
        aiScoreLabel=(TextView)findViewById((R.id.lblCompScore));
        gameContext = new ScarnesGame(this, null);
    }

    public void updateScores(Integer playerScore,Integer aiScore){
        playerScoreLabel.setText(playerScore.toString());
        aiScoreLabel.setText(aiScore.toString());
    }
    public void setDieImage(Integer value){
        switch (value){
            case 1:
                dieImage.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dieImage.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dieImage.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dieImage.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dieImage.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dieImage.setImageResource(R.drawable.dice6);
                break;
            default:
                throw new Error("Assertion Failure.");
        }
    }
    public void enableInteraction(){
        buttonsLayout.setEnabled(true);
    }
    public void disableInteraction(){

        buttonsLayout.setEnabled(false);
    }
    public void pressRollButton(){
        rollButton.callOnClick();
    }
    public void pressHoldButton(){
        holdButton.callOnClick();
    }
    public void setRollHandler(View.OnClickListener listener){
        rollButton.setOnClickListener(listener);
    }
    public void setHoldHandler(View.OnClickListener listener){
        holdButton.setOnClickListener(listener);
    }
    public void setResetHandler(View.OnClickListener listener){
        resetButton.setOnClickListener(listener);
    }
}
