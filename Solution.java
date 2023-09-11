import java.util.ArrayList;
import java.util.Scanner;

public class Solution implements CommandRunner{
	private String output;
	private String instruction;
	private long num;
	private ArrayList<Thread> listThread = new ArrayList<Thread>();
	private ArrayList<SlowCalculator> listRunnable = new ArrayList<SlowCalculator>();
	public static int numThreads = 0;

	
	public String runCommand(String command) {
		Scanner s = new Scanner(command);
		instruction = s.next();
		String invalid = "Invalid command";
		
		//start N command
		if(instruction.equals("start")){
			if(s.hasNextLong()) {
					num = s.nextLong();
					if(!s.hasNext()) {
						SlowCalculator tempSlow = new SlowCalculator(num);
						listRunnable.add(tempSlow);
						listThread.add(new Thread(tempSlow));
						listThread.get(numThreads).start();
						numThreads++;
						output = "Started " + num;
					}else{
						output = invalid;
					}
			}else{
				output = invalid;			
			}
		
			
		//cancel N command
		}else if(instruction.equals("cancel")){
			if(s.hasNextLong()) {
				num = s.nextLong();
				if(!s.hasNext()) {
					for(int i=0; i< listRunnable.size(); i++) {
						if(num == listRunnable.get(i).getN()) {
							if(listThread.get(i).isAlive()) {
								listThread.get(i).interrupt();
								output = "Cancelled " + num;
							}
						}
					}
				}else{
					output = invalid;
				}
			}else{
			output = invalid;			
			}
		
		//running command
		}else if(instruction.equals("running")){
			if(!s.hasNext()) {
				int numAliveThread = 0;
				String numbers = "";
				for(int i=0; i< listThread.size(); i++) {
					if(listThread.get(i).isAlive() && !listThread.get(i).isInterrupted()) {
						numAliveThread++;
						numbers += " " + listRunnable.get(i).getN();
					}
				}
				output = numAliveThread + " calculations running:" + numbers;		
			}else {
				output = invalid;
			}
		
		
		//get N command
		}else if(instruction.equals("get")){
			if(s.hasNextLong()) {
				num = s.nextLong();
				if(!s.hasNext()) {
					for(int i=0; i< listRunnable.size(); i++) {
						if(num == listRunnable.get(i).getN()) {
							if(listThread.get(i).isAlive() && !listThread.get(i).isInterrupted()) {
								output = "calculating";
							}else{
								int M = listRunnable.get(i).getM();
								output = "result is " + M;
							}
						}
					}
				}else {
					output = invalid;
				}
			}else{
			output = invalid;			
			}
		
		
		//finish command
		}else if(instruction.equals("finish")){
			if(!s.hasNext()) {
					for(int i=0; i<listThread.size(); i++) {
						if(listThread.get(i).isAlive()) {
							try {
								listThread.get(i).join();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					output = "Finished";
			}else {
				output = invalid;
			}
		
		//abort command
		}else if(instruction.equals("abort")){
			if(!s.hasNext()) {
				for(int i=0; i<listThread.size(); i++) {
					if(listThread.get(i).isAlive()) {
						listThread.get(i).interrupt();
					}
				}
				output = "Aborted";		
			}else {
				output = invalid;
			}
		}else {
			output = invalid;
		}
		s.close();
		return output;
	}

}
