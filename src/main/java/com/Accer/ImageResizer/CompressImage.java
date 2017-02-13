package com.Accer.ImageResizer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class CompressImage {

	private int IMG_WIDTH;
	private int IMG_HEIGHT;

	public boolean imageCompress(int IMG_WIDTH, int IMG_HEIGHT, String location)
	{
		this.IMG_HEIGHT = IMG_WIDTH;
		this.IMG_WIDTH = IMG_WIDTH;
		return resizeImagePassportSize(location);
	}
	
	private  boolean resizeImagePassportSize(String location) {

		try {

			BufferedImage originalImage = ImageIO.read(new File(location));
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
					: originalImage.getType();
			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			ImageIO.write(resizeImageJpg, "jpg", new File(location));

			return true;
		} catch (IOException e) {
			return false;
		}

	}

	private  BufferedImage resizeImage(BufferedImage originalImage,
			int type) {
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
				type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		return resizedImage;
	}

}