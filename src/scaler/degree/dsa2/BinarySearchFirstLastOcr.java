package scaler.degree.dsa2;

public class BinarySearchFirstLastOcr {
    public static int[] searchRange(int[] A, int target){
        int firstIndex = binarySearchFirstOcr(A,target,true);
        int lastIndex = binarySearchFirstOcr(A,target,false);
        int[] output = new int[]{firstIndex,lastIndex};
        return output;
    }

    private static int binarySearchFirstOcr(int[] A,int target,boolean isFirst){
        int lo=0,hi=A.length-1;
        int firstOcr=-1;
        int lastOcr = -1;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(A[mid]==target){
                if(isFirst) {
                    firstOcr = mid;
                    hi = mid - 1;
                }else{
                    lastOcr = mid;
                    lo = mid+1;
                }
            }else if(A[mid] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        if(isFirst) {
            return firstOcr;
        }
        return lastOcr;
    }

    static void main() {
        int[] A = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] out =searchRange(A,target);
        for(int i : out){
            System.out.println(i);
        }
     }
//    @ParameterizedTest(name = "{index} → input={0},target={1}, expected={2}")
//    @MethodSource("testCasesSearchRange")
//    void testAllCases_searchRange(int[] input, int target, int[] expected) {
//        assertEquals(expected, BinarySearchFirstLastOcr.searchRange(input, target));
//    }

//    static Stream<Arguments> testCasesSearchRange() {
//        return Stream.of(
//                Arguments.of(new int[]{-1,2,2,3,3,6,6,9}, 0, new int[]{-1,-1}),
//                Arguments.of(new int[]{1,2,2,2,2,3,3,11}, 2, new int[]{1,4}), //negative test
//                Arguments.of(new int[]{1,2,2,2,3,5,6}, 2, new int[]{1,3}),
//                Arguments.of(new int[]{0,1,2,7}, 3, new int[]{-1,-1}),
//                Arguments.of(new int[]{5,7,7,8,8,10}, 8, new int[]{3,4}),
//                Arguments.of(new int[]{5,7,7,8,8,8,8,10,10,10,12}, 10, new int[]{7,9}),
//                Arguments.of(new int[]{5,7,7,8,10,10,12}, 8, new int[]{3,3}),
//                Arguments.of(new int[]{5,7,7,7,7,10,10,12}, 7, new int[]{1,4})
//        );
//    }
}
