package Array;

import java.util.ArrayList;
import java.util.List;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}
	// task1

	//Method mirror that outputs the contents of an array in a 
	//reverse order like a mirror 
	//Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	int[] mirror() {
		int len = this.array.length;

		int[] result = new int[len * 2];

		for (int i = 0; i < result.length; i++) {
			if (i < array.length) {
				result[i] = array[i];
			} else {
				result[i] = array[result.length - 1 - i];

			}

		}

		display(result);
		return result; // Trả về mảng đã tạo

	}

	// removes all duplicate elements from an array and returns a 
	// new array
	//Input: 1 3 5 1 3 7 9 8
	//Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		List<Integer> listResult = new ArrayList<>();
		
		for (int x : this.array) {
			if(!listResult.contains(x)) {
				listResult.add(x);
			}
		}
		int result[] = new int[listResult.size()];
		for(int i=0;i<result.length;i++) {
			result[i]=listResult.get(i);
		}
		display(result);
		return result;
	}
	// Input: 10 11 12 13 14 16 17 19 20 
	// Output: 15 18

	int[] getMissingValue() {
		int len = this.array.length;
		int n = array[len - 1] - array[0];
		int[] result = new int[n - len + 1];
		int i=0;

		for (int j = 0; j < array.length-1; j++) {

			if (array[j] + 1 != array[j + 1]) {
				result[i] = array[j] + 1;
				i++;
				;
			}

		}

		display(result);
		return result;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	int[] fillMissingValue(int k) {

		int right = (array[k - 1] + array[k + 1] + array[k + 2]) / 3;
		int left = (array[k - 2] + array[k - 1] + array[k + 1]) / 3;
		int min = Math.min(right, left);

		this.array[k] = min;

		display(array);
		return this.array;

	}
// Hàm in mảng
	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 5, 7 };
		int[] array1 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		int[] arr2 = { 16,10, 11, 12, 13, 14, 16, 17, 19, 20 };

		MyArray array = new MyArray(arr2);
		// array.mirror();
		array.removeDuplicates();
		// array.fillMissingValue(3);
		//array.getMissingValue();
	}

}
