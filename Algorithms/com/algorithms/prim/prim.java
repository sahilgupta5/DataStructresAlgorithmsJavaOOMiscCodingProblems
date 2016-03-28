package com.algorithms.prim;

public class prim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numNodes = 8;
		int[][] weight = new int[100][100];
		int[] minWeight = new int[100];
		int[] minWeightEdge = new int[100];
		boolean[] inMST = new boolean[100];
		boolean[][] edgeMST = new boolean[100][100];
		int minWeightAll, minWeightNode;
		int sumWeight = 0;

		// initialize arrays
		for (int i = 1; i <= numNodes; i++) {
			inMST[i] = false;
			for (int j = 1; j <= numNodes; j++) {
				weight[i][j] = -1;
				edgeMST[i][j] = false;
			}
		}

		// define graph
		weight[1][2] = weight[2][1] = 5;
		weight[1][3] = weight[3][1] = 4;
		weight[2][4] = weight[4][2] = 2;
		weight[3][4] = weight[4][3] = 6;
		weight[3][5] = weight[5][3] = 9;
		weight[3][6] = weight[6][3] = 11;
		weight[4][6] = weight[6][4] = 19;
		weight[4][7] = weight[7][4] = 3;
		weight[5][6] = weight[6][5] = 15;
		weight[6][7] = weight[7][6] = 8;
		weight[6][8] = weight[8][6] = 6;

		inMST[1] = true;

		// initialize minWeights
		for (int i = 2; i <= numNodes; i++) {
			if (weight[1][i] != -1) {
				minWeight[i] = weight[1][i];
				minWeightEdge[i] = 1;
			} else
				minWeight[i] = 999;
		}

		minWeightNode = 1;
		for (int i = 2; i <= numNodes; i++) {

			// find next min. weight edge to add to MST
			minWeightAll = 999;
			for (int j = 2; j <= numNodes; j++)
				if ((!inMST[j]) && (minWeight[j] < minWeightAll)) {
					minWeightAll = minWeight[j];
					minWeightNode = j;
				}

			// add min. weight edge
			inMST[minWeightNode] = true;
			edgeMST[minWeightNode][minWeightEdge[minWeightNode]] = edgeMST[minWeightEdge[minWeightNode]][minWeightNode] = true;

			// update min. weights
			for (int j = 2; j <= numNodes; j++)
				if ((!inMST[j]) && (weight[j][minWeightNode] != -1))
					if (weight[j][minWeightNode] < minWeight[j]) {
						minWeight[j] = weight[j][minWeightNode];
						minWeightEdge[j] = minWeightNode;
					}
		}

		// output MST and total weight
		for (int i = 1; i <= numNodes; i++)
			for (int j = i + 1; j <= numNodes; j++)
				if (edgeMST[i][j]) {
					System.out.println("(" + i + ", " + j + ")");
					sumWeight += weight[i][j];
				}
		System.out.println();
		System.out.println("Total weight = " + sumWeight);
	}
}
