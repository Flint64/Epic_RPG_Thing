package example.epic_rpg_thing;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class newCharacterActivity extends AppCompatActivity {

    /*
    * Further notes:
    * Dexterity should probably increase critical hit chance
    * Dexterity and how it affects dodge chance should probably be a % based on the dexterity
    * Possibly the same as the above but with how strength affects damage
    * There needs to be a cap on how high you can increase stats; Can be fixed by treating it like D&D point buy (ie increasing point cost the more you spend in one place)
    * (I have the logic already done for a point buy system)
    * Need to figure out how much each point increases a stat
    * Just STR, DEX, HP and MP? Any other stats we need to add?
    *
    * Also, NONE of this is currently tied to a class. Those aren't even implemented here yet. On
    * submition of the new character, the values here should be set to their respectve classes.
    */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);

        //QOL: This just capitalizes the first word when entering text
        TextView txtCapitalize = findViewById(R.id.characterName);
        txtCapitalize.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        //This adds a black border around each of the 4 class choice buttons
        final ImageButton clericButton = findViewById(R.id.clericButton);
        final ImageButton warriorButton = findViewById(R.id.warriorButton);
        final ImageButton rogueButton = findViewById(R.id.rogueButton);
        final ImageButton mageButton = findViewById(R.id.mageButton);

        //TODO: Not sure what exactly this is needed for, might have to rework if this isn't a good way of doing things
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            clericButton.setBackground(getDrawable(R.drawable.black_border));
            warriorButton.setBackground(getDrawable(R.drawable.black_border));
            rogueButton.setBackground(getDrawable(R.drawable.black_border));
            mageButton.setBackground(getDrawable(R.drawable.black_border));
        }

        /***********************************************************************************
         *  These next 4 listeners let you select a class button and will change the displayed
         *  stats based on the class selection.
         *  //TODO: Will have to set the values back to the default when changing class to prevent issues
         ************************************************************************************/
        clericButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    displayInfo("cleric");
            }});

        warriorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    displayInfo("warrior");
            }});

        mageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    displayInfo("mage");
            }});

        rogueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayInfo("rogue");
            }});
    }

    /***********************************************************************************
     *  DisplayInfo - Displays the current class information on screen via the class
     *  selection imageButtons
     ************************************************************************************/
     @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
     public void displayInfo(String choice){
         TextView classLabel = findViewById(R.id.level_class_label);
         String classText;

         final ImageButton clericButton = findViewById(R.id.clericButton);
         final ImageButton warriorButton = findViewById(R.id.warriorButton);
         final ImageButton rogueButton = findViewById(R.id.rogueButton);
         final ImageButton mageButton = findViewById(R.id.mageButton);

         final TextView healthLabel = findViewById(R.id.healthLabel);
         final TextView manaLabel = findViewById(R.id.manaLabel);
         final TextView strengthLabel = findViewById(R.id.strengthLabel);
         final TextView dexterityLabel = findViewById(R.id.dexterityLabel);

         final TextView healthValue = findViewById(R.id.healthValue);
         final TextView manaValue = findViewById(R.id.manaValue);
         final TextView strengthValue = findViewById(R.id.strengthValue);
         final TextView dexterityValue = findViewById(R.id.dexterityValue);

         //Sets all of the borders to black. Is changed to red when choice is made
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
             warriorButton.setBackground(getDrawable(R.drawable.black_border));
             clericButton.setBackground(getDrawable(R.drawable.black_border));
             rogueButton.setBackground(getDrawable(R.drawable.black_border));
             mageButton.setBackground(getDrawable(R.drawable.black_border));
         }

         switch (choice){
             case "cleric":
                 clericButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Cleric";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(100));
                 manaValue.setText(String.valueOf(50));
                 strengthValue.setText(String.valueOf(6));
                 dexterityValue.setText(String.valueOf(3));
             break;

             case "mage":
                 mageButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Mage";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(75));
                 manaValue.setText(String.valueOf(100));
                 strengthValue.setText(String.valueOf(2));
                 dexterityValue.setText(String.valueOf(5));
              break;

             case "warrior":
                 warriorButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Warrior";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(120));
                 manaValue.setText(String.valueOf(20));
                 strengthValue.setText(String.valueOf(10));
                 dexterityValue.setText(String.valueOf(1));
             break;

             case "rogue":
                 rogueButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Rogue";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(80));
                 manaValue.setText(String.valueOf(20));
                 strengthValue.setText(String.valueOf(5));
                 dexterityValue.setText(String.valueOf(10));
             break;
         }
         //Displays the hidden textViews
         classLabel.setVisibility(View.VISIBLE);
         healthLabel.setVisibility(View.VISIBLE);
         manaLabel.setVisibility(View.VISIBLE);
         strengthLabel.setVisibility(View.VISIBLE);
         dexterityLabel.setVisibility(View.VISIBLE);
         healthValue.setVisibility(View.VISIBLE);
         manaValue.setVisibility(View.VISIBLE);
         strengthValue.setVisibility(View.VISIBLE);
         dexterityValue.setVisibility(View.VISIBLE);


     }

}
