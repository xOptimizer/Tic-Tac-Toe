package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tic_tac_toe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //9 zero
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[] {0,1,2});
        combinationList.add(new int[] {3,4,5});
        combinationList.add(new int[] {6,7,8});
        combinationList.add(new int[] {0,3,6});
        combinationList.add(new int[] {1,4,7});
        combinationList.add(new int[] {2,5,8});
        combinationList.add(new int[] {2,4,6});
        combinationList.add(new int[] {0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(0)){
                    performAction((ImageView) v ,0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(1)){
                    performAction((ImageView) v ,1);
                }
            }
        });

        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(2)){
                    performAction((ImageView) v ,2);
                }
            }
        });

        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(3)){
                    performAction((ImageView) v ,3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(4)){
                    performAction((ImageView) v ,4);
                }
            }
        });

        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(5)){
                    performAction((ImageView) v ,5);
                }
            }
        });

        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(6)){
                    performAction((ImageView) v ,6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(7)){
                    performAction((ImageView) v ,7);
                }
            }
        });

        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(8)){
                    performAction((ImageView) v ,8);
                }
            }
        });


    }

    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);

            if(checkResults()){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this , binding.playerOneName.getText().toString()
                +"is a Winner",MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (totalSelectedBoxes == 9) {

                ResultDialog resultDialog = new ResultDialog(MainActivity.this , "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else{
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else{
            imageView.setImageResource(R.drawable.oimage);

            if(checkResults()){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this , binding.playerTwoName.getText().toString()
                        +"is a Winner",MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (totalSelectedBoxes == 9) {

                ResultDialog resultDialog = new ResultDialog(MainActivity.this , "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else{
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {

        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_border);
        } else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_border);

        }
    }

    private boolean checkResults(){
        boolean response = false;
        for(int i =0; i< combinationList.size();i++){
            final int[] combination =  combinationList.get(i);

            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn &&
            boxPositions[combination[2]]==playerTurn){
                response = true;

            }
        }

        return response;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition]==0){
            response = true;
        }

        return response;

    }

    public void restartMatch(){
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBoxes = 1;


        binding.image1.setImageResource(R.drawable.white_border);
        binding.image2.setImageResource(R.drawable.white_border);
        binding.image3.setImageResource(R.drawable.white_border);
        binding.image4.setImageResource(R.drawable.white_border);
        binding.image5.setImageResource(R.drawable.white_border);
        binding.image6.setImageResource(R.drawable.white_border);
        binding.image7.setImageResource(R.drawable.white_border);
        binding.image8.setImageResource(R.drawable.white_border);
        binding.image9.setImageResource(R.drawable.white_border);
    }


}



