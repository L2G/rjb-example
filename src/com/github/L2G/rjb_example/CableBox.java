/**
 * CableBox.java
 */
package com.github.L2G.rjb_example;

//import com.github.L2G.rjb_example.CableTvProgram;
//import com.github.L2G.rjb_example.IDisplayDevice;

/**
 * Class representing a box that can tune in television programs and send their
 * signals to a device that has the IDisplayDevice interface.
 */
public class CableBox {
	
	/**
	 * Program listing -- static because the programs are the same no matter
	 * how many cable boxes we have.
	 */
	private static CableTvProgram[] programListing
		= {	new CableTvProgram("M*A*S*H"),
			new CableTvProgram("Headline News"),
			new CableTvProgram("Oddities"),
			new CableTvProgram("Mad Men"),
			new CableTvProgram("Archer"),
			new CableTvProgram("Arrested Development")
			};
	
	public int channel = 0;
	public IDisplayDevice connectedDevice;
	
	public CableBox(IDisplayDevice displayDevice) {
		connectedDevice = displayDevice;
		System.out.println("Cable box: set up, plugged new device into it");
		this.sendVideo();
	}
	
	public void channelUp() {
		channel += 1;
		if (channel >= programListing.length) {
			channel = 0;
		}
		System.out.println("Cable box: * click *");
		this.sendVideo();
	}
	
	private void sendVideo() {
		connectedDevice.showProgram(programListing[channel]);
	}
}
