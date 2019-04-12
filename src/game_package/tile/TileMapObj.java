package game_package.tile;

import game_package.graphics.Sprite;
import game_package.tile.blocks.Block;
import game_package.tile.blocks.HoleBlock;
import game_package.tile.blocks.NormBlock;
import game_package.tile.blocks.ObjBlock;
import game_package.util.Vector2f;

import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;

public class TileMapObj extends TileMap {

    public static HashMap<String, Block> blocks;

    public TileMapObj(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight,
                       int tileColumns){
        Block tempBlock;
        blocks = new HashMap<String, Block>();


        String[] block = data.split(",");
        for(int i=0; i < (width*height); i++){
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0){
                if (temp == 62)
                    tempBlock = new HoleBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) /
                            tileColumns) ), new Vector2f((int) (i % width) * tileWidth,
                            (int) (i / height) * tileHeight), tileWidth, tileHeight);
                else {
                    tempBlock = new ObjBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) /
                            tileColumns) ), new Vector2f((int) (i % width) * tileWidth,
                            (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }
                blocks.put(String.valueOf((int) (i % width) + "," + String.valueOf((int) (i / height))), tempBlock);
            }
        }
    }

    public void render(Graphics2D grphs){
        for (Block block: blocks.values()){
            block.render(grphs);
        }
    }
}
