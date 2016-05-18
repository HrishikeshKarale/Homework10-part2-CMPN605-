/**
 * The Producers class extends thread and over rides the run() which prints the 
 * name of the thread being executed.
 */
public class Producers extends Thread
{
	//stores produced goods.
	private boolean produce[];
	//stores index position of producer of value false
	private int check=0;
	
	/**
	 * This is the parameterized constructor which has an int max as parameter 
	 * and initializes the producer array of max size.
	 * @param max
	 */
	Producers(int max)
	{
		produce= new boolean[max];
	}
	
	/**
	 * The checker() goes through the producer array in search of a false value
	 * and returns index position of that value. if no such value is found then
	 * it returns 0;
	 * 
	 * @return index position of false in producer array
	 */
	private int checker()
	{
		synchronized(this)
		{
			for(int i=0; i<produce.length; i++)
			{
				if(produce[i]==false)
					return i+1;
			}
			return 0;
		}
	}
	
	/**
	 * The getProduce() returns a boolean value depending on the availability of
	 * produce and notifies the thread if a produce is consumed so that it can 
	 * resume production of produce.
	 * 
	 * @return true if produce is consumed else returns false
	 */
	public boolean getProduce()
	{
		check = this.checker();
		synchronized(this)
		{
			if((check)!=0)
			{
				produce[check-1]=false;
				notify();
				return true;
			}
			return false;
		}
	}
	
	/**
	 * the run() checks if produce is full and if found full it sends the 
	 * thread to wait state. If it is not full then it starts producing
	 * new produces.
	 */
	@Override
	public void run()
	{
		check=this.checker();
		if(check==0)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		else
		{
			synchronized(this)
			{
				for(int i=check; i<produce.length; i++)
				{
					produce[i]=true;
					System.out.println(getName()+" no "+(i+1)+" produced");
				}
			}
		}
	}
}
