package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameActive =true;
    // 0 - X
    // 1 - o
    int activePlayer =0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
//    state means
//    0 - X
//    1 - o
//    2 - Null
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                         {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }
        if(gameState[tappedImage]==2 && gameActive)
        {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status=findViewById(R.id.status);
                status.setText("O's turn tap to play");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status=findViewById(R.id.status);
                status.setText("X's turn tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
       //check win
        for(int[] winningPositon: winPositions )
        {
            if(gameState[winningPositon[0]]==gameState[winningPositon[1]] && gameState[winningPositon[1]]==gameState[winningPositon[2]] && gameState[winningPositon[0]]!= 2)
            {
    gameActive=false;
//                winner string
                String winnerstr;
                if(gameState[winningPositon[0]]==0)
                {
                    winnerstr="X has won";
                }
                else
                {
                    winnerstr="Y has won";
                }
                //update status bar
                TextView status=findViewById(R.id.status);
                status.setText(winnerstr);
            }
        }
    }
    public void gameReset(View view)
    {
    gameActive=true;
    activePlayer = 0;
    for(int i =0;i<gameState.length;i++)
    {
        gameState[i]=2;
    }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}