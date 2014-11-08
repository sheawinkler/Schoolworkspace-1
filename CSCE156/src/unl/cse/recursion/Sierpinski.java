package unl.cse.recursion;

//this program draws Sierpinski triangles every time you click the screen
import java.applet.*;
import java.awt.*;

public class Sierpinski extends Applet
{
	Graphics g;
	Point a1,b1,c1, a2,b2,c2, a3,b3,c3;

	int depth = 0;

	public void init()
	{
		setBackground(new Color(0,0,0)); //black
	}

	//this handles the mouse operations, every time you left click it steps up one depth
	//every time you right click it steps down one depth
	public boolean mouseDown(Event click, int x, int y)
	{
		if (!click.metaDown()) depth += 1;
		else if (depth>0) depth -= 1;
		repaint();
		return true;
	}

	//draws first triangle
	public void paint(Graphics tri)
	{
		int xCoords[] = {10, 390, 200};
		int yCoords[] = {390, 390, 10};
		tri.setColor(new Color(255, 0, 0));
		tri.drawPolygon(xCoords, yCoords, 3);

		drawTriangle(tri, new Point(10,390),new Point(390,390),new Point(200,10), depth);
	}

	public void drawTriangle(Graphics g, Point a, Point b, Point c, int depth)
	{
		if (depth==0) return;

		depth -= 1;

		Color color = null;
		if(depth % 3 == 0)
			color = new Color(255, 0, 0);
		else if(depth % 3 == 1)
			color = new Color(0, 255, 0);
		else if(depth % 3 == 2)
			color = new Color(0, 0, 255);
		g.setColor(color);

		
	     int xCoords[] = {c.x, (c.x+b.x)/2, (a.x+c.x)/2};
	     int yCoords[] = {b.y, (c.y+a.y)/2, (c.y+a.y)/2};

	     g.drawPolygon(xCoords, yCoords, 3);

	     a1 = a;
	     b1 = new Point(c.x, b.y);
	     c1 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
	     drawTriangle(g, a1, b1, c1, depth);
	
	     a2 = new Point(c.x, b.y);
	     b2 = b;
	     c2 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
	     drawTriangle(g, a2, b2, c2, depth);
	
	     a3 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
	     b3 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
	     c3 = c;
	     drawTriangle(g, a3, b3, c3, depth);
	}
}