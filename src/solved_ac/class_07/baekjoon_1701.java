package solved_ac.class_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1701 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		System.out.println(Cubeditor(input));
	}
	
	
	
	private static int Cubeditor(String input) {
		int len = input.length();
		int max = 0;
		int tmp = 0;
		int nu = 0;
		
		for (int i = 0; i < len; i++) {
			if(max >= len-i) {
				break;
			}
			
			else {
				
				while( input.substring(i+1+tmp+nu).indexOf(input.charAt(i)) + i +1 > i) {
					
					nu = input.substring(i+1+tmp).indexOf(input.charAt(i)) + i +1;
					if(nu > i) {
						tmp = 0;
						while(input.charAt(i) == input.charAt(nu)) {
							max = max < ++tmp ? tmp : max;
							i++;
							nu++;
							
							if (nu >= len) return max;
						}
						i=i+tmp;
					}
				}
			}
		}
		
		return max;
	}
}
