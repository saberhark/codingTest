package programmers.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Heap_01 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // heap�� �̿��� minheap ����
        //MinHeap priorityQueue = new MinHeap();
		
        // �켱 ���� ť PriorityQueue�� ��� 
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int data : scoville)
			priorityQueue.add(data);
		
        // scoville Mix�� ������ ���� ����
		while(priorityQueue.size() >= 2 ) {
			int a = priorityQueue.poll();
			
			// ���� �ȸſ� ��(root)�� K���� �ſ� ��� answer ����
			if(a>=K) return answer;
			
			int b = priorityQueue.poll();
			priorityQueue.add(a > b ? (a*2) + b : a + (b*2)); // scoville Mix ����
			
			answer++;
		}
		
		// scoville Mix�� ���� ���� ������ K���� �ȸſ� ��� -1 ����
		if(priorityQueue.poll() < K ) {
			return -1;
		}
		
		return answer;
    }
    
    
    //�ּ��� ������
    class MinHeap {
        private ArrayList<Integer> heap;

        // ��� �� print
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
            heap.add(0); // heap �� �ε����� �˱� ���� 0���� �����Ѵٴ� Ư���� ������.
        }

        // insertion
        private void add(int data) {
            heap.add(data);
            int position = heap.size() - 1;
            // ��Ʈ ������ �̵��߰ų�, �θ� Heap�� �ڽ� Heap���� ���� �� ����
            while(position > 1 && heap.get(position / 2) > heap.get(position)) {

                /*�θ� ���� �ڽ� ��尣�� swap�� ���� ����*/
                int temp = heap.get(position / 2);
                heap.set(position / 2, heap.get(position));
                heap.set(position, temp);

                position /= 2;
            }
        }

        // delete
        int poll() {
	        // heap ����� 1���� ������ ��, ���� ���� ������ return 0;
	        if(heap.size() - 1 < 1) {
	            return 0;
	        }
	
	        int deleteData = heap.get(1); // ��� ��� ����
	
	        heap.set(1, heap.get(heap.size() - 1)); // ��Ʈ ����� �ڸ��� ���� ����� data�� ����
	        heap.remove(heap.size() - 1); // ���� ��� ����
	
	        int position = 1;
	        while((position * 2) < heap.size()) { // ���� ũ�⺸�� ���� �� ����
	            int min = heap.get(position * 2); // ���� ����� ���� �ڽ� ����� ��
	            int minPos = position * 2; // ���� ����� ���� �ڽ� ����� �ε���
	
	            // ������ �ڽ� ���� ���� �ڽ� ��� �� �� ū ��忡 ���� ���ϰ� ��ȯ�ϱ� ������ ���� �ڽĳ��� ������ �ڽ� ����� ���� ���ϴ� ������ ��ģ��.
	            if(((position * 2 + 1) < heap.size()) && min > heap.get(position * 2 + 1)){  // ������ �ڽ� ��尡 �� ũ�� �ٲ�����Ѵ�.
	                min = heap.get(position * 2 + 1); // ������ �ڽ� ���� ����
	                minPos = position * 2 + 1; // ��ġ ���� ������ �ڽ� ���� ����
	            }
	
	            if(heap.get(position) < min) break; // ���� ��庸�� �ڽ� ����� ���� �� ũ��, ���� ������ �����ϸ� �ݺ� ����
	
	            /*�ڽİ� �θ��� SWAP ����*/
	            int temp = heap.get(position);
	            heap.set(position, heap.get(minPos));
	            heap.set(minPos, temp);
	            position = minPos;
	        }
	        return deleteData;
	    }

        // ���� size (0�� ������)
        int peek() {
        	return heap.size()-1 > 1 ? heap.get(1) : -1;
        }

        // ���� size (0�� ������)
        int size() {
        	return heap.size()-1;
        }
    }    
}