import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<50; i++) {
			String test = s.nextLine();
			String result = solution.runCommand(test);
			System.out.println(result);
			if(test == "stop") {
				break;
			}
		}
	}

}
