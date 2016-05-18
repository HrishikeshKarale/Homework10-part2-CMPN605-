/**
* Test.java
*
* @version   $Id: Test.java,v_1.4 2014/11/10 22:09:00
*
* @author    hhk9433 (Hrishikesh Karale)
* 
* Revisions:
*      Initial revision
*/

/**
 * The Test Class is used to execute the code written in class's Producers and 
 * Consumers.
 */
public class Test 
{
	/**
     * This is the main method of class test. Objects of class PrintABC are 
     * made and stored in the reference of type class PrintABC.
     * @param args
     */
	public static void main(String args[])
	{
		Producers screw = new Producers(4);
		//sets name of the object referred  by reference variable screw as 'screw'.
        screw.setName("screw");
		Producers base = new Producers(2);
		//sets name of the object referred  by reference variable base as 'base'.
        base.setName("base");
		Producers stand = new Producers(4);
		//sets name of the object referred  by reference variable stand as 'stand'.
        stand.setName("stand");
		Producers socket = new Producers(7);
		//sets name of the object referred  by reference variable socket as 'socket'.
        socket.setName("socket");
		Producers light_bulb = new Producers(4);
		//sets name of the object referred  by reference variable light_bulb as 'light_bulb'.
        light_bulb.setName("light_bulb");
		Consumers consumer_one = new Consumers(screw,base,stand,socket,light_bulb);
		//sets name of the object referred  by reference variable customer_one as 'PATRICK'.
        consumer_one.setName("PATRICK");
		Consumers consumer_two = new Consumers(screw,base,stand,socket,light_bulb);
		//sets name of the object referred  by reference variable customer_two as 'LUISE'.
        consumer_two.setName("LUISE");
		
		screw.start();
		base.start();
		stand.start();
		socket.start();
		light_bulb.start();
		consumer_one.start();
		consumer_two.start();
		
	}
}

