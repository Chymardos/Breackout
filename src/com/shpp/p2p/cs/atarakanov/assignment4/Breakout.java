package com.shpp.p2p.cs.atarakanov.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

/* Breakout game */
public class Breakout extends WindowProgram {
    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final double PADDLE_WIDTH = 60;
    private static final double PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10; //Can do up to x2 rows

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static final int NTURNS = 3;

    /** Paddle Color*/
    private static final Color PADDLE_COLOR = Color.BLACK;

    /** Bricks row Color */
    private static final Color[] BRICKS_COLOR = {Color.RED,Color.RED, Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW, Color.GREEN, Color.GREEN, Color.CYAN, Color.CYAN};

    public void run() {

        /** Возможно перенести цвет в константы */

        //ball, paddle, brick
        /* You fill this in, along with any subsidiary methods */
        addMouseListeners();
        setupGame();
        playGame();
        buildBricks();
        add_Paddle();
        add_Ball();
    }

    private void setupGame() {

    }

    private void playGame() {
    }

    private void add_Paddle(){
        double paddle_X = getWidth()/2.0 - PADDLE_WIDTH / 2.0;
        double paddle_Y = getHeight() - PADDLE_Y_OFFSET;
        drawRectangle(paddle_X, paddle_Y, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_COLOR);
    }

    private void add_Ball(){
        double ball_X = getWidth()/2.0 - BALL_RADIUS/2.0;
        double ball_Y = getHeight()/2.0 - BALL_RADIUS/2.0;
        GOval ball = new GOval(ball_X, ball_Y, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
        ball.setFilled(true);
        ball.setFillColor(Color.BLACK);
        add(ball);
    }

    private void buildBricks(){
        //i - rows
        //j - cols
        int bricksDefaultColor = 0;

        for (int i=0; i < NBRICK_ROWS; i++){
            bricksDefaultColor++;
            for (int j=0; j < NBRICKS_PER_ROW; j++){

                double brick_X = (BRICK_WIDTH+BRICK_SEP) * j;
                double brick_Y = BRICK_Y_OFFSET + (BRICK_HEIGHT + BRICK_SEP) * i;
                if (i<BRICKS_COLOR.length){
                    drawRectangle(brick_X, brick_Y, BRICK_WIDTH, BRICK_HEIGHT, BRICKS_COLOR[i]);
                }
                else {
                    if (bricksDefaultColor > i) {
                        bricksDefaultColor = bricksDefaultColor - i;
                    }
                    drawRectangle(brick_X, brick_Y, BRICK_WIDTH, BRICK_HEIGHT, BRICKS_COLOR[bricksDefaultColor-1]);

                }




                }

            }
        }

    private void drawRectangle(double x,double y,double width,double height, Color rectColor){
        GRect rectangle = new GRect(x, y, width, height);
        rectangle.setFilled(true);
        rectangle.setColor(rectColor);
        add(rectangle);
    }
    }

