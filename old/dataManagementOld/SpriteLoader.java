package com.ezrebclan.dataManagement;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class SpriteLoader {

	public static BufferedImage getSprite(BufferedImage spritesheet, Point pos) {
		return spritesheet.getSubimage(pos.x, pos.y, 16, 16);
	}
}
