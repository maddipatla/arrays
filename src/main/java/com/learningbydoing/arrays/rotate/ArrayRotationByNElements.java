/**
 * 
 */
package com.learningbydoing.arrays.rotate;

/**
 * @author Maddipatla Chandra Babu
 * @date 09-Mar-2018
 */
public final class ArrayRotationByNElements {

	private ArrayRotationByNElements() {
	}

	/**
	 * <p>
	 * Time complexity O(n).
	 * </p>
	 * Space complexity O(n).
	 * 
	 * @param array
	 * @param numberOfElementsToRotate
	 * @return new rotated array
	 */
	public static int[] rotateUsingNewArray(int[] array, int numberOfElementsToRotate) {
		if (areNumbersEqual(array.length, numberOfElementsToRotate))
			return array;

		int rotateNElements = getValidNumberToRotate(array, numberOfElementsToRotate);
		int[] tempArray = new int[array.length];
		int index = 0;
		for (int i = rotateNElements; i < array.length; i++) {
			tempArray[index++] = array[i];
		}
		for (int i = 0; i < rotateNElements; i++) {
			tempArray[index++] = array[i];
		}
		return tempArray;
	}

	/**
	 * <p>
	 * Time complexity O(n).
	 * </p>
	 * Space complexity O(d), where d is number of elements to be rotated.
	 * 
	 * @param array
	 * @param numberOfElementsToRotate
	 */
	public static void rotateUsingTempArray(int[] array, int numberOfElementsToRotate) {
		if (areNumbersEqual(array.length, numberOfElementsToRotate))
			return;

		int rotateNElements = getValidNumberToRotate(array, numberOfElementsToRotate);
		int[] temp = new int[rotateNElements];
		for (int i = 0; i < rotateNElements; i++) {
			temp[i] = array[i];
		}
		int index = 0;
		for (int i = rotateNElements; i < array.length; i++) {
			array[index++] = array[i];
		}
		for (int i = 0; i < temp.length; i++) {
			array[index++] = temp[i];
		}
	}

	/**
	 * <p>
	 * Time complexity O(n * d), where d is number of elements to be rotated.
	 * </p>
	 * Space complexity O(1).
	 * 
	 * @param array
	 * @param numberOfElementsToRotate
	 */
	public static void rotateArrayWithoutUsingExtraSpace(int[] array, int numberOfElementsToRotate) {
		if (areNumbersEqual(array.length, numberOfElementsToRotate))
			return;

		int rotateNElements = getValidNumberToRotate(array, numberOfElementsToRotate);
		for (int i = 0; i < rotateNElements; i++) {
			int temp = array[0];
			for (int j = 1; j < array.length; j++) {
				array[j - 1] = array[j];
				if (j == array.length - 1)
					array[j] = temp;
			}
		}
	}

	/**
	 * It is a Juggling algorithm implementation. Instead of moving one by one,
	 * divide the array in different sets where number of sets is equal to GCD of n
	 * (array length) and d(number of elements to be rotated) and move the elements
	 * within sets.
	 * 
	 * <p>
	 * Time complexity O(n).
	 * </p>
	 * Space complexity O(1).
	 * 
	 * @param array
	 * @param numberOfElementsToRotate
	 */
	public static void rotateUsingGCD(int[] array, int numberOfElementsToRotate) {
		if (areNumbersEqual(array.length, numberOfElementsToRotate))
			return;

		int rotateNElements = getValidNumberToRotate(array, numberOfElementsToRotate);
		int arrayLength = array.length;
		int j;
		int k;
		int temp;
		for (int i = 0; i < getGCD(rotateNElements, arrayLength); i++) {
			temp = array[i];

			j = i;
			while (true) {
				k = j + rotateNElements;
				if (k >= arrayLength)
					k = k - arrayLength;
				if (k == i)
					break;
				array[j] = array[k];
				j = k;
			}
			array[j] = temp;
		}
	}

	/**
	 * 
	 * @param numberOfElementsToBeRotated
	 * @param arraySize
	 * @return GCD (Greatest common divisor)
	 */
	private static int getGCD(int numberOfElementsToBeRotated, int arraySize) {
		if (arraySize == 0)
			return numberOfElementsToBeRotated;

		return getGCD(arraySize, numberOfElementsToBeRotated % arraySize);
	}

	/**
	 * <p>
	 * Time complexity O(d + n - d + n), where d is number of elements to be
	 * rotated.
	 * </p>
	 * Space complexity O(1).
	 * 
	 * @param array
	 * @param numberOfElementsToBeRotated
	 */
	public static void rotateArrayUsingReversalAlgorithm(int[] array, int numberOfElementsToBeRotated) {
		if (areNumbersEqual(array.length, numberOfElementsToBeRotated))
			return;
		int rotateNElements = getValidNumberToRotate(array, numberOfElementsToBeRotated);
		reverseArray(array, 0, rotateNElements - 1);
		reverseArray(array, rotateNElements, array.length - 1);
		reverseArray(array, 0, array.length - 1);
	}

	/**
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	private static void reverseArray(int[] array, int startIndex, int endIndex) {
		if (startIndex < 0 || endIndex >= array.length)
			throw new ArrayIndexOutOfBoundsException(
					"One of the indexes is out of bounds, which should be between 0 and " + (array.length - 1)
							+ " but received startIndex: " + startIndex + " and endIndex: " + endIndex);
		int temp;
		while (startIndex < endIndex) {
			temp = array[startIndex];
			array[startIndex++] = array[endIndex];
			array[endIndex] = temp;
			endIndex--;
		}
	}

	/**
	 * If number of elements to be rotated is greater than the array length then
	 * deriving number of elements to be rotated using elementsToBeRotated %
	 * arrayLength.
	 * 
	 * @param array
	 * @param numberOfElementsToBeRotated
	 * @return derived number to be rotated
	 */
	private static int getValidNumberToRotate(int[] array, int numberOfElementsToBeRotated) {
		if (array.length > numberOfElementsToBeRotated)
			return numberOfElementsToBeRotated;
		else
			return numberOfElementsToBeRotated % array.length;
	}

	/**
	 * @param arrayLength
	 * @param numberOfElementsToBeRotated
	 * @return true if both numbers have same number
	 */
	private static boolean areNumbersEqual(int arrayLength, int numberOfElementsToBeRotated) {
		return arrayLength == numberOfElementsToBeRotated;
	}
}
