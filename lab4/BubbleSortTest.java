import static org.junit.Assert.*;
import org.junit.Test;

public class BubbleSortTest {
	private BubbleSort c;
	@Test
	public void test() {
		// assertEquals()���ڶ��Բ��Խ��
		int arr[] = new int[]{1,6,2,2,5};
        int arr1[] = new int[]{1,2,2,5,6};
		int arr2[] = BubbleSort.BubbleSort(arr);
		assertArrayEquals(arr1,arr2);
	}

}