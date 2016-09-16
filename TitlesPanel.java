/*
 * Decompiled with CFR 0_115.
 */
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TitlesPanel
extends JPanel
implements ActionListener {
    private Graphics2D g2d;
    private Timer animation;
    private boolean is_done = true;
    private int start_angle = 0;
    private int shape;
    private String TypeOfChoiseFigure;
    private int BorderThickness;
    private boolean Gradient;
    private boolean ColorRed;
    private boolean SmalVariantOfTypeParametrs;

    public TitlesPanel(String _TypeOfChoiseFigure, int _BorderThickness)
    {        
    	this.SmalVariantOfTypeParametrs = true;
        this.TypeOfChoiseFigure = _TypeOfChoiseFigure;
        this.BorderThickness = _BorderThickness;
        this.animation = new Timer(50, this);
        this.animation.setInitialDelay(50);
        this.animation.start();
    }
    public TitlesPanel(String _TypeOfChoiseFigure, int _BorderThickness, boolean _Gradient, boolean _ColorRed)
    {        
    	this.SmalVariantOfTypeParametrs = false;
    	this.ColorRed = _ColorRed;
    	this.Gradient = _Gradient;
        this.TypeOfChoiseFigure = _TypeOfChoiseFigure;
        this.BorderThickness = _BorderThickness;
        this.animation = new Timer(50, this);
        this.animation.setInitialDelay(50);
        this.animation.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (this.is_done) {
            this.repaint();
        }
    }

    private void doDrawing(Graphics g) {
        this.is_done = false;
        this.g2d = (Graphics2D)g;
        this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension size = this.getSize();
        Insets insets = this.getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        if (this.SmalVariantOfTypeParametrs == true)       
        {        
        	ShapeFactory shape = new ShapeFactory(this.TypeOfChoiseFigure, this.BorderThickness);        
        
        this.g2d.setStroke(shape.stroke);
        this.g2d.setPaint(shape.paint);
              
        double angle = this.start_angle++;
        if (this.start_angle > 360) {
            this.start_angle = 0;
        }
        double dr = 90.0 / ((double)w / ((double)shape.width * 1.5));
        int j = shape.height;
        while (j < h) {
            int i = shape.width;
            while (i < w) {
                angle = angle > 360.0 ? 0.0 : angle + dr;
                AffineTransform transform = new AffineTransform();
                transform.translate(i, j);
                transform.rotate(Math.toRadians(angle));
                this.g2d.draw(transform.createTransformedShape(shape.shape));
                i = (int)((double)i + (double)shape.width * 1.5);
            }
            j = (int)((double)j + (double)shape.height * 1.5);
        }
        }
        else
        {
              	ShapeFactory shape = new ShapeFactory(this.TypeOfChoiseFigure, this.BorderThickness, this.Gradient, this.ColorRed); 
                this.g2d.setStroke(shape.stroke);
                this.g2d.setPaint(shape.paint);
                      
                double angle = this.start_angle++;
                if (this.start_angle > 360) {
                    this.start_angle = 0;
                }
                double dr = 90.0 / ((double)w / ((double)shape.width * 1.5));
                int j = shape.height;
                while (j < h) {
                    int i = shape.width;
                    while (i < w) {
                        angle = angle > 360.0 ? 0.0 : angle + dr;
                        AffineTransform transform = new AffineTransform();
                        transform.translate(i, j);
                        transform.rotate(Math.toRadians(angle));
                        this.g2d.draw(transform.createTransformedShape(shape.shape));
                        i = (int)((double)i + (double)shape.width * 1.5);
                    }
                    j = (int)((double)j + (double)shape.height * 1.5);
                }
        }
        this.is_done = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.doDrawing(g);
    }
}

