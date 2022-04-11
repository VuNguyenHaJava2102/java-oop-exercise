// HP 27-12-2021 16h27m

package StudentManager;

import java.io.Serializable;

public class Mark implements Serializable {

	private static final long serialVersionUID = 1L;
	private double math;
	private double physics;
	private double chemistry;
	private double english;
	
	public Mark(double math, double physics, double chemistry, double english) {
		this.math = math;
		this.physics = physics;
		this.chemistry = chemistry;
		this.english = english;
	}

	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}

	public double getPhysics() {
		return physics;
	}
	public void setPhysics(double physics) {
		this.physics = physics;
	}

	public double getChemistry() {
		return chemistry;
	}
	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}

	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}
	
	@Override
	public String toString() {
		return "Mark [Math: " + math
				+ ", Physics: " + physics
				+ ", Chemistry: " + chemistry
				+ ", English: " + english + "]";
	}
	
	public void displayMark() {
		System.out.printf("%-15.2f %-15.2f %-15.2f %.2f\n", math, physics, chemistry, english);
	}
}
