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
