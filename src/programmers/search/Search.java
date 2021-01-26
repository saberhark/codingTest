package programmers.search;

import java.util.Arrays;

public class Search {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_02 sol_02 = new Search_02();
		String numbers = "17";
		
		System.out.println("["+sol_02.getClass().getSimpleName()+"] return : "+sol_02.solution(numbers));
		
		Search_03 sol_03 = new Search_03();
		int brown=24;
		int yellow=24;
		
		System.out.println("["+sol_03.getClass().getSimpleName()+"] return : "+Arrays.toString(sol_03.solution(brown, yellow)));
	}
}