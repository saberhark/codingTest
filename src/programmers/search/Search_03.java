package programmers.search;

class Search_03 {
    public int[] solution(int brown, int yellow) {
    	int[] answer = new int[2];

    	// brown 기준 완전 탐색
    	for (int i = 2; i <= brown/4; i++) {
			if((i-1)*(brown/2 - i - 1)==yellow) {
				answer[0]=brown/2 - i + 1;
				answer[1]=i+1;
				break;
			}
		}
    	
    	// yello 기준
    	//for i=1 ~ root(yello)
    	// brown 계산
    	
        return answer;
    }
}
