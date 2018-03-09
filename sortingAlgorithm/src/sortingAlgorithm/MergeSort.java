package sortingAlgorithm;

public class MergeSort {
	/**
	 * �鲢���� ���:�����������������ϣ�������ϲ���һ���µ������
	 * ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������ ʱ�临�Ӷ�ΪO(nlogn) �ȶ�����ʽ
	 * 
	 * @param nums
	 *            ����������
	 * @return �����������
	 */

	public static int[] mergeSort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// ���
			mergeSort(nums, low, mid);
			// �ұ�
			mergeSort(nums, mid + 1, high);
			// ���ҹ鲢
			merge(nums, low, mid, high);
		}
		return nums;
	}

	/**
	 * ��������low��highλ�õ�����������
	 * 
	 * @param nums
	 *            ����������
	 * @param low
	 *            ���ŵĿ�ʼλ��
	 * @param mid
	 *            �����м�λ��
	 * @param high
	 *            ���Ž���λ��
	 */
	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// ��ָ��
		int j = mid + 1;// ��ָ��
		int k = 0;

		// �ѽ�С�������Ƶ���������
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		// �����ʣ�������������
		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		// ���ұ߱�ʣ�������������
		while (j <= high) {
			temp[k++] = nums[j++];
		}

		// ���������е�������nums����
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}

}