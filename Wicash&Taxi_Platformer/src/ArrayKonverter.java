import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

import java.util.EmptyStackException;
import java.util.Stack;

public class ArrayKonverter {
	BufferedImage image;
	int height;
	int width;
	
	ArrayKonverter(BufferedImage a){
		this.image = a;
	}
	
	 public static int[][] convertToArray(BufferedImage image)

	 {

	      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	      final int width = image.getWidth();
	      final int height = image.getHeight();
	      final boolean hasAlphaChannel = image.getAlphaRaster() != null;
	      // Hier wird überprüft, wie das Pixels Array aussieht.%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//		     System.out.println("Die Laenge des pixels Arrays ist:" + pixels.length);	   
		     int i = 0;
//		     while(i < pixels.length){
//		    	 System.out.println("Wert des Arrays fuer die " + i + " Stelle: " + pixels[i]);
//		            i++;
//		        }
		     //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	      int[][] result = new int[height][width];
	      if (hasAlphaChannel) {
	         final int pixelLength = 4;
	         for (int pixel = 0, row = 0, col = 0; pixel + 3 < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
	            argb += ((int) pixels[pixel + 1] & 0xff); // blue
	            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
	            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
	            result[row][col] = argb;
	            col++;
	            if (col == width) {
	               col = 0;
	               row++;
	            }
	         }
	      } else {
	         final int pixelLength = 3;
	         for (int pixel = 0, row = 0, col = 0; pixel + 2 < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += 1; // 255 alpha
	            argb += ((int) pixels[pixel]); // blue
	            argb += (((int) pixels[pixel + 1])); // green
	            argb += (((int) pixels[pixel + 2])); // red
	            
	            if (argb == -2) { //Hintergrund "weiß"
	            	result[row][col] = 0;
		            col++;
	            } 
	            else if (argb == 46) { //Farbe "Rot"
	            	result[row][col] = 2;
		            col++;
	            }
	            else if (argb == 5) { //Farbe "Schwarz"
	            	result[row][col] = 1;
		            col++;
	            } 
	            else if (argb == 84) { //Farbe "Blau"
	            	result[row][col] = 3;
		            col++;
	            } 
	            else if (argb == -14) { //Farbe "Gelb"
	            	result[row][col] = 4;
		            col++;
	            } 
	            else if (argb == 32) { //Farbe "Grün"
	            	result[row][col] = 5;
		            col++;
	            } 
	            else {
	            	result[row][col] = 1;
		            col++;
		            
		            
	            }
	            
	            
	            if (col == width) {
	               col = 0;
	               row++;
	               
	            }
	         }
	      }

	      return result;
	   }
	 
	 
	 int[][] giveArray(){
		 
		 return this.convertToArray(image);
		 
		 
	 }
	 
}}