/**
 * The Consumer class extends thread and over rides the run() which prints the 
 * name of the thread being executed and what it is doing.
 */
public class Consumers extends Thread
{
	private int screws;
	private int bases;
	private int stands;
	private int sockets;
	private int bulbs;
	private Producers screw;
	private Producers base;
	private Producers  stand;
	private Producers socket;
	private Producers light_bulb;
	private int i;
	
	/**
	 * This is the parameterized constructor of class Consumers  which
	 * which initializes various produces and assigns them to local
	 * reference variables.
	 * 
	 * @param screw
	 * @param base
	 * @param stand
	 * @param socket
	 * @param light_bulb
	 */
	Consumers(Producers screw,Producers base, Producers  stand,
			Producers socket, Producers light_bulb)
	{
		i=0;
		screws=0;
		bases=0;
		stands=0;
		sockets=0;
		bulbs=0;
		this.screw = screw;
		this.base = base;
		this.stand = stand;
		this.socket = socket;
		this.light_bulb = light_bulb;
	}
	
	/**
	 * The run() method of class consumers which checks needed produces and its availability
	 */
	public void run()
	{
		synchronized(this)
		{ 
			//no of lamps
			while(i<5)
			{
				do
				{
					if(screws<4 && screw.getProduce())
					{
						System.out.println(getName()+" consumed a screw and now has "+(++screws)+" screw's");
					}
					if(bases<1 && base.getProduce())
					{
						System.out.println(getName()+" consumed a base and now has "+(++bases)+" base's");
					}
					if(stands<1 && stand.getProduce())
					{
						System.out.println(getName()+" consumed a stand and now has "+(++stands)+" stand's");
					}
					if(sockets<3 && socket.getProduce())
					{
						System.out.println(getName()+" consumed a socket and now has "+(++sockets)+" socket's");
					}
					if(bulbs<3 && light_bulb.getProduce())
					{
						System.out.println(getName()+" consumed a bulb and now has "+(++bulbs)+" bulb's");
					}	
				}while(screws<4 || bases<1|| stands<1|| sockets<3|| bulbs<3);
				screws=0;
				bases=0;
				stands=0;
				sockets=0;
				bulbs=0;
				System.out.println(getName()+" Has made a lamp no: "+(++i));
			}
		}
	}
}
