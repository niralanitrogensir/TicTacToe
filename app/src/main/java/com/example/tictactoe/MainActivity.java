package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    //    0-x;
    //    1-O;
    //    2-Null;
    int activePlayer = 0;
    int []gameState={ 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 };
    int [][] winningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;
    public void playTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }
        if(gameState[tappedImage] == 2 && gameActive)
        {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                Button status = findViewById(R.id.statusButton);
                status.setText(R.string.playO);
            }
            else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                Button status = findViewById(R.id.statusButton);
                status.setText(R.string.playX);
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
//        Check if any Player Won
        for (int[] winpostion:winningPosition){
            if(gameState[winpostion[0]] == gameState[winpostion[1]] && gameState[winpostion[1]] == gameState[winpostion[2]] && gameState[winpostion[0]]!=2){
//                SomeOne has Won - find out Who won
                String winnerStr;
                gameActive = false;
                if(gameState[winpostion[0]]==0){
//                    Winner is X
                    winnerStr = "X Has Won The Match";
                }
                else {
//                    Winner is O
                    winnerStr = "O Has Won The Match";
                }

//                Winner announcement
                Button status = findViewById(R.id.statusButton);
                status.setText(winnerStr);
            }
        }
    }
    public void gameReset(View view)
    {
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}