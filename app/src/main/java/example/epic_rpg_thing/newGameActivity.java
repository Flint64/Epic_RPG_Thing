package example.epic_rpg_thing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class newGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
    }

    /***********************************************************************************
     * //TODO: Both of these functions, newCharacter and loadCharacter are going to have to redirect to the select story screen.
     *  I'm going to assume that a character is tied to a specific story, so that on the
     *  main screen, whenever selectContinue is called to load a game, it doesn't have to
     *  worry about selecting a character, as that's already part of that save slot.
     *
     *  That being said, if we still want to allow using the same character in multiple
     *  stories, then the loadCharacter function here is still relevant; There can just
     *  be a list of characters owned by the user, and even if they're currently active
     *  in a story, a copy could be made to use in a new story. This would mean that
     *  each save slot would have to keep track of each individual character's info/
     *  inventory and all that.
     *
     *  A way to possibly simplify this might be to treat the characters how they were in
     *  Neverwinter Nights. After you create a character, you have the option to save that
     *  character. What this does is save the current character info, stats, inv, etc.
     *  to your list of characters, titled like "Name(level)". At any point during
     *  the story that that character is being used, the user can opt to save the character
     *  again, which would then add on to the list of that user's characters (NOT overwriting)
     *  and save it again as "Name(level)". This way characters are tied to stories and yet
     *  independent as well.
     *
     *  /end rant
     ************************************************************************************/


    /***********************************************************************************
     *  CREATE CHARACTER - Takes you to the newCharacterActivity to create a new character
     ************************************************************************************/
     public void createNewCharacter(View view){
         Intent intent = new Intent(this, newCharacterActivity.class);
         startActivity(intent);
     }


    /***********************************************************************************
     *  LOAD CHARACTER - To select a new character. This currently just displays a toast
     *  of "no characters found" until functionality is added
     ************************************************************************************/
     public void loadCharacter(View view){

         //TODO: Add functionality to be able to load a saved character. Will need a list of characters first.

         Context context = getApplicationContext();
         CharSequence text = "No saved characters found";
         int duration = Toast.LENGTH_SHORT;

         Toast toast = Toast.makeText(context, text, duration);
         toast.show();
     }
}
