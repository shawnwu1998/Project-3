import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please choose your game:");
		
		while(true) {
			System.out.println("1. Australia Map    2.  Job-Shop Scheduling   3. N-Queens ");
			System.out.println("Enter 0 to quit");
			Scanner scan = new Scanner(System.in);
			int x = scan.nextInt();
			if(x==1) {
				System.out.println("Australia Map");
				AustraliaCSP map = new AustraliaCSP();
				map.amaptraliaMap(); 	
			}
			if(x==2) {
				System.out.println("Job Shop");
				JobShop job = new JobShop();
				job.jobshop();
			}
			if(x==0) {
				break;
			}
		}
	}

}
