package fr.utt.if26.ttcash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatException;


public class GameActivity extends AppCompatActivity {

    private String TAG = "GAMEACTIVITY";

    private ImageButton one, two, three, four, five, six, seven, eight, nine, zero, delete, validate,
            button11, button12, button13, button14, button15, button16, button17, button18,
            button21, button22, button23, button24, button25, button26, button27, button28,
            button31, button32, button33, button34, button35, button36, button37, button38,
            button41, button42, button43, button44, button45, button46, button47, button48,
            button51, button52, button53, button54, button55, button56, button57, button58,
            button61, button62, button63, button64, button65, button66, button67, button68,
            button71, button72, button73, button74, button75, button76, button77, button78,
            button81, button82, button83, button84, button85, button86, button87, button88;


    private RelativeLayout clavier;

    private TextView text11, text12, text13, text14, text15, text16, text17, text18, text21, text22,
    text23, text24, text25, text26, text27, text28, text31, text32, text33, text34,
    text35, text36, text37, text38, text41, text42, text43, text44, text45, text46,
    text47, text48, text51, text52, text53, text54, text55, text56, text57, text58,
    text61, text62, text63, text64, text65, text66, text67, text68,
    text71, text72, text73, text74, text75, text76, text77, text78,
    text81, text82, text83, text84, text85, text86, text87, text88;

    private ImageButton[][] array = new ImageButton[8][8];
    private TextView[][] table = new TextView[8][8];
    private int gain = 3000;
    private int i = 0;
    private int j = 0;
    private int number;
    private String numberToString, chosenNumber;
    private Integer[] randomNumber = new Integer[6];
    private Integer[] selectedNumber = new Integer[6];

    private String blueColor = "#6fb8f8";
    private String yellowColor = "#f5fd53";
    private TextView textView;
    private TextView money;
    private CountDownTimer countDownTimer;
    private long secondsNumber;

    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        clavier = (RelativeLayout) findViewById(R.id.clavier);
        one = (ImageButton) findViewById(R.id.one);
        two = (ImageButton) findViewById(R.id.two);
        three = (ImageButton) findViewById(R.id.three);
        four = (ImageButton) findViewById(R.id.four);
        five = (ImageButton) findViewById(R.id.five);
        six = (ImageButton) findViewById(R.id.six);
        seven = (ImageButton) findViewById(R.id.seven);
        eight = (ImageButton) findViewById(R.id.eight);
        nine = (ImageButton) findViewById(R.id.nine);
        zero = (ImageButton) findViewById(R.id.zero);
        delete = (ImageButton) findViewById(R.id.delete);
        validate = (ImageButton) findViewById(R.id.validate);

        button11 = (ImageButton) findViewById(R.id.button11);
        button21 = (ImageButton) findViewById(R.id.button21);
        button31 = (ImageButton) findViewById(R.id.button31);
        button41 = (ImageButton) findViewById(R.id.button41);
        button51 = (ImageButton) findViewById(R.id.button51);
        button61 = (ImageButton) findViewById(R.id.button61);
        button71 = (ImageButton) findViewById(R.id.button71);
        button81 = (ImageButton) findViewById(R.id.button81);

        button12 = (ImageButton) findViewById(R.id.button12);
        button13 = (ImageButton) findViewById(R.id.button13);
        button14 = (ImageButton) findViewById(R.id.button14);
        button15 = (ImageButton) findViewById(R.id.button15);
        button16 = (ImageButton) findViewById(R.id.button16);
        button17 = (ImageButton) findViewById(R.id.button17);
        button18 = (ImageButton) findViewById(R.id.button18);
        button22 = (ImageButton) findViewById(R.id.button22);
        button23 = (ImageButton) findViewById(R.id.button23);
        button24 = (ImageButton) findViewById(R.id.button24);
        button25 = (ImageButton) findViewById(R.id.button25);
        button26 = (ImageButton) findViewById(R.id.button26);
        button27 = (ImageButton) findViewById(R.id.button27);
        button28 = (ImageButton) findViewById(R.id.button28);
        button32 = (ImageButton) findViewById(R.id.button32);
        button33 = (ImageButton) findViewById(R.id.button33);
        button34 = (ImageButton) findViewById(R.id.button34);
        button35 = (ImageButton) findViewById(R.id.button35);
        button36 = (ImageButton) findViewById(R.id.button36);
        button37 = (ImageButton) findViewById(R.id.button37);
        button38 = (ImageButton) findViewById(R.id.button38);
        button42 = (ImageButton) findViewById(R.id.button42);
        button43 = (ImageButton) findViewById(R.id.button43);
        button44 = (ImageButton) findViewById(R.id.button44);
        button45 = (ImageButton) findViewById(R.id.button45);
        button46 = (ImageButton) findViewById(R.id.button46);
        button47 = (ImageButton) findViewById(R.id.button47);
        button48 = (ImageButton) findViewById(R.id.button48);
        button52 = (ImageButton) findViewById(R.id.button52);
        button53 = (ImageButton) findViewById(R.id.button53);
        button54 = (ImageButton) findViewById(R.id.button54);
        button55 = (ImageButton) findViewById(R.id.button55);
        button56 = (ImageButton) findViewById(R.id.button56);
        button57 = (ImageButton) findViewById(R.id.button57);
        button58 = (ImageButton) findViewById(R.id.button58);
        button62 = (ImageButton) findViewById(R.id.button62);
        button63 = (ImageButton) findViewById(R.id.button63);
        button64 = (ImageButton) findViewById(R.id.button64);
        button65 = (ImageButton) findViewById(R.id.button65);
        button66 = (ImageButton) findViewById(R.id.button66);
        button67 = (ImageButton) findViewById(R.id.button67);
        button68 = (ImageButton) findViewById(R.id.button68);
        button72 = (ImageButton) findViewById(R.id.button72);
        button73 = (ImageButton) findViewById(R.id.button73);
        button74 = (ImageButton) findViewById(R.id.button74);
        button75 = (ImageButton) findViewById(R.id.button75);
        button76 = (ImageButton) findViewById(R.id.button76);
        button77 = (ImageButton) findViewById(R.id.button77);
        button78 = (ImageButton) findViewById(R.id.button78);
        button82 = (ImageButton) findViewById(R.id.button82);
        button83 = (ImageButton) findViewById(R.id.button83);
        button84 = (ImageButton) findViewById(R.id.button84);
        button85 = (ImageButton) findViewById(R.id.button85);
        button86 = (ImageButton) findViewById(R.id.button86);
        button87 = (ImageButton) findViewById(R.id.button87);
        button88 = (ImageButton) findViewById(R.id.button88);

        text11 = (TextView) findViewById(R.id.text11);
        text21 = (TextView) findViewById(R.id.text21);
        text31 = (TextView) findViewById(R.id.text31);
        text41 = (TextView) findViewById(R.id.text41);
        text51 = (TextView) findViewById(R.id.text51);
        text61 = (TextView) findViewById(R.id.text61);
        text71 = (TextView) findViewById(R.id.text71);
        text81 = (TextView) findViewById(R.id.text81);
        text12 = (TextView) findViewById(R.id.text12);
        text13 = (TextView) findViewById(R.id.text13);
        text14 = (TextView) findViewById(R.id.text14);
        text15 = (TextView) findViewById(R.id.text15);
        text16 = (TextView) findViewById(R.id.text16);
        text17 = (TextView) findViewById(R.id.text17);
        text18 = (TextView) findViewById(R.id.text18);
        text22 = (TextView) findViewById(R.id.text22);
        text23 = (TextView) findViewById(R.id.text23);
        text24 = (TextView) findViewById(R.id.text24);
        text25 = (TextView) findViewById(R.id.text25);
        text26 = (TextView) findViewById(R.id.text26);
        text27 = (TextView) findViewById(R.id.text27);
        text28 = (TextView) findViewById(R.id.text28);
        text32 = (TextView) findViewById(R.id.text32);
        text33 = (TextView) findViewById(R.id.text33);
        text34 = (TextView) findViewById(R.id.text34);
        text35 = (TextView) findViewById(R.id.text35);
        text36 = (TextView) findViewById(R.id.text36);
        text37 = (TextView) findViewById(R.id.text37);
        text38 = (TextView) findViewById(R.id.text38);
        text42 = (TextView) findViewById(R.id.text42);
        text43 = (TextView) findViewById(R.id.text43);
        text44 = (TextView) findViewById(R.id.text44);
        text45 = (TextView) findViewById(R.id.text45);
        text46 = (TextView) findViewById(R.id.text46);
        text47 = (TextView) findViewById(R.id.text47);
        text48 = (TextView) findViewById(R.id.text48);
        text52 = (TextView) findViewById(R.id.text52);
        text53 = (TextView) findViewById(R.id.text53);
        text54 = (TextView) findViewById(R.id.text54);
        text55 = (TextView) findViewById(R.id.text55);
        text56 = (TextView) findViewById(R.id.text56);
        text57 = (TextView) findViewById(R.id.text57);
        text58 = (TextView) findViewById(R.id.text58);
        text62 = (TextView) findViewById(R.id.text62);
        text63 = (TextView) findViewById(R.id.text63);
        text64 = (TextView) findViewById(R.id.text64);
        text65 = (TextView) findViewById(R.id.text65);
        text66 = (TextView) findViewById(R.id.text66);
        text67 = (TextView) findViewById(R.id.text67);
        text68 = (TextView) findViewById(R.id.text68);
        text72 = (TextView) findViewById(R.id.text72);
        text73 = (TextView) findViewById(R.id.text73);
        text74 = (TextView) findViewById(R.id.text74);
        text75 = (TextView) findViewById(R.id.text75);
        text76 = (TextView) findViewById(R.id.text76);
        text77 = (TextView) findViewById(R.id.text77);
        text78 = (TextView) findViewById(R.id.text78);
        text82 = (TextView) findViewById(R.id.text82);
        text83 = (TextView) findViewById(R.id.text83);
        text84 = (TextView) findViewById(R.id.text84);
        text85 = (TextView) findViewById(R.id.text85);
        text86 = (TextView) findViewById(R.id.text86);
        text87 = (TextView) findViewById(R.id.text87);
        text88 = (TextView) findViewById(R.id.text88);

        textView = (TextView) findViewById(R.id.countdown);
        money = (TextView) findViewById(R.id.money);

        array[0][0] = button12;
        table[0][0] = text12;
        array[0][1] = button13;
        table[0][1] = text13;
        array[0][2] = button14;
        table[0][2] = text14;
        array[0][3] = button15;
        table[0][3] = text15;
        array[0][4] = button16;
        table[0][4] = text16;
        array[0][5] = button17;
        table[0][5] = text17;
        array[0][6] = button18;
        table[0][6] = text18;
        array[0][7] = button11;
        table[0][7] = text11;

        array[1][0] = button22;
        table[1][0] = text22;
        array[1][1] = button23;
        table[1][1] = text23;
        array[1][2] = button24;
        table[1][2] = text24;
        array[1][3] = button25;
        table[1][3] = text25;
        array[1][4] = button26;
        table[1][4] = text26;
        array[1][5] = button27;
        table[1][5] = text27;
        array[1][6] = button28;
        table[1][6] = text28;
        array[1][7] = button21;
        table[1][7] = text21;

        array[2][0] = button32;
        table[2][0] = text32;
        array[2][1] = button33;
        table[2][1] = text33;
        array[2][2] = button34;
        table[2][2] = text34;
        array[2][3] = button35;
        table[2][3] = text35;
        array[2][4] = button36;
        table[2][4] = text36;
        array[2][5] = button37;
        table[2][5] = text37;
        array[2][6] = button38;
        table[2][6] = text38;
        array[2][7] = button31;
        table[2][7] = text31;

        array[3][0] = button42;
        table[3][0] = text42;
        array[3][1] = button43;
        table[3][1] = text43;
        array[3][2] = button44;
        table[3][2] = text44;
        array[3][3] = button45;
        table[3][3] = text45;
        array[3][4] = button46;
        table[3][4] = text46;
        array[3][5] = button47;
        table[3][5] = text47;
        array[3][6] = button48;
        table[3][6] = text48;
        array[3][7] = button41;
        table[3][7] = text41;

        array[4][0] = button52;
        table[4][0] = text52;
        array[4][1] = button53;
        table[4][1] = text53;
        array[4][2] = button54;
        table[4][2] = text54;
        array[4][3] = button55;
        table[4][3] = text55;
        array[4][4] = button56;
        table[4][4] = text56;
        array[4][5] = button57;
        table[4][5] = text57;
        array[4][6] = button58;
        table[4][6] = text58;
        array[4][7] = button51;
        table[4][7] = text51;

        array[5][0] = button62;
        table[5][0] = text62;
        array[5][1] = button63;
        table[5][1] = text63;
        array[5][2] = button64;
        table[5][2] = text64;
        array[5][3] = button65;
        table[5][3] = text65;
        array[5][4] = button66;
        table[5][4] = text66;
        array[5][5] = button67;
        table[5][5] = text67;
        array[5][6] = button68;
        table[5][6] = text68;
        array[5][7] = button61;
        table[5][7] = text61;

        array[6][0] = button72;
        table[6][0] = text72;
        array[6][1] = button73;
        table[6][1] = text73;
        array[6][2] = button74;
        table[6][2] = text74;
        array[6][3] = button75;
        table[6][3] = text75;
        array[6][4] = button76;
        table[6][4] = text76;
        array[6][5] = button77;
        table[6][5] = text77;
        array[6][6] = button78;
        table[6][6] = text78;
        array[6][7] = button71;
        table[6][7] = text71;

        array[7][0] = button82;
        table[7][0] = text82;
        array[7][1] = button83;
        table[7][1] = text83;
        array[7][2] = button84;
        table[7][2] = text84;
        array[7][3] = button85;
        table[7][3] = text85;
        array[7][4] = button86;
        table[7][4] = text86;
        array[7][5] = button87;
        table[7][5] = text87;
        array[7][6] = button88;
        table[7][6] = text88;
        array[7][7] = button81;
        table[7][7] = text81;

        NumberOnClick(one);
        NumberOnClick(two);
        NumberOnClick(three);
        NumberOnClick(four);
        NumberOnClick(five);
        NumberOnClick(six);
        NumberOnClick(seven);
        NumberOnClick(eight);
        NumberOnClick(nine);
        NumberOnClick(zero);
        NumberOnClick(validate);
        NumberOnClick(delete);

        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 6; l++) {
                array[k][l].setColorFilter(Color.WHITE);
            }
        }

        money.setText(gain + "\ndt");

        countDownTimer = new CountDownTimer(120000, 1000) {
            public void onTick(long millisUntilFinished) {
                secondsNumber = millisUntilFinished / 1000;
                long seconds;
                String secondsToString, minutesToString;

                if (secondsNumber % 2 == 0 && secondsNumber < 120) {
                    gain -= 50;
                    money.setText(gain + "\ndt");
                }

                if (secondsNumber == 120) {
                    minutesToString = "02";
                    seconds = secondsNumber - 120;
                    secondsToString = String.valueOf(seconds);
                    if (secondsToString.length() == 1) {
                        secondsToString = "0" + secondsToString;
                    }
                } else if (secondsNumber < 120 && secondsNumber >= 60) {
                    minutesToString = "01";
                    seconds = secondsNumber - 60;
                    secondsToString = String.valueOf(seconds);
                    if (secondsToString.length() == 1) {
                        secondsToString = "0" + secondsToString;
                    }
                } else {
                    minutesToString = "00";
                    seconds = secondsNumber;
                    secondsToString = String.valueOf(seconds);
                    if (secondsToString.length() == 1) {
                        secondsToString = "0" + secondsToString;
                    }
                }
                textView.setText(minutesToString + ":" + secondsToString);
                if (minutesToString.equals("00") && secondsToString.equals("30")) {
                    textView.setTextColor(Color.RED);
                }
            }

            public void onFinish() {
                textView.setText("00:00");
                money.setText("00\ndt");
                setAlertOnLoose("Oups!", "You failed! The correct Number is = " + 9 + numberToString);
            }
        };
        countDownTimer.start();

        number = (int) (100000 + Math.random() * 900000);
        numberToString = String.valueOf(number);

        for (int k = 0; k < 6; k++) {
            randomNumber[k] = Character.getNumericValue(numberToString.charAt(k));
        }

    }

    private void NumberOnClick(final ImageButton button) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button == one) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("1");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == two) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("2");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == three) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("3");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == four) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("4");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == five) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("5");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == six) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("6");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == seven) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("7");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == eight) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("8");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == nine) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("9");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == zero) {
                    try {
                        if (i < 6) {
                            table[j][i].setText("0");
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        showToast("Please Press Ok to validate the number!");
                    }
                } else if (button == validate) {
                    if (i > 5) {
                        chosenNumber = chosenNumberToString();
                        selectedNumber = chosenNumberToArray();
                        compareNumbers();
                        i = 0;
                        j++;
                    } else {
                        showToast("Please enter a correct number!");
                    }
                } else if (button == delete) {

                    if (i == 0) {
                        table[j][i].setText("");
                    } else if (i > 0) {
                        table[j][i - 1].setText("");
                        i--;
                    }
                }
            }
        });
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    private String chosenNumberToString() {
        String temporary = "";
        for (int k = 0; k < 6; k++) {
            temporary += table[j][k].getText().toString();
        }
        return temporary;
    }

    private Integer[] chosenNumberToArray() {
        Integer[] number = new Integer[7];
        for (int k = 0; k < 6; k++) {
            number[k] = Character.getNumericValue(table[j][k].getText().charAt(0));
        }
        return number;
    }

    private void compareNumbers() {

        int counter = 0;
        Integer[] temporaryRandom = new Integer[6];
        for (int k = 0; k < 6; k++) {
            temporaryRandom[k] = randomNumber[k];
        }

        for (int k = 0; k < 6; k++) {
            if (temporaryRandom[k] == selectedNumber[k]) {
                selectedNumber[k] = -1;
                temporaryRandom[k] = -2;
                array[j][k].setColorFilter(Color.parseColor(blueColor));
                //array[j][k].setSelected(true);
                counter++;
            }
        }

        int k = 0;
        while (k < 6) {
            int l = 0;
            while (l < 6) {
                if (temporaryRandom[k] == -2) {
                    l = 7;
                } else if (selectedNumber[l] == temporaryRandom[k] && k != l /*&& !array[j][l].isSelected()*/) {
                    //array[j][l].setSelected(true);
                    array[j][l].setColorFilter(Color.parseColor(yellowColor));
                    selectedNumber[l] = -1;
                    temporaryRandom[k] = -2;
                    l = 7;
                }
                l++;
            }
            k++;
        }

        if (counter == 6) {
            countDownTimer.cancel();
            //long time = 120 - secondsNumber;
            setAlertOnWin("CONGRATULATION!", "YOU WON! Your Score is : " + gain);

        } else if (j == 7) {
            setAlertOnLoose("OUPS!", "YOU FAILED! The correct Number is : 9" + numberToString);
        }
    }

    private void setAlertOnWin(String title, String message) {

        final AlertDialog alert = new AlertDialog.Builder(GameActivity.this).create();
        alert.setCancelable(false);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setButton(alert.BUTTON_NEUTRAL, "Rejouer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                finish();
                startActivity(intent);
            }
        });
        alert.setButton(alert.BUTTON_POSITIVE, "Quitter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.setButton(alert.BUTTON_NEGATIVE, "Enregistrer votre score", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                alertDialog.setCancelable(false);
                LayoutInflater inflater = GameActivity.this.getLayoutInflater();
                View layout = inflater.inflate(R.layout.scoredialog, null);
                alertDialog.setView(layout);
                final EditText playername = layout.findViewById(R.id.nameText);
                final EditText playerprenom = layout.findViewById(R.id.prenomText);
                String name = sharedPreferences.getString("nom", "");
                String prenom = sharedPreferences.getString("prenom", "");
                playername.setText(name);
                playerprenom.setText(prenom);
                ImageButton confirmName = layout.findViewById(R.id.confirmName);
                confirmName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nom = playername.getText().toString();
                        String prenom = playerprenom.getText().toString();
                        //Log.d(TAG, "onClick: " + nom + " " + prenom);
                        if (nom.isEmpty() || prenom.isEmpty() || !nom.matches("[a-zA-Z]+")
                                || !prenom.matches("[a-zA-Z]+") ) {
                            showToast("Enter a valid name and prename");
                        } else {
                            editor.putString("nom", nom);
                            editor.putString("prenom", prenom);
                            editor.commit();
                            setIntentWithExtra(MainActivity.class, nom, prenom, gain);
                        }
                    }
                });
                alertDialog.show();
            }
        });
        alert.show();
    }

    private void setAlertOnLoose(String title, String message) {
        AlertDialog alert = new AlertDialog.Builder(GameActivity.this).create();
        alert.setCancelable(false);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setButton(alert.BUTTON_NEUTRAL, "Rejouer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setIntent(GameActivity.class);
            }
        });
        alert.setButton(alert.BUTTON_POSITIVE, "Quitter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.show();
    }

    private void setIntent(Class className) {
        Intent intent = new Intent(this, className);
        finish();
        startActivity(intent);
    }

    private void setIntentWithExtra(Class className, String name, String prename, int gain) {
        Intent intent = new Intent(this, className);
        intent.putExtra("Name", name);
        intent.putExtra("Prename", prename);
        intent.putExtra("Score", gain);
        finish();
        startActivity(intent);
    }
}

