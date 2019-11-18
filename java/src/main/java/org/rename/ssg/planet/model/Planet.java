package org.rename.ssg.planet.model;

import java.util.HashMap;
import java.util.Map;

public class Planet {
	double gOverGEarth, year, distance;
	String name;
	
	static final double[] MERCURY = new double[] { 0.37, 87.96, 56974146d };
	static final double[] VENUS = new double[] { 0.90, 224.68, 25724767d };
	static final double[] EARTH = new double[] { 1.00, 365.26, 0d };
	static final double[] MARS = new double[] { 0.38, 686.98, 48678219d };
	static final double[] JUPITER = new double[] { 2.65, 11.862, 390674710d };
	static final double[] SATURN = new double[] { 1.13, 29.456, 792248270d };
	static final double[] URANUS = new double[] { 1.09, 84.07, 	1692662530d };
	static final double[] NEPTUNE = new double[] { 1.43, 164.81, 2703959960d };
	
	static Map<String, double[]> planetMapper;
	
	static {
		planetMapper = planetMapper = new HashMap<>();
		planetMapper.put("mercury", MERCURY);
		planetMapper.put("venus", VENUS);
		planetMapper.put("earth", EARTH);
		planetMapper.put("mars", MARS);
		planetMapper.put("jupiter", JUPITER);
		planetMapper.put("saturn", SATURN);
		planetMapper.put("uranus", URANUS);
		planetMapper.put("neptune", NEPTUNE);
	}
	
	
	public Planet(String name) {
		this.name = name;
		double[] values = planetMapper.get(this.name); 
		if (values == null) {
			values = EARTH;
			this.name = "earth";
		}
		this.gOverGEarth = values[0];
		this.year = values[1];
		this.distance = values[2];		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	public double getWeight(double weight) {
		return weight * this.gOverGEarth;
	}
	
	public double getAge(double age) {
		return (365.26 / this.year) * age;
	}	
	
	public double getDriveTime(double mph) {
		double hours = this.distance / mph;
		
		double toReturn = hours / (24 * 365.26);
		return toReturn;
	}

}
