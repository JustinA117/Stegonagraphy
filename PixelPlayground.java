import java.awt.Color;

public class PixelPlayground {
 
    public static Picture zeroBlue(Picture p) {
        
        Picture newPic = new Picture(p);

        Pixel [][] pixels = newPic.getPixels2D();

        for(int r = 0; r < pixels.length; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                    pixels[r][c].setBlue(0);

                }



        }
        
        return newPic;

    }

    public static Picture keepOnlyBlue (Picture a){
        Picture myPic = new Picture(a);
        Pixel [][] pixels = myPic.getPixels2D();
        for(int r = 0; r < pixels.length; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                    pixels[r][c].setRed(0);
                    pixels[r][c].setGreen(0);

                }



        }
        return myPic;
    }
    public static Picture negatePicture (Picture a){
        Picture ourPic = new Picture(a);
        Pixel [][] pixels = ourPic.getPixels2D();
        for(int r = 0; r < pixels.length; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                    int numRed=pixels[r][c].getRed();
                    int numGreen=pixels[r][c].getGreen();
                    int numBlue=pixels[r][c].getBlue();
                    pixels[r][c].setRed(255-numRed);
                    pixels[r][c].setGreen(255-numGreen);
                    pixels[r][c].setBlue(255-numBlue);
                }



        }
        return ourPic;
    }
    public static Picture greyscalePicture (Picture a){
        Picture hmmPic = new Picture(a);
        Pixel [][] pixels = hmmPic.getPixels2D();
        for(int r = 0; r < pixels.length; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                    int numRed=pixels[r][c].getRed();
                    int numGreen=pixels[r][c].getGreen();
                    int numBlue=pixels[r][c].getBlue();
                    int avgColor= (numBlue + numGreen + numRed)/3;
                    pixels[r][c].setRed(avgColor);
                    pixels[r][c].setGreen(avgColor);
                    pixels[r][c].setBlue(avgColor);
                }



        }
        return hmmPic;
    }
    public static Picture horizonalMirroredImage (Picture a){
        Picture yourPic = new Picture(a);
        Pixel [][] pixels = yourPic.getPixels2D();
        for(int r = 0; r < pixels.length; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                    
                   pixels[r][pixels[0].length-1-c].setColor(pixels[r][c].getColor());
                }
//take the length then find the index of point a and then subtract the index of from the length to gets its mirrored.


        }
        return yourPic;
    }
    public static Picture verticalMirroredImage (Picture a){
        Picture theirPic = new Picture(a);
        Pixel [][] pixels = theirPic.getPixels2D();
        for(int r = 0; r < pixels.length/2; r++)
        {
            //finds the row length. V
                for(int c = 0; c<pixels[0].length; c++)
                {
                    
                   pixels[pixels.length-1-r][c].setColor(pixels[r][c].getColor());
                }
//take the length then find the index of point a and then subtract the index of from the length to gets its mirrored.


        }
        return theirPic;
    }
    public static Picture verticalMirroredImage2 (Picture a){
        Picture okPic = new Picture(a);
        Pixel [][] pixels = okPic.getPixels2D();
        for(int r = 0; r < pixels.length/2; r++)
        {
            //finds the row length. V
            
                for(int c = 0; c<pixels[0].length; c++)
                {
                    
                   pixels[pixels.length-1-r][c].setColor(pixels[r][c].getColor());
                }
//take the length then find the index of point a and then subtract the index of from the length to gets its mirrored.


        }
        return okPic;
    }




public static void main(String[] args){

 

Picture beachPic = new Picture("beach.jpg");

Picture hiddenMsg = new Picture("blueMotorcycle.jpg");
hiddenMsg.explore();
beachPic.explore();

//Picture swanPic = new Picture("swan.jpg");
//swanPic.explore();

//Picture Barb = new Picture("barbaraS.jpg");
//Barb.explore();


//Picture beachPicNoBlue = zeroBlue(beachPic);

//beachPicNoBlue.explore();

//Picture beachOnlyBlue = keepOnlyBlue(beachPic);

//beachOnlyBlue.explore();

//Picture beachNegated = negatePicture(beachPic);

//beachNegated.explore();

//Picture beachMirroredImageHorizonal = horizonalMirroredImage(beachPic);
//beachMirroredImageHorizonal.explore();

//Picture swanMirrored = horizonalMirroredImage(swanPic);
//swanMirrored.explore();

//Picture swanMirroredVert = verticalMirroredImage(swanPic);
//swanMirroredVert.explore();

//Picture greyBeach = greyscalePicture(beachPic);
//greyBeach.explore();

//Picture BarbruhS = Stegonography.testSetLow(beachPic, Color.pink);
//BarbruhS.explore();

//Picture copy3 = Stegonography.revealPicture(BarbruhS);
//copy3.explore(); 

Picture hideThePicture = Stegonography.hidePicture(beachPic, hiddenMsg);
hideThePicture.explore();

Picture revealedPic = Stegonography.revealPicture(hideThePicture);
revealedPic.explore(); 


}
}
 
