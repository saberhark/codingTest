package programmers.heap;

public class Heap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap_01 sol_01 = new Heap_01();
		int[] scoville = {1,2,3,9,10,12};
		int K=7;
		
		System.out.println("["+sol_01.getClass().getSimpleName()+"] return : "+sol_01.solution(scoville, K));
	}
}
