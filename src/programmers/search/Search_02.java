package programmers.search;

import java.util.LinkedList;
import java.util.Queue;

class Search_02 {
    public int solution(String numbers) {
        Queue<Integer> que = new LinkedList<>() ;
        
        for(String data : numbers.split("")) {
        	que.add(Integer.parseInt(data));
        }
        
        // 에라토스테네스의 채 >> 0보다 크면 소수
        int[] prime = new int[10000000];
        for (int i = 2; i < prime.length; i++) {
			if(prime[i]==0) {
				prime[i]++;
				for (int j = i*2; j < prime.length; j+=i) {
					prime[j]=-1;
				}
			}
		}
        
		return search(0,que,prime,0);
    }
    
    // 재귀로 완전 탐색
    int search(int num, Queue<Integer> que, int[] prime, int answer ) {
    	answer = check(num,prime,answer);
    	int tmp = 0;
    	for (int i=0; i<que.size(); i++) {
    		tmp = que.peek();
    		answer = search(num*10+que.poll(), que, prime, answer);
    		que.add(tmp);
		}
    	
    	return answer;
    }
    
    // 소수 체크
    int check(int num, int[] prime, int answer) {
    	//1이면 소수 2이상이면 이미 카운트된 소수, 0,-1 이면 소수 X
    	if(prime[num]!=1)
    		return answer;
    	prime[num]++;
    	return ++answer;
    }
}