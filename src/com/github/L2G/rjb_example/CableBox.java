/**
 * CableBox.java
 */
package com.github.L2G.rjb_example;

import com.github.L2G.rjb_example.IDisplayDevice;

/**
 * Class representing a box that can tune in television programs and send their
 * signals to a device that has the IDisplayDevice interface.
 */
public class CableBox {
	
	/**
	 * Program listing -- static because the programs are the same no matter
	 * how many cable boxes we have.
	 */
	private static String[] programListing
		= {	"M*A*S*H",
		   	"Eyewitness News",
		   	"Oddities",
		   	"Mad Men",
		   	"Archer",
		   	"Arrested Development" };
	
	public int channel = 0;
	public IDisplayDevice connectedDevice;
	
	public CableBox(IDisplayDevice displayDevice) {
		connectedDevice = displayDevice;
		this.sendVideo();
	}
	
	public void channelUp() {
		channel += 1;
		if (channel >= programListing.length) {
			channel = 0;
		}
	}
	
	private void sendVideo() {
		connectedDevice.showProgram(programListing[channel]);
	}
}
