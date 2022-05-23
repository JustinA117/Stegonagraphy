import java.awt.Color;


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
    if(source.getHeight() >= secret.getHeight() && source.getWidth() > = secret.getWidth()){
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
}
return mySource;

}

public static Picture hidePicture2(Picture source, Picture secret){
Picture mySource = new Picture(source);
Picture mySecret = new Picture(secret);
Pixel[][] pixelMySource = mySource.getPixels2D();
Pixel[][] pixelMySecret = mySecret.getPixels2D();
for(int )
}
 //end of main   V   
}
