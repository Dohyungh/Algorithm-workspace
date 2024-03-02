package SWEA._모의_벌꿀채취;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		long[] arr = {100L, 200L, 300L, 19L};
		Long[] arr2 = Long.stream(arr).boxed().toArray(Long[]::new);
		Arrays.sort(arr, (o1,o2)-> {
			return o2-o1;
		});
	}
	

}
