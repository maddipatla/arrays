/**
 * 
 */
package com.learningbydoing.arrays.rotate;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author Maddipatla Chandra Babu
 * @date 09-Mar-2018
 */
public final class RotateArrayByNElements {
	private static final Logger LOGGER = Logger.getLogger(RotateArrayByNElements.class.getName());

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7 };
		int[] rotatedArray = rotateUsingNewArray(array, 25);
		LOGGER.info(Arrays.toString(rotatedArray));
		rotateArrayWithoutUsingExtraSpace(array, 25);
		LOGGER.info(Arrays.toString(array));

		int arrayDup[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateUsingTempArray(arrayDup, 25);
		LOGGER.info(Arrays.toString(arrayDup));

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateUsingGCD(arr, 25);
		LOGGER.info(Arrays.toString(arr));
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
	private static int[] rotateUsingNewArray(int[] array, int numberOfElementsToRotate) {
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
	private static void rotateUsingTempArray(int[] array, int numberOfElementsToRotate) {
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
	private static void rotateArrayWithoutUsingExtraSpace(int[] array, int numberOfElementsToRotate) {
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
	private static void rotateUsingGCD(int[] array, int numberOfElementsToRotate) {
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

	private static int getGCD(int numberOfElementsToBeRotated, int arraySize) {
		if (arraySize == 0)
			return numberOfElementsToBeRotated;

		return getGCD(arraySize, numberOfElementsToBeRotated % arraySize);
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
