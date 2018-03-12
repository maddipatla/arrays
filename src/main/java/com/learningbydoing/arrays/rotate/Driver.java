/**
 * 
 */
package com.learningbydoing.arrays.rotate;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author Maddipatla Chandra Babu
 * @date 12-Mar-2018
 */
public class Driver {
	private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

	/**
	 * Driver method to run the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7 };
		int[] rotatedArray = ArrayRotationByNElements.rotateUsingNewArray(array, 25);
		LOGGER.info(Arrays.toString(rotatedArray));
		ArrayRotationByNElements.rotateArrayWithoutUsingExtraSpace(array, 25);
		LOGGER.info(Arrays.toString(array));

		int arrayDup[] = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayRotationByNElements.rotateUsingTempArray(arrayDup, 25);
		LOGGER.info(Arrays.toString(arrayDup));

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayRotationByNElements.rotateUsingGCD(arr, 25);
		LOGGER.info(Arrays.toString(arr));

		int arrDup[] = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayRotationByNElements.rotateArrayUsingReversalAlgorithm(arrDup, 25);
		LOGGER.info(Arrays.toString(arrDup));
	}

}
