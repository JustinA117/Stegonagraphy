import java.awt.Color;



public class PixelPlayground {

public static Picture zeroBlue (Picture p){
Picture newPic = new Picture(p);

// STEP 1 - get 2D array of pixels using existing getPixels2D() method. 
Pixel [][] pixels = newPic.getPixels2D();

//STEP 2- traverse through all pixels(all rows and columns) using for loops 
for (int r = 0; r <pixels.length; r++)
{
for (int c = 0; c<pixels[0].length; c++)
{pixels[r][c].setBlue(0); 
/* for (Pixel[] row: pixels)
{
for (Pixel column: row )
} */
}

// STEP 3 - set blue to 0 using existing setBlue() method

    }
  return newPic; 
  
}
 

public static Picture keepOnlyBlue (Picture a){
    Picture myPic = new Picture(a); 
    Pixel [][] pixels = myPic.getPixels2D(); 
    for (int r = 0; r <pixels.length; r++)
    {
    for (int c = 0; c<pixels[0].length; c++)
    {
        pixels[r][c].setRed(0); 
        pixels[r][c].setGreen(0); 
}
    }
   return myPic;
}

public static Picture negatePicture(Picture a){


Picture ourPic = new Picture(a); 
Pixel [][] pixels = ourPic.getPixels2D(); 
for (int r = 0; r <pixels.length; r++)
{
for (int c = 0; c<pixels[0].length; c++)
{
   int numRed = pixels[r][c].getRed();
   int numGreen = pixels[r][c].getGreen(); 
   int numBlue = pixels [r][c].getBlue(); 
    pixels[r][c].setRed(255- numRed);
    pixels[r][c].setGreen(255- numGreen);
    pixels[r][c].setGreen(255- numBlue);
}   
    }
return ourPic;

}
public static Picture grayScale(Picture a){
    Picture theirPic = new Picture(a); 
    Pixel [][] pixels = theirPic.getPixels2D(); 
    for (int r = 0; r <pixels.length; r++)
    {
    for (int c = 0; c<pixels[0].length; c++)
    {
        pixels[r][c].setRed((pixels[r][c].getRed() +  pixels[r][c].getGreen() + pixels [r][c].getBlue())/3);
        pixels[r][c].setGreen((pixels[r][c].getRed() +  pixels[r][c].getGreen() + pixels [r][c].getBlue())/3); 
        pixels[r][c].setBlue((pixels[r][c].getRed() +  pixels[r][c].getGreen() + pixels [r][c].getBlue())/3); 
    }
}   return theirPic;

}

public static Picture mirrorImageHoiz1(Picture p){
    /** Mirrors left part of image to the right side 
     * 
     * 
     */
    Picture newPic = new Picture (p); // copy p as not to destroy persistent data 
    Pixel [][] pixels = newPic.getPixels2D(); 
    for (int r = 0; r <pixels.length; r++)
    {
    for (int c = 0; c<pixels[0].length/2; c++)
    {
        pixels[r][pixels[0].length-1-c].setColor(pixels[r][c].getColor());

    }
}
return newPic; 

}


public static void main(String[] args)

 {

Picture beachPic = new Picture("beach.jpg");

beachPic.explore();

Picture beachPicNoBlue = zeroBlue(beachPic);

beachPicNoBlue.explore();

Picture beachPicOnlyBlue = keepOnlyBlue(beachPic);
beachPicOnlyBlue.explore();

Picture beachPicNegate = negatePicture(beachPic);
beachPicNegate.explore();

Picture beachPicGrayScale = negatePicture(beachPic);
beachPicGrayScale.explore();

Picture beachPicMirror = mirrorImageHoiz1(beachPic);
beachPicMirror.explore(); 
 }

}

