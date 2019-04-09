package com.za.tutorial.tsp.aco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;
import com.za.tutorial.util.AtomicDouble;

public class AntColonyOptimization {
	private AtomicDouble[][] phermoneLevelsMatrix = null;
	private double [][] distancesMatrix = null;
	private ArrayList<City> cities = Driver.initialRoute;
	private int citiesSize = Driver.initialRoute.size();
	public AntColonyOptimization() throws IOException {
		initializeDistances();
		initializePhermoneLevels();
	}
	public AtomicDouble[][] getPhermoneLevelsMatrix() { return phermoneLevelsMatrix; }
	public double [][] getDistancesMatrix() { return distancesMatrix; }
	private void initializeDistances() throws IOException {
		distancesMatrix = new double[citiesSize][citiesSize];
		IntStream.range(0,citiesSize).forEach(x -> {
			City cityY = cities.get(x);
			IntStream.range(0,citiesSize).forEach(y -> distancesMatrix[x][y] = cityY.measureDistance(cities.get(y)));
			
		});
	}
	private void initializePhermoneLevels() {
		phermoneLevelsMatrix = new AtomicDouble[citiesSize][citiesSize];
		Random random = new Random();
		IntStream.range(0, citiesSize).forEach(x -> {
			IntStream.range(0, citiesSize).forEach(y -> phermoneLevelsMatrix[x][y] = new AtomicDouble(random.nextDouble()));
		});
	}
}
