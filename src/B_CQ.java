import java.util.Scanner;
public class B_CQ {
	int[][] grid;
//Problema B - Caderno Quadriculado 2016
	/*
	 * A Sara adora o seu caderno quadriculado de matem�tica. 
	 * Para passar o tempo come�ou a escrever os n�meros inteiros 
	 * consecutivamente. Achou, contudo, que faz�-lo de esquerda 
	 * para a direita e de cima para baixo era muito aborrecido! 
	 * Resolveu por isso preencher os n�meros pelas diagonais usando 
	 * o seguinte padr�o:
	 *  1	3	6	10	15	21	28	36
		2	5	9	14	20	27	35	44
		4	8	13	19	26	34	43	53
		7	12	18	25	33	42	52	63
		11	17	24	32	41	51	62	74
		16	23	31	40	50	61	73	86
		
		A Sara gostava de poder verificar se as somas est�o corretas. 
		Claro que ela gostava de saber a soma de um qualquer ret�ngulo 
		dado. Ser� que podes ajud�-la?

		PROBLEMA
		
		Dado um conjunto de N ret�ngulos, cada um indicado pelos 
		n�meros nos seus cantos Ai e Bi, determina a soma dos n�meros 
		contidos em cada ret�ngulo, supondo que o caderno quadriculado 
		foi preenchido pelas diagonais como atr�s descrito. 
		Podes assumir que o caderno tem um tamanho t�o grande 
		que a Sara tem sempre uma quadr�cula dispon�vel quando precisa de 
		escrever um novo n�mero.
		
		INPUT
		
		Na primeira linha vem um inteiro N, indicando o n�mero de 
		ret�ngulos a considerar. Seguem-se N linhas, cada uma com 
		dois inteiros Ai e Bi indicando os cantos superior esquerdo 
		e inferior direito, respectivamente, do i-�simo ret�ngulo.
		
		OUTPUT
		
		O output deve contar N linhas, uma para cada ret�ngulo,
		contendo a soma do dos n�meros nele contidos.
		
		Input do Exemplo

			4
			13 51
			5 31
			28 44
			25 245
		
		Output do Exemplo

			358
			160
			143
			7480
	 */
	private Point getCoordinates(int x){
		Point o = new Point();
		for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[i].length; j++) {
		        if(grid[i][j]==x){
		        	o.setX(j);
		        	o.setY(i);
		        	
		        	return o;
		        }
		    }
		}
		return null;
	}
	private int getSum(int a, int b){
		Point cornerTop = getCoordinates(a);
		Point cornerBot = getCoordinates(b);
		int sum = 0;
		for(int i = cornerTop.getY();i <= cornerBot.getY();i++){
			for(int j = cornerTop.getX(); j <= cornerBot.getX();j++){
				sum += grid[i][j];
			}
		}
		System.out.println("For number " + a + " and number " + b + " the sum is "
				+ " : " + sum);
		return sum;
	}
	private int[][] generateGrid(int column, int row){
		int[][] grid = new int[row][column];
		int rowInc = 2;
		int columnInc = 1;
		for(int i = 0; i < row; i++){
			if(i==0)
				grid[i][0]=columnInc;
			else
				grid[i][0]=grid[i-1][0]+columnInc;
			int rowIncCurrent = rowInc;
			for(int j=1; j<column;j++){
				
				grid[i][j]=grid[i][j-1]+rowIncCurrent;
				rowIncCurrent++;
			}
			rowInc++;
			if(i!=0)
				columnInc++;
		}
		return grid;
	}
	B_CQ(int nRectangles, Scanner in){
		grid = generateGrid(1000,1000);
		int[][] rectangles = new int[nRectangles][2];
		for(int i=0; i < rectangles.length; i++){
			for(int j=0; j<rectangles[i].length;j++){
				if(j==0){
					System.out.print("Please provide number of the "
							+ "top left corner of the rectangle n� " + (i+1) + " : ");
				}
				else{
					System.out.print("Please provide number of the "
							+ "bottom right corner of the rectangle n� " + (i+1) + " : ");
				}
				rectangles[i][j]=in.nextInt();
			}
		}
		getMatrix(rectangles);
		for(int i = 0; i < rectangles.length; i++){
			getSum(rectangles[i][0],rectangles[i][1]);
		}	
	}
	public void getGrid(){
		for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[i].length; j++) {
		        System.out.print(grid[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	public void getMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		B_CQ a = new B_CQ(4, in);	
	}
}
class Point{
	int x;
	int y;
	Point(){	
	}
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
}
