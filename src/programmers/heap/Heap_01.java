package programmers.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Heap_01 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // heap을 이용해 minheap 구현
        //MinHeap priorityQueue = new MinHeap();
		
        // 우선 순위 큐 PriorityQueue을 사용 
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int data : scoville)
			priorityQueue.add(data);
		
        // scoville Mix가 가능한 동안 진행
		while(priorityQueue.size() >= 2 ) {
			int a = priorityQueue.poll();
			
			// 제일 안매운 값(root)가 K보다 매울 경우 answer 리턴
			if(a>=K) return answer;
			
			int b = priorityQueue.poll();
			priorityQueue.add(a > b ? (a*2) + b : a + (b*2)); // scoville Mix 과정
			
			answer++;
		}
		
		// scoville Mix를 전부 진행 했으나 K보다 안매운 경우 -1 리턴
		if(priorityQueue.poll() < K ) {
			return -1;
		}
		
		return answer;
    }
    
    
    //최소힙 구현부
    class MinHeap {
        private ArrayList<Integer> heap;

        // 모든 값 print
        public void print() {
        	System.out.println("print");
        	for(int i : heap) {
        		System.out.print(" "+i);
        	}
        	System.out.println();
        }
        
        /*heap init*/
        public MinHeap(){
            heap = new ArrayList<>();
            heap.add(0); // heap 의 인덱스는 알기 쉽게 0부터 시작한다는 특성을 따른다.
        }

        // insertion
        private void add(int data) {
            heap.add(data);
            int position = heap.size() - 1;
            // 루트 노드까지 이동했거나, 부모 Heap이 자식 Heap보다 작을 때 까지
            while(position > 1 && heap.get(position / 2) > heap.get(position)) {

                /*부모 노드와 자식 노드간의 swap을 위한 연산*/
                int temp = heap.get(position / 2);
                heap.set(position / 2, heap.get(position));
                heap.set(position, temp);

                position /= 2;
            }
        }

        // delete
        int poll() {
	        // heap 사이즈가 1보다 작으면 즉, 힙에 값이 없으면 return 0;
	        if(heap.size() - 1 < 1) {
	            return 0;
	        }
	
	        int deleteData = heap.get(1); // 루드 노드 삭제
	
	        heap.set(1, heap.get(heap.size() - 1)); // 루트 노드의 자리에 말단 노드의 data를 설정
	        heap.remove(heap.size() - 1); // 말단 노드 삭제
	
	        int position = 1;
	        while((position * 2) < heap.size()) { // 힙의 크기보다 작을 떄 까지
	            int min = heap.get(position * 2); // 현재 노드의 왼쪽 자식 노드의 값
	            int minPos = position * 2; // 현재 노드의 왼쪽 자식 노드의 인덱스
	
	            // 오른쪽 자식 노드와 왼쪽 자식 노드 중 더 큰 노드에 값과 비교하고 교환하기 때문에 왼쪽 자식노드와 오른쪽 자식 노드의 값을 비교하는 과정을 거친다.
	            if(((position * 2 + 1) < heap.size()) && min > heap.get(position * 2 + 1)){  // 오른쪽 자식 노드가 더 크면 바꿔줘야한다.
	                min = heap.get(position * 2 + 1); // 오른쪽 자식 노드로 변경
	                minPos = position * 2 + 1; // 위치 또한 오른쪽 자식 노드로 변경
	            }
	
	            if(heap.get(position) < min) break; // 현재 노드보다 자식 노드의 값이 더 크면, 힙의 성질을 만족하면 반복 종료
	
	            /*자식과 부모의 SWAP 과정*/
	            int temp = heap.get(position);
	            heap.set(position, heap.get(minPos));
	            heap.set(minPos, temp);
	            position = minPos;
	        }
	        return deleteData;
	    }

        // 실제 size (0을 제외한)
        int peek() {
        	return heap.size()-1 > 1 ? heap.get(1) : -1;
        }

        // 실제 size (0을 제외한)
        int size() {
        	return heap.size()-1;
        }
    }    
}