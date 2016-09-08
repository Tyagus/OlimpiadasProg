/*
roblema A - Baile Olímpico

Todos os anos se realiza o grande baile olímpico português, onde os alunos
de todas as Olimpíadas se encontram para discutir ideias. Quando chega
a altura de escolher um parceiro para a dança, os olímpicos colocam-se 
numa fila, ordenados por altura, do mais baixo para o mais alto. 

As raparigas só querem dançar com rapazes mais altos do que elas, para que
não sejam pisadas. Por outro lado, para que a escolha não provoque uma 
grande confusão, dois olímpicos só podem dançar um com o outro se não 
distarem mais do K posições na fila. Por exemplo, para a imagem de cima, 
se K fosse três, a rapariga nº2 só poderia dançar com os rapazes nº4 e nº5
(o nº1 é mais baixo; os nº6 e nº10 distam mais do que três posições).

Curioso como és, pretendes saber quantos pares diferentes de dançarinos 
se podiam formar tendo em conta as regras dadas.

PROBLEMA
Dada uma fila de N olímpicos ordenados por altura e uma distância máxima K,
a tua tarefa é determinar o número de pares diferentes possíveis, onde um par
é válido se for entre uma rapariga e um rapaz mais alto do que ela e ambos
não estiverem separados por uma distância superior a K.

INPUT

Na primeira linha vêm dois inteiros, N que representa o número de olímpicos e K
que representa a distância máxima entre dois olímpicos para que um possa chamar 
o outro para uma dança.
Segue-se uma linha com N carácteres que podem ser 'H' (homem) ou 'M' (mulher), 
sendo que o i-ésimo carácter representa o género do i-ésimo olímpico na fila ordenada
por ordem crescente.

OUTPUT

O output deve ser constituído por uma única linha contendo um inteiro, o número 
de pares diferentes.

RESTRIÇÕES

São garantidos os seguintes limites em todos os casos de teste que irão ser colocados ao programa:

1 ≤ N ≤ 100 000	     	Número de olímpicos
1 ≤ K ≤ N	     	Distância máxima entre olímpicos
0 ≤ Resposta ≤ 231 - 1	     	Número de pares (a resposta)
Os casos de teste deste problema estão organizados em 3 grupos com restrições adicionais diferentes:

Grupo	Número de Pontos	Restrições adicionais
1	30	1 ≤ N ≤ 100
2	30	1 ≤ N ≤ 3 000
3	40	-
Input do Exemplo 1

10 3
HMMHHHMMMH
Output do Exemplo 1

8
Explicação do Exemplo 1

Os pares possíveis são os seguintes (entre parentêsis está a distância a que se encontram um do outro na fila):

A rapariga nº2 e o rapaz nº4 (distância 2)
A rapariga nº2 e o rapaz nº5 (distância 3)
A rapariga nº3 e o rapaz nº4 (distância 1)
A rapariga nº3 e o rapaz nº5 (distância 2)
A rapariga nº3 e o rapaz nº6 (distância 3)
A rapariga nº7 e o rapaz nº10 (distância 3)
A rapariga nº8 e o rapaz nº10 (distância 2)
A rapariga nº9 e o rapaz nº10 (distância 1)

INPUT EXEMPLO 2
20 2
MMHMMHMMHHHHMHHMHHMH

OUTPUT EXEMPLO 2
12
 */
public class BaileOlimpico {
	int maxDist;
	char[] participants;
	BaileOlimpico(int k, int n, String part){
		maxDist = k;
		participants = new char[n];
		participants = part.toCharArray();
	}
	public int getPairs(){
		int pairs = 0;
		for(int i = 0; i < participants.length; i++){
			if(participants[i]=='M'){
				for(int j = 1; j <= maxDist&&i+j<participants.length;j++){
					if(participants[i+j]=='H'){
						System.out.println("PAIR OF " + i + " WITH " + (i+j) );
						pairs++;
					}
				}
			}
		}
		return pairs;
	}
	public static void main(String[] args) {
		String derp = "MMHMMHMMHHHHMHHMHHMHHHMHMHMHMHMHMHMHMHMHMHMMHMHMHMHMHMHMHMMHMHMHMHMHMHMMMMMMMHHHHHMMMMMMMMMMMMMMMMHHHMHMHMHMHMHMHMMHMHMHMHMMHMHMHMHM";
		int size = derp.length();
		BaileOlimpico n = new BaileOlimpico(2, size, derp);
		System.out.println(n.getPairs());
	}
}
