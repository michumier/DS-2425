package main;
import java.io.*;

import observers.Activator;
import observers.BarChart;
import observers.PieChart;
import observers.Repeater;
import observers.SaveResults;
import observers.StateLine;
import poll.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("¿Está a favor de la energía nuclear?");

		poll.addObserver(new PieChart());
		poll.addObserver(new BarChart());
		poll.addObserver(new SaveResults());


		// Modificacion 1
		poll.addObserver(new StateLine());
 
		// Modificacion 2 es comentar la linea del poll.addObserver(new BarChart());

		// Modificacion 3
		poll.addObserver(new Activator(3,new PieChart()));

		// Modificacion 4
		poll.addObserver(new Activator(3, new BarChart()));

		// Modificacion 5
		poll.addObserver(new Activator(4,new Repeater(3,new StateLine())));
		
		

		TextUserInterface ui = new TextUserInterface();
		ui.fill(poll);
	}
}