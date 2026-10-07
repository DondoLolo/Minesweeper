package com.USGovernment;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class GameBoard {

    private int[][] board;
    private int numBombs; // total number of bombs in the grid
    private int numFlags; // number of flags REMAINING
    public static final int BOMB = -1;
    private GameplayScreen gameplayScreen;
    private Texture emptyTile;
    private Texture emptyFloorTile;
    private Texture oneTile, twoTile, threeTile, fourTile, fiveTile, sixTile, sevenTile, eightTile;
    private Texture bombTile;
    private Texture flagTile;
    private int tileSize = 25;
    private int xOffset = 50;
    private int yOffset = 600;


    public GameBoard(GameplayScreen gameplayScreen) {
        this.gameplayScreen = gameplayScreen;
        board = new int[16][30];
        numBombs = 50;
        numFlags = numBombs;
        loadGraphics();
        this.placeAllBombs();
    }
    public GameBoard(GameplayScreen gameplayScreen, int numRows, int numCols, int numBombs) {
        this.gameplayScreen = gameplayScreen;
        board = new int[numRows][numCols];
        this.numBombs = numBombs;
        numFlags = this.numBombs;
        loadGraphics();
        this.placeAllBombs();
    }

    private void testBoard() {
        board[0][0] = 11;
        board[0][1] = 12;
        board[0][2] = 13;
        board[0][3] = 14;
        board[0][4] = 15;
        board[0][5] = 16;
        board[1][0] = 17;
        board[1][1] = 18;
        board[1][2] = 9;
        board[1][3] = 21;
        board[1][4] = 10;

    }

    public void draw(SpriteBatch spriteBatch) {

        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int x =  xOffset+(tileSize*c);
                int y = yOffset-(tileSize*r);
                int value = board[r][c];

                if(value <= 8)
                    spriteBatch.draw(emptyTile, x, y);
                else if(value == 9)
                    spriteBatch.draw(bombTile, x, y);
                else if(value == 10)
                    spriteBatch.draw(emptyFloorTile, x, y);
                else if(value == 11)
                    spriteBatch.draw(oneTile, x, y);
                else if(value == 12)
                    spriteBatch.draw(twoTile, x, y);
                else if(value == 13)
                    spriteBatch.draw(threeTile, x, y);
                else if(value == 14)
                    spriteBatch.draw(fourTile, x, y);
                else if(value == 15)
                    spriteBatch.draw(fiveTile, x, y);
                else if(value == 16)
                    spriteBatch.draw(sixTile, x, y);
                else if(value == 17)
                    spriteBatch.draw(sevenTile, x, y);
                else if(value == 18)
                    spriteBatch.draw(eightTile, x, y);
                else if(value >= 19)
                    spriteBatch.draw(flagTile, x, y);

                //temp draw code
                if(value ==-1)
                    spriteBatch.draw(bombTile, x, y);
            }
        }

    }

    private void placeAllBombs() {
        int bombsLeft = numBombs;

        while(bombsLeft > 0) {
            Random rand = new Random();
            int row = rand.nextInt((board.length));
            int col = rand.nextInt((board[0].length));

            if(board[row][col] != -1) {
                board[row][col] = -1;
                bombsLeft --;
            }

        }

    }

    public void loadGraphics() {
        emptyTile = new Texture("emptyTile.jpg");
        emptyFloorTile = new Texture("empty floor.jpg");
        oneTile = new Texture("oneTile.jpg");
        twoTile = new Texture("twoTile.jpg");
        threeTile = new Texture("threeTile.jpg");
        fourTile = new Texture("fourTile.jpg");
        fiveTile = new Texture("fiveTile.jpg");
        sixTile = new Texture("sixTile.jpg");
        sevenTile = new Texture("sevenTile.jpg");
        eightTile = new Texture("eightTile.jpg");
        bombTile = new Texture("bomb.jpg");
        flagTile = new Texture("flagTile.jpg");
    }
}
