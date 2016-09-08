import java.util.Arrays;
import java.util.Scanner;

public class C_Opera {
	//Problem C 2016
	int [] fila;
	int Q;
	int N;
	int lastCal;
	C_Opera(int N, int Q, Scanner in){
		this.Q = Q;
		this.N = N;
		fila = new int[N];
		for(int i = 0; i < N; i++){
			fila[i] = in.nextInt();
		}
		System.out.println("Your input is set.");
		System.out.println(Arrays.toString(fila));
	}
	public int runCalculations(Scanner in){
		for(int i = 0; i < Q*2; i++){
			runCommand(in.nextLine(),in);
			//Gotta fix a bug of this running twice. Might be due to the Scanner.
		}
		return count();
	}
	public void runCommand(String command, Scanner in){
		System.out.print("Insert command: ");
		switch(command){
			case "P":
				System.out.println("Select chair that broke: ");
				int chairP = in.nextInt();
				fila[(chairP-1)]=1;
				break;
			case "A":
				System.out.println("Select chair that was repaired: ");
				int chairA = in.nextInt();
				fila[(chairA-1)]=0;
				break;
			case "Q":
				System.out.println("The max queue is: " + count());
				break;
			default:
				System.out.println("ERROR");
				break;
		}
	}
	public int count(){
		int count = 0;
		int max = -1;
		for(int i = 0 ; i < N; i++){
			if(fila[i]==0){
				count++;
			}
			else{
				count =0;
			}
			if(max < count){
				max = count;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		C_Opera test = new C_Opera(10,9, in);
		System.out.println("The result is: " + test.runCalculations(in));
	}

}
