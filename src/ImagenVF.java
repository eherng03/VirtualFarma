
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenVF extends JPanel{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image mainImage = null;
    private Image scaledImage = null;
    private int originalW = 789;
    private int originalH = 551;
 
    public ImagenVF(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        mainImage = new ImageIcon("src/Images/LogoVF.png").getImage();
        scaledImage = mainImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // to prevent this method to apply g2d features from preceding methods
        g2d = (Graphics2D) g2d.create();
        // g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
        // RenderingHints.VALUE_RENDER_QUALITY);
        // g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        // RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (scaledImage == null)
            //this way is not possible if you use MVC where your image is represented by your own class in model
//          g2d.drawImage(mainImage, 0, 0, this.getWidth(), this.getHeight(),
//                  Color.white, this);
            g2d.drawImage(mainImage, 0, 0, this);
        else {
            g2d.drawImage(scaledImage, 0, 0, this);
//          g2d.drawImage(scaledImage, 0, 0, this.getWidth(), this.getHeight(),
//                  Color.white, this);
        }
        // to prevent next methods of g2d to use features set to g2d here
        g2d.dispose();
    }

	public int getOriginalW() {
		return originalW;
	}

	public int getOriginalH() {
		return originalH;
	}


}