import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Key {
    
    // image that represents the key's position on the dungeon
    private BufferedImage image;
    // current position of the key on the dungeon grid
    private Point pos;

    public Key(int x, int y) {
        // load the assets
        loadImage();

        // initialize the state
        pos = new Point(x, y);
    }

    private void loadImage() {
        try {
            // you can use just the filename if the image file is in your
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new File("Crawler/lib/images/key.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        // with the Point class, note that pos.getX() returns a double, but 
        // pos.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
        // this is also where we translate dungeon grid position into a canvas pixel
        // position by multiplying by the tile size.
        g.drawImage(
            image, 
            pos.x * Dungeon.TILE_SIZE, 
            pos.y * Dungeon.TILE_SIZE, 
            observer
        );
    }

    public Point getPos() {
        return pos;
    }

}