import java.util.Arrays;
import java.util.Scanner;

public class A_LuckyNum {
	private String unluckyNumber;//The number you want to avoid
	private int[] numbers;//The input numbers
	private int[] sequence;//The sequence of numbers avoiding the unlucky numberw
	A_LuckyNum(int A, int Q, Scanner in){
		//A reprents the unlucky number.
		//Q represents the number of inputs you will have to check.
		unluckyNumber = A + "";
		numbers = inputArray(Q,in);
		sequence = getSequence();
		getPosition();
		
	}
	private int[] inputArray(int size, Scanner in){
		//Method that will get the numbers you want to find
		int[] inputs = new int[size];
		for(int i = 0; i < size; i++){
			System.out.print("Insert input nº " + i + " : ");
			inputs[i] = in.nextInt();
		}
		return inputs;
	}
	public int[] getSequence(){
		int[] result = new int[10000];
		int numberEvaluate = 1;
		String conv = "";
		for(int i = 0; i < 10000; i++){
			conv = "" + numberEvaluate;
			if(conv.contains(unluckyNumber)){
				i--;
			}
			else{
				result[i]=numberEvaluate;
			}
			numberEvaluate++;
		}
		return result;
	}
	public void getPosition(){
		int j = 0;
		for(int i = 0 ; i < 10000 && j < numbers.length; i++){
			if(numbers[j]==sequence[i]){
				System.out.println(numbers[j] + " was found at position " + (i+1) + "!!");
				i=0;
				j++;
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		A_LuckyNum a = new A_LuckyNum(13,4,in);
		System.out.println(Arrays.toString(a.getSequence()));
		in.close();
		
	}
}
