package programmers.search;

import java.util.LinkedList;
import java.util.Queue;

class Search_02 {
    public int solution(String numbers) {
        Queue<Integer> que = new LinkedList<>() ;
        
        for(String data : numbers.split("")) {
        	que.add(Integer.parseInt(data));
        }
        
        // �����佺�׳׽��� ä >> 0���� ũ�� �Ҽ�
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
    
    // ��ͷ� ���� Ž��
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
    
    // �Ҽ� üũ
    int check(int num, int[] prime, int answer) {
    	//1�̸� �Ҽ� 2�̻��̸� �̹� ī��Ʈ�� �Ҽ�, 0,-1 �̸� �Ҽ� X
    	if(prime[num]!=1)
    		return answer;
    	prime[num]++;
    	return ++answer;
    }
}