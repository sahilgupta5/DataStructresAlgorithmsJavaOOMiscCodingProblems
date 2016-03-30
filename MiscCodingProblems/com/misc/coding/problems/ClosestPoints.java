package com.misc.coding.problems;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Given the xy axis, We have the origin (0,0) and multiple points in the plane.
 * Can you give me the top 100 closest elements.
 * 
 * @author Sahil Gupta
 * 
 */
public class ClosestPoints {

	// The plane which contains all the points that is given to us.
	Point[] points;

	// This will store the elements closest to the top in it's priority queue
	Point[] minBHeap;

	int endInd = 0;

	public static class Point implements Comparable<Point> {
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

		public double getD() {
			return d;
		}

		public void setD(double d) {
			this.d = d;
		}

		int x;
		int y;
		double d;// distance from another point under consideration

		public String toString() {
			return "(" + new String(x + "," + y + "," + d) + ")";
		}

		@Override
		public int compareTo(Point o) {
			if (o.d == this.d) {
				return 0;
			}
			if (o.d > this.d) {
				return -1;
			} else {
				return 1;
			}
		}

	}

	public int getParentIndex(int childIndex) {
		return (int) Math.floor(Math.abs((childIndex - 1) / 2));
	}

	public int getLeftChildIndex(int parentIndex) {
		return (2 * parentIndex) + 1;
	}

	public int getRightChildIndex(int parentIndex) {
		return (2 * parentIndex) + 2;
	}

	public void insertBinaryHeap(Point p) {
		// @formatter:off
		/*
		 * Heapify-up/sift-up Insert the value at the end of the heap and
		 * heapify-up Compare the value with the parent. If value smaller, then
		 * swap. Else, the value at right position.
		 */
		// @formatter:on
		int cur = endInd;
		minBHeap[endInd] = p;
		endInd++;
		while (minBHeap[cur].d < minBHeap[getParentIndex(cur)].d) {
			// swap
			Point temp = minBHeap[cur];
			minBHeap[cur] = minBHeap[getParentIndex(cur)];
			minBHeap[getParentIndex(cur)] = temp;
			cur = getParentIndex(cur);
		}
	}

	public Point deleteBinaryHeap() {
		// @formatter:off
		/*
		 * Heapify-down/sift-down
		 * Get the root to return i.e. index 0.
		 * Swap the element at the end of heap with the first/0th element.
		 * Remove the last index.
		 * Compare the value of the parent with it's children and swap 
		 * with smallest child if the value of parent is greater.
		 * Decrease end index or (size-1) by 1.
		 * Return the value.
		 */
		// @formatter:on
		int cur = 0;
		Point p = minBHeap[cur];
		minBHeap[cur] = minBHeap[endInd - 1];
		minBHeap[endInd - 1] = null;
		endInd--;
		while (cur < endInd
				&& (minBHeap[getLeftChildIndex(cur)].d < minBHeap[cur].d || minBHeap[cur].d < minBHeap[getRightChildIndex(cur)].d)) {
			Point temp;
			if (minBHeap[getLeftChildIndex(cur)].d < minBHeap[cur].d) {
				if (minBHeap[getLeftChildIndex(cur)].d < minBHeap[getRightChildIndex(cur)].d) {
					temp = minBHeap[getLeftChildIndex(cur)];
					minBHeap[getLeftChildIndex(cur)] = minBHeap[cur];
					minBHeap[cur] = temp;
					cur = getLeftChildIndex(cur);
				} else {
					temp = minBHeap[getRightChildIndex(cur)];
					minBHeap[getRightChildIndex(cur)] = minBHeap[cur];
					minBHeap[cur] = temp;
					cur = getRightChildIndex(cur);
				}
			} else {
				if (minBHeap[cur].d < minBHeap[getRightChildIndex(cur)].d) {
					if (minBHeap[getRightChildIndex(cur)].d < minBHeap[getLeftChildIndex(cur)].d) {
						temp = minBHeap[getRightChildIndex(cur)];
						minBHeap[getRightChildIndex(cur)] = minBHeap[cur];
						minBHeap[cur] = temp;
						cur = getRightChildIndex(cur);
					} else {
						temp = minBHeap[getLeftChildIndex(cur)];
						minBHeap[getLeftChildIndex(cur)] = minBHeap[cur];
						minBHeap[cur] = temp;
						cur = getLeftChildIndex(cur);
					}
				}
			}
		}

		return p;
	}

	public double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
	}

	// public double[] distanceBetweenPointsFromCenter(Point[] plane, Point
	// center) {
	// double D[] = new double[plane.length];
	// for (int i = 0; i < plane.length; i++) {
	// D[i] = getDistance(plane[i], center);
	// }
	// return D;
	// }
	//
	// public double[] get100ClosestPointsToOrigin(Point[] plane) {
	// Point origin = new Point(0, 0);
	// double D[] = new double[plane.length];
	// D = distanceBetweenPointsFromCenter(plane, origin);
	// return D;
	// }

	public static void main(String args[]) {
		ClosestPoints cp = new ClosestPoints();
		/*
		 * Prepare test case
		 */
		cp.points = new Point[10];
		cp.minBHeap = new Point[10];

		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		int x, y;
		double D;
		Random r = new Random();
		for (int i = 0; i < cp.points.length; i++) {
			x = r.nextInt(30);
			y = r.nextInt(30);
			Point p = new Point(x, y);
			D = cp.getDistance(p, new Point(0, 0));
			p.d = D;
			cp.points[i] = p;
		}

		for (Point p : cp.points) {
			System.out.println(p.toString());
			cp.insertBinaryHeap(p);
			pq.add(p);
		}

		System.out.println("\n\n");

		for (Point q : cp.minBHeap)
			System.out.println(q.toString());

		System.out.println("\n\n");

		int size = pq.size();
		for (int i = 0; i < size; i++) {
			System.out.println(pq.poll());
		}
		System.out.println("\n\n");

		for (int i = 0; i < size; i++) {
			System.out.println(cp.deleteBinaryHeap());
		}

		// double[] d = cp.get100ClosestPointsToOrigin(cp.points);
	}
}
