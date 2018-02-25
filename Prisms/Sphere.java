//Frank Zheng
//February 26, 2018
public class Sphere extends ThreeDShape {
	private double radius;
	public Sphere(double radius) {
		super();
		this.radius = radius;
	}
	public double calcSA() {
		return 4 * Math.PI * radius * radius;
	}
	public double calcVolume() {
		return 4/3 * Math.PI * radius * radius * radius;
	}
	
}
