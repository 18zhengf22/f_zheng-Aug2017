//Frank Zheng
//February 26, 2018
public abstract class ThreeDShape {
	private double volume;
	private double surfaceArea;
	public ThreeDShape() {
		this.volume = calcVolume();
		this.surfaceArea = calcSA();
	}
	public abstract double calcVolume();
	public abstract double calcSA();
}