package tema_fin;
public class Planete {
	 String planeta;
	private float x;
	private float y;
	private float z;
	public Planete(String planeta,float x, float y, float z)
	{
		super();
		this.planeta=planeta;
		this.x=x;
		this.y=y;
		this.z=z;
		
	}
	public String getPlaneta() {
		return planeta;
	}
	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	public String toString() { 
		return "Planeta[" + planeta + "]" + "( " + x + " ," + y + " ," + z + ")"; 
	}
}