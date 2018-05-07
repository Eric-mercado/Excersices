public class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[left..medium]
    // Second subarray is arr[medium+1..rigth]
    void merge(int arr[], int left, int medium, int rigth)
    {
        // Find sizes of two subarrays to be merged
        int size1 = medium - left + 1;
        int size2 = rigth - medium;

        /* Create temp arrays */
        int LeftArray[] = new int [size1];
        int RightArray[] = new int [size2];

        /*Copy data to temp arrays*/
        for (int i=0; i<size1; ++i)
            LeftArray[i] = arr[left + i];
        for (int j=0; j<size2; ++j)
            RightArray[j] = arr[medium + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < size1 && j < size2)
        {
            if (LeftArray[i] <= RightArray[j])
            {
                arr[k] = LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of LeftArray[] if any */
        while (i < size1)
        {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of RightArray[] if any */
        while (j < size2)
        {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}