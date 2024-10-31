package main;

import fylesystem.FileSystem;
import fylesystem.filters.CharCounterOutput;
import fylesystem.filters.CodedOutput;
import fylesystem.filters.NormalizeOutput;
import fylesystem.filters.WhiteSpaceOutput;
import fylesystem.outputs.*;

public class Main {
	
	public static void main(String[] args) {
		
		FileSystem system = new FileSystem();

		System.out.println(" - Original:");
		system.copyFile("private.txt", new FileOutput("copy.txt"));
		system.copyFile("private.txt", new Internet("156.35.233.143"));
		system.copyFile("private.txt", new Bluetooth("César's iPhone"));

		// REDISEÑO INICIAL
		System.out.println(" *** Rediseño inicial:");

		system.copyFile("private.txt", new NormalizeOutput(new FileOutput("redisign.txt")));
		system.copyFile("private.txt", new CodedOutput(new Internet("156.35.233.143")));
		system.copyFile("private.txt", new CodedOutput(new WhiteSpaceOutput(new Bluetooth("César's iPhone"))));

		// MODIFICACIÓN 1
		System.out.println(" *** Mod 1:");

		system.copyFile("private.txt", new CodedOutput(new NormalizeOutput(new FileOutput("mod1.txt"))));

		// MODIFICACIÓN 2
		System.out.println(" *** Mod 2:");

		system.copyFile("private.txt", new CodedOutput(new Internet("1.1.1.1")));
		system.copyFile("private.txt", new WhiteSpaceOutput(new Internet("1.1.1.2")));
		system.copyFile("private.txt", new WhiteSpaceOutput(new CodedOutput(new Internet("1.1.1.3"))));

		// MODIFICACIÓN 3
		System.out.println(" *** Mod 3:");

		CharCounterOutput c1 = new CharCounterOutput(new FileOutput("mod3.txt"));
		system.copyFile("private.txt", c1);
		c1.printCharCounter();

		CharCounterOutput c2 = new CharCounterOutput(new Internet("156.35.233.143"));
		system.copyFile("private.txt", c2);
		c2.printCharCounter();

		CharCounterOutput c3 = new CharCounterOutput(new Bluetooth("César's iPhone"));
		system.copyFile("private.txt", c3);
		c3.printCharCounter();
		
	}
}
