package com.algorithms.fibonacci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CheckInventory {
	// -----------------------------------------------------------------
	// Reads data about a store inventory from an input file,
	// creating an array of InventoryItem objects, then prints them.
	// -----------------------------------------------------------------
	public static void main(String[] args) {
		final int MAX = 100;
		InventoryItem[] items = new InventoryItem[MAX];
		StringTokenizer tokenizer;
		String line, name, file = "inventory.dat";
		int units, count = 0;
		float price;
		try

		{
			FileReader fr = new FileReader(file);
			BufferedReader inFile = new BufferedReader(fr);
			line = inFile.readLine();
			while (line != null) {
				tokenizer = new StringTokenizer(line);
				name = tokenizer.nextToken();
				try {
					units = Integer.parseInt(tokenizer.nextToken());
					price = Float.parseFloat(tokenizer.nextToken());
					items[count++] = new InventoryItem(name, units, price);
				}

				catch (NumberFormatException exception) {
					System.out.println("Error in input. Line ignored:");
					System.out.println(line);
				}
				line = inFile.readLine();
			}
			inFile.close();
			for (int scan = 0; scan < count; scan++)
				System.out.println(items[scan]);
		} catch (FileNotFoundException exception) {
			System.out.println("The file " + file + " was not found.");
		} catch (IOException exception) {
			System.out.println(exception);
		}

	}

}