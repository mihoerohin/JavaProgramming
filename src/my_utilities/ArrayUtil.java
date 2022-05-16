package my_utilities;

import java.util.Arrays;

public class ArrayUtil {



    
           // MIN number //

    public static int minNumber(int [] nums){

        int min = nums[0];

        for(int num : nums){
            if(num < min){
                min = num;
            }
        }
        return min;


    }


            //  MAX number //

    public static int minNumberSort(int [] nums){
        Arrays.sort(nums);
        return nums[0];
    }

    public static int maxNumber(int [] nums){

        int max = nums[0];

        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        return max;
    }




    public static int [] addElement(int [] original, int [] elementsToAdd) {
        int[] newArray = new int[original.length + elementsToAdd.length];

        for (int i = 0, j = 0; i < newArray.length; i++) {

            if (i < original.length) {

                newArray[i] = original[i];
            } else {
                newArray[i] = elementsToAdd[j++];
            }
        }

        return newArray;
    }


}

