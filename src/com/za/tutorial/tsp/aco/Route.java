package com.za.tutorial.tsp.aco;

import java.util.ArrayList;
import java.util.Arrays;

public class Route {
	private ArrayList<City> cities;
	private double distance;
	public Route (ArrayList<City> cities, double distance) {
		this.cities = cities;
		this.distance = distance;
	}
	public ArrayList<City> getCities() { return cities; }
	public double getDistance() { return distance; }
	public String toString() { return Arrays.toString(cities.toArray()) + " | " + distance;}
	
}
