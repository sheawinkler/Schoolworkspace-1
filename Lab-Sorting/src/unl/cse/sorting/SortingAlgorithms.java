package unl.cse.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

	public static Location [] javaSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		Arrays.sort(result);
		return result;
	}
	
	public static Location [] selectionSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		for(int i=0; i<result.length; i++) {
			int minIndex = i;
			for(int j=i+1; j<result.length; j++) {
				if(result[j].compareTo(result[minIndex]) < 0)
					minIndex = j;
			}
			Location tmp = result[i];
			result[i] = result[minIndex];
			result[minIndex] = tmp;
		}
		return result;
	}

	public static Location [] insertionSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		//TODO: implement insertion sort here
		for(int i=0;i<result.length;i++){
			Location copyNumber = result[i];
			int j = i;
			while(j>0 && (copyNumber.compareTo(result[j-1])<0)){
				result[j] = result[j-1];
				j--;
			}
			result[j]=copyNumber;
		}
		return result;
	}
	
	public static Location [] quickSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		quickSortRecursive(result, 0, result.length-1);
		return result;
	}

	private static void quickSortRecursive(Location list[], int low, int high) {
		final int moveLeft = 0;
        final int moveRight = 1;
        
        if (low < high)
        {
          int left = low;
          int right = high;
          int currentDirection = moveLeft;
          Location pivot = list[low];
          
          while (left < right)
          {
            if (currentDirection == moveLeft)
            {
              while ((list[right].compareTo(pivot) >= 0) && (left < right))
                right--;
              
              list[left] = list[right];
              currentDirection = moveRight;
            }
            if (currentDirection == moveRight)
            {
              while ((list[left].compareTo(pivot) <= 0) && (left < right))
                left++;
              
              list[right] = list[left];
              currentDirection = moveLeft;
            }
          }
          list[left] = pivot; 
          quickSortRecursive(list, low, left-1);
          quickSortRecursive(list, right+1, high);
        }
	}
}
