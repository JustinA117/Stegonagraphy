import java.awt.Color;
import java.util.ArrayList;
import java.awt.Point; 


public class Stegonography {
public static void clearLow(Pixel p) {
    
    int numRed = p.getRed();
    int numGreen = p.getGreen();
    int numBlue = p.getBlue();
    numRed = (numRed /4)*4;
    numGreen = (numGreen /4)*4;
    numBlue = (numBlue /4)*4;
    p.setRed(numRed);
    p.setGreen(numGreen);
    p.setBlue(numBlue);
}
public static Picture testClearLow(Picture p)
{
    Picture pictureThing = new Picture(p);
        Pixel [][] pixels = pictureThing.getPixels2D();
        for(int r = 0; r < pixels.length; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                   Stegonography.clearLow(pixels[r][c]);

                }



        }
   
    return pictureThing;
}
 public static void setLow (Pixel p, Color c){
 clearLow(p);
     //clears the 6 rightmost bits from the color
  int  numRed = (c.getRed() /64);
   int numGreen = (c.getGreen() /64);
  int  numBlue = (c.getBlue() /64);
   
    p.setRed(p.getRed()+numRed);
    p.setGreen(p.getGreen()+numGreen);
    p.setBlue(p.getBlue()+numBlue);
}
public static Picture testSetLow(Picture p, Color col)
{
    Picture pictureYes = new Picture(p);
        Pixel [][] pixels = pictureYes.getPixels2D();
        for(int r = 0; r < pixels.length; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                   Stegonography.setLow(pixels[r][c], col);
                }
        }
   return pictureYes;
}
public static Picture revealPicture(Picture hidden) 
{ 
Picture copy = new Picture(hidden); 
Pixel[][] pixels = copy.getPixels2D();
Pixel[][] source = hidden.getPixels2D(); 
for (int r = 0; r < pixels.length; r++)
{ 
for (int c = 0; c < pixels[0].length; c++)
{ 	
Color col = source[r][c].getColor();
 //Code for revealPicture
pixels[r][c].setRed((col.getRed() % 4) * 64); 
pixels[r][c].setGreen((col.getGreen() % 4) * 64); 
pixels[r][c].setBlue((col.getBlue() % 4) * 64); 
// % 4 gets the leftmost 2 bits and times it by 64 to clear the rest of it

}
		}
return copy; 
}
public static boolean canHide (Picture source, Picture secret) {
    if(source.getHeight() >= secret.getHeight() && source.getWidth() >= secret.getWidth()){
       return true;  
    }
   else{
       return false;
   }
}

public static Picture hidePicture(Picture source, Picture secret) {
Picture mySource = new Picture(source);
Picture mySecret = new Picture(secret);
Pixel[][] pixelMySource = mySource.getPixels2D();
Pixel[][] pixelMySecret = mySecret.getPixels2D();
for (int rows = 0; rows < pixelMySource.length; rows++)
{
for(int cols = 0; cols < pixelMySource[rows].length; cols++){
    clearLow(pixelMySource[rows][cols]);
    setLow(pixelMySource[rows][cols], pixelMySecret[rows][cols].getColor());

}
return mySource;
}
}

public static Picture hidePicture2(Picture source, Picture secret, int staRow, int staCol){
Picture mySource = new Picture(source);
Picture mySecret = new Picture(secret);
Pixel[][] pixelMySource = mySource.getPixels2D();
Pixel[][] pixelMySecret = mySecret.getPixels2D();
for(int rows = staRow, i = 0; rows < pixelSourceCopy.length && i < pixelSecretCopy.length; i++){
  for (int cols = staCol, c = 0; cols< pixelSourceCopy[0].length && c < pixelSecretCopy[0].length; c++){
    setLow(pixelSourceCopy[rows][cols], pixelSecretCopy[r][c].getColor()); 
  }
} 
  return sourceCopy; 
}
public static isSameI(Picture picture1, Picture picture2){
  Picture pic1 = new Picture (picture1);
  Picture pic2 = new Picture (picture2); 

    Pixel [][] pixel1Pic = pixel1Pic.getPixels2D(); 
    Pixel [][] pixel2Pic = pixel2Pic.getPixels2D(); 
     for(int rows = 0, r = 0; rows < pixel1Copy.length && r < pixel2Copy.length; rows++, r++){
                for (int cols = 0, c = 0; cols < pixel1Copy[0].length && c < pixel2Copy[0].length; cols++, c++){
         if(pixel1Pic[rows][cols].equals((pixel2Pic[rows][cols]))){
                        return true; 
  }
    else {
      return false; 
    }

 //end of main   V   
}

   }

}


// have to use pictures as parameters because the method is taking in pictures 
  public static ArrayList<Points> findDifferences(Picture One, Picture two){

  }
}

