package edu.rosehulman.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends Activity {

    private Button[][] mTicTacToeButtons;
    private TextView mGameStateTextView;
    private TicTacToeGame mGame;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mTicTacToeButtons = new Button[TicTacToeGame.NUM_ROWS][TicTacToeGame.NUM_COLUMNS];

        mTicTacToeButtons[0][0] = (Button) findViewById(R.id.button00);
        mTicTacToeButtons[0][1] = (Button) findViewById(R.id.button01);
        mTicTacToeButtons[0][2] = (Button) findViewById(R.id.button02);
        mTicTacToeButtons[1][0] = (Button) findViewById(R.id.button10);
        mTicTacToeButtons[1][1] = (Button) findViewById(R.id.button11);
        mTicTacToeButtons[1][2] = (Button) findViewById(R.id.button12);
        mTicTacToeButtons[2][0] = (Button) findViewById(R.id.button20);
        mTicTacToeButtons[2][1] = (Button) findViewById(R.id.button21);
        mTicTacToeButtons[2][2] = (Button) findViewById(R.id.button22);

        mGameStateTextView = (TextView) findViewById(R.id.gameState);

        // Add listeners to the buttons
        for (int row = 0; row < TicTacToeGame.NUM_ROWS; row++) {
            for (int column = 0; column < TicTacToeGame.NUM_COLUMNS; column++) {
                mTicTacToeButtons[row][column].setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                        case R.id.newGame:
                            mGame.resetGame();
                            break;
                        case R.id.button00:
                            mGame.pressedButtonAtLocation(0, 0);
                            break;
                        case R.id.button01:
                            mGame.pressedButtonAtLocation(0, 1);
                            break;
                        case R.id.button02:
                            mGame.pressedButtonAtLocation(0, 2);
                            break;
                        case R.id.button10:
                            mGame.pressedButtonAtLocation(1, 0);
                            break;
                        case R.id.button11:
                            mGame.pressedButtonAtLocation(1, 1);
                            break;
                        case R.id.button12:
                            mGame.pressedButtonAtLocation(1, 2);
                            break;
                        case R.id.button20:
                            mGame.pressedButtonAtLocation(2, 0);
                            break;
                        case R.id.button21:
                            mGame.pressedButtonAtLocation(2, 1);
                            break;
                        case R.id.button22:
                            mGame.pressedButtonAtLocation(2, 2);
                            break;
                        }
                        
                        updateDisplay();
                    }

                });
            }
        }

        ((Button) findViewById(R.id.newGame)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mGame = new TicTacToeGame(TicTacToeActivity.this);

                updateDisplay();
            }

        });

        mGame = new TicTacToeGame(this);
    }
    
    private void updateDisplay() {
        // Update the button text
        for (int row = 0; row < TicTacToeGame.NUM_ROWS; row++) {
            for (int column = 0; column < TicTacToeGame.NUM_COLUMNS; column++) {
                mTicTacToeButtons[row][column].setText(mGame.stringForButtonAtLocation(row,
                        column));
            }
        }

        // Update the game state text view
        mGameStateTextView.setText(mGame.stringForGameState());
    }
}