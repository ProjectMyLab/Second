/*
 * Decompiled with CFR 0_115.
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShapeFactory {
    public Shape shape;
    public BasicStroke stroke = new BasicStroke(3.0f);
    public Paint paint;
    public int width = 25;
    public int height = 25;

    public ShapeFactory(String TypeOfChoiseFigure, int BorderThickness) 
    {
    	this.stroke = new BasicStroke(BorderThickness);
    	if (TypeOfChoiseFigure == "Hexagon")
    	{
    		this.shape = ShapeFactory.createStar(3, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 2.0);
    	}
    	else if (TypeOfChoiseFigure == "Five-pointed_star") 
    	{
    		this.shape = ShapeFactory.createStar(5, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 4.0);
    	}
    	else if (TypeOfChoiseFigure == "Rectangle") 
    	{
    		this.shape = new Rectangle2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height);
    	}
    	else if (TypeOfChoiseFigure == "Triangle") 
    	{
    		GeneralPath path = new GeneralPath();
            double tmp_height = Math.sqrt(2.0) / 2.0 * (double)this.height;
            path.moveTo((double)((- this.width) / 2), - tmp_height);
            path.lineTo(0.0, - tmp_height);
            path.lineTo((double)(this.width / 2), tmp_height);
            path.closePath();
            this.shape = path;
    	}
    	else if (TypeOfChoiseFigure == "Arc") 
    	{
    		this.shape = new Arc2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height, 30.0, 300.0, 2);
    	}
    	else 
    	{
    		throw new Error("type is nusupported");
    	}        
    }
    public ShapeFactory(String TypeOfChoiseFigure, int BorderThickness, boolean Gradient, boolean ColorRed) 
    {
    	this.stroke = new BasicStroke(BorderThickness);    	
    	if (TypeOfChoiseFigure == "Hexagon")
    	{
    		this.shape = ShapeFactory.createStar(3, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 2.0);
    	}
    	else if (TypeOfChoiseFigure == "Five-pointed_star") 
    	{
    		this.shape = ShapeFactory.createStar(5, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 4.0);
    	}
    	else if (TypeOfChoiseFigure == "Rectangle") 
    	{
    		this.shape = new Rectangle2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height);
    	}
    	else if (TypeOfChoiseFigure == "Triangle") 
    	{
    		GeneralPath path = new GeneralPath();
            double tmp_height = Math.sqrt(2.0) / 2.0 * (double)this.height;
            path.moveTo((double)((- this.width) / 2), - tmp_height);
            path.lineTo(0.0, - tmp_height);
            path.lineTo((double)(this.width / 2), tmp_height);
            path.closePath();
            this.shape = path;
    	}
    	else if (TypeOfChoiseFigure == "Arc") 
    	{
    		this.shape = new Arc2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height, 30.0, 300.0, 2);
    	}
    	else 
    	{
    		throw new Error("type is nusupported");
    	}
       
    	if (Gradient == true) 
    	{
    		this.paint = new GradientPaint(- this.width, - this.height, Color.white, this.width, this.height, Color.gray, true);
    	}  	
    	if (ColorRed == true) 
    	{
    		this.paint = Color.red;
    	}   	   
    }

    private static Shape createStar(int arms, Point center, double rOuter, double rInner) {
        double angle = 3.141592653589793 / (double)arms;
        GeneralPath path = new GeneralPath();
        int i = 0;
        while (i < 2 * arms) {
            double r = (i & 1) == 0 ? rOuter : rInner;
            Point2D.Double p = new Point2D.Double((double)center.x + Math.cos((double)i * angle) * r, (double)center.y + Math.sin((double)i * angle) * r);
            if (i == 0) {
                path.moveTo(p.getX(), p.getY());
            } else {
                path.lineTo(p.getX(), p.getY());
            }
            ++i;
        }
        path.closePath();
        return path;
    }
}

