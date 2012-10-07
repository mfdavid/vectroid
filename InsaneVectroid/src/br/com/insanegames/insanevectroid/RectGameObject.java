package br.com.insanegames.insanevectroid;

public class RectGameObject extends GameObject {

	public float speed;
	
	public RectGameObject(float x, float y, float width, float height, float speed, int color) {
		this.position = new Position(x,y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.speed = speed;
	}
	
	// This mehod could be way faster/smarter =)
	public Line[] getLines() {
		Line[] lines = new Line[4];
		lines[0] = new Line(position.getX()-width, position.getY()-height, position.getX()-width, position.getY()+height);
		lines[1] = new Line(position.getX()-width, position.getY()-height, position.getX()+width, position.getY()-height);
		lines[2] = new Line(position.getX()+width, position.getY()-height, position.getX()+width, position.getY()+height);
		lines[3] = new Line(position.getX()-width, position.getY()+height, position.getX()+width, position.getY()+height);

		return lines;
	}
	
	public void think() {
		this.position.setY(this.position.getY()+this.speed);
		if (this.position.getY() > 1000) {
			this.position.setY(-this.height);
		}
	}
	
}
