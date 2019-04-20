package game_package.entity;

import game_package.graphics.Sprite;
import game_package.states.PlayState;
import game_package.util.KeyHandler;
import game_package.util.MouseHandler;
import game_package.util.Vector2f;

import java.awt.*;

public class Player extends Entity {

    public Player(Sprite sprite, Vector2f orgin, int size){
        super(sprite, orgin, size);
    }

    public void update() {
        super.update();
        action();
        move();
        /*
        if ((-0.1 < dx) && (dx > 0.1)) {
            PlayState.map.x += dx;
        }
        if ((-0.1 < dy) && (dy > 0.1)) {
            PlayState.map.y += dy;
        }
        */
        PlayState.map.x += dx;
        PlayState.map.y += dy;
        pos.x += dx;
        pos.y += dy;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(animation.getImage(), (int)(pos.getWorldVar().x), (int)(pos.getWorldVar().y), size,
                    size, null);
    }

    public void input(MouseHandler mouse, KeyHandler key){

//        if (mouse.getButton() == -1) {
//            System.out.println(String.format("Player %s, %s", pos.x, pos.y));
//        }

        if (key.up.isDown){
            up = true;
        } else {
            up = false;
        }
        if (key.left.isDown){
            left = true;
        } else {
            left = false;
        }
        if (key.right.isDown){
            right = true;
        } else {
            right = false;
        }
        if (key.down.isDown){
            down = true;
        } else {
            down = false;
        }
        if (key.action.isDown){
            action = true;
        } else {
            action = false;
        }
    }

    public void action(){
        if (action){
            PlayState.tm.build(pos.x, pos.y, new int[][]{{729, 761, 793}, {730, 762, 794}});
        }
        action = false;
    }

    public void move(){
        if(up) {
            dy -= acc;
            if(dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if(dy < 0) {
                dy += deacc;
                if(dy > 0) {
                    dy = 0;
                }
            }
        }

        if(down) {
            dy += acc;
            if(dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if(dy > 0) {
                dy -= deacc;
                if(dy < 0) {
                    dy = 0;
                }
            }
        }

        if(left) {
            dx -= acc;
            if(dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if(dx < 0) {
                dx += deacc;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }

        if(right) {
            dx += acc;
            if(dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if(dx > 0) {
                dx -= deacc;
                if(dx < 0) {
                    dx = 0;
                }
            }
        }

    }
}
