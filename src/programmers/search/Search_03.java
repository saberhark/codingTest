package programmers.search;

class Search_03 {
    public int[] solution(int brown, int yellow) {
    	int[] answer = new int[2];

    	// brown ���� ���� Ž��
    	for (int i = 2; i <= brown/4; i++) {
			if((i-1)*(brown/2 - i - 1)==yellow) {
				answer[0]=brown/2 - i + 1;
				answer[1]=i+1;
				break;
			}
		}
    	
    	// yello ����
    	//for i=1 ~ root(yello)
    	// brown ���
    	
        return answer;
    }
}
