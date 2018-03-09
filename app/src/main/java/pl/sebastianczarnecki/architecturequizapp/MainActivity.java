package pl.sebastianczarnecki.architecturequizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // int score shows how many good answers were given by a player
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // sumUp method counts final score
    public void sumUpTwo(View view) {

        // check RadioButtons
        RadioButton isWarsaw = (RadioButton) findViewById(R.id.warsaw);
        boolean warsaw = isWarsaw.isChecked();

        RadioButton isWarsawTwo = (RadioButton) findViewById(R.id.warsawtwo);
        boolean warsawTwo = isWarsawTwo.isChecked();

        RadioButton isWarsawThree = (RadioButton) findViewById(R.id.warsawThree);
        boolean warsawThree = isWarsawThree.isChecked();

        // check CheckBoxes
        CheckBox modernismA = (CheckBox) findViewById(R.id.cb_modernismanswer_pl);
        CheckBox postwarmodernismB = (CheckBox) findViewById(R.id.cb_modernismanswer_fr);
        CheckBox powstwarmodernismC = (CheckBox) findViewById(R.id.cb_modernismanswer_usa);


        // this part creates String that was given by a player in EditText field and it turns it to lower case
        EditText openText = (EditText) findViewById(R.id.answer);
        String openAnswer = openText.getText().toString().toLowerCase();

        EditText openName = (EditText) findViewById(R.id.name);
        String openNameAnswer = openName.getText().toString();

        //Using "if" statement, method is counting points. It adds 1 point every time the right answer is given
        if (warsaw) {
            score += 1;
        }

        if (warsawThree) {
            score += 1;
        }

        if (warsawTwo) {
            score += 1;
        }

        if (modernismA.isChecked() && postwarmodernismB.isChecked() && !powstwarmodernismC.isChecked()) {
            score += 1;
        }


        // answer given in text entry need to contain word "le corbusier". Thanks to toLowerCase() method, player receives a point even if he/she types upper case letters.
        if (openAnswer.contains("le corbusier")) {
            score = score + 1;
        }

        // this creates toast message that shows score of a player
        if (score > 4){
            Toast.makeText(this, "Your score: " + score + "/5" + "\n Nice, " + openNameAnswer +"!", Toast.LENGTH_LONG).show();
        }

        if (score > 3){
            Toast.makeText(this, "Your score: " + score + "/5" + "\n Nice, " + openNameAnswer +"!", Toast.LENGTH_LONG).show();
        }

        if (score < 2){
            Toast.makeText(this, "Your score: " + score + "/5" + "\n Try better, " + openNameAnswer, Toast.LENGTH_LONG).show();
        }

        if (score == 2){
            Toast.makeText(this, "Your score: " + score + "/5" + "\n Try better, " + openNameAnswer, Toast.LENGTH_LONG).show();
        }

        if (score == 3){
            Toast.makeText(this, "Your score: " + score + "/5" + "\n pretty nice, " + openNameAnswer, Toast.LENGTH_LONG).show();
        }
        // after toast message, method resets "score" value back to 0.
        score = 0;
    }}
