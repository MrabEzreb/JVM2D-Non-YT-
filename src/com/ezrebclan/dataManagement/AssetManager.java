package com.ezrebclan.dataManagement;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class AssetManager {

	public static BufferedImage loadImage(URL location) throws IOException {
		return ImageIO.read(location);
	}
	
}
