package com.misc.coding.problems;

import java.util.Arrays;
import java.util.Random;

public class ClosestPoints {

	Point[] points;

	/**
	 * Given the xy axis, We have the origin (0,0) and multiple points in the
	 * plane. Can you give me the top 100 closest elements.
	 * 
	 * @param args
	 */

	public static class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		int x;
		int y;
	}

	public double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
	}

	public double[] distanceBetweenPointsFromCenter(Point[] plane, Point center) {
		double D[] = new double[plane.length];
		for (int i = 0; i < plane.length; i++) {
			D[i] = getDistance(plane[i], center);
		}
		return D;
	}

	public double[] get100ClosestPointsToOrigin(Point[] plane) {
		Point origin = new Point(0, 0);
		double D[] = new double[plane.length];
		D = distanceBetweenPointsFromCenter(plane, origin);
		return D;
	}

	public static void main(String args[]) {
		ClosestPoints cp = new ClosestPoints();
		/*
		 * Prepare test case
		 */
		cp.points = new Point[500];
		int x, y;
		Random r = new Random();
		for (int i = 0; i < cp.points.length; i++) {
			x = r.nextInt();
			y = r.nextInt();
			cp.points[i] = new Point(x, y);
		}

		/**
		 * Not complete yet and different from requirements. Will implement full
		 * solution soon.
		 */
		double[] d = cp.get100ClosestPointsToOrigin(cp.points);
		for (double a : d)
			System.out.println(a);
	}
}
