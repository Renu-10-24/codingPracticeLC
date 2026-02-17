package striversatoz.binarySearch;

class FindStartAndEndIndicesOfTarget {
    public int[] searchRange(int[] nums, int target) {


        boolean isFirst = true;

        int firstOcr = binarySearchFindBound(nums, target,isFirst);
        if (firstOcr == -1) {
            return new int[] { -1, -1 };
        }
        int endOcr = binarySearchFindBound(nums, target,!isFirst);
        return new int[]{firstOcr, endOcr};
    }

    //linear seach scanning for each element from mid towards left and right , no effective, we have to optimize by finding the
    //start and end indices of target in the array with a second binarySearch

    // while (minStartIndex >= 0 && minStartIndex == target) {
    //     minStartIndex--;
    // }
    // while (maxEndIndex <= hi && maxEndIndex == target) {
    //     maxEndIndex++;
    // }
    // if (target == nums[maxEndIndex] && target == nums[minStartIndex]) {
    //     return new int[] { minStartIndex++, maxEndIndex-- };
    // }
    // return new int[] { -1, -1 };
//}

    public int binarySearchFindBound(int[] nums, int target,  boolean isFirst) {
        // int begin, end  = -1;
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid; // mid is the start index of target
                    }
                    // search on the left side of array
                    end = mid - 1;
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid; // mid is the end index of target
                    }
                    begin = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    static void main() {
        FindStartAndEndIndicesOfTarget f = new FindStartAndEndIndicesOfTarget();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int [] out = f.searchRange(nums,target);
        System.out.println("start : "+out[0]+" end : "+out[1]);
        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        out = f.searchRange(nums,target);
        for(int i : out)
            System.out.println(i);
    }
}