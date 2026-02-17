package walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 public class DuplicatesWithMergeSort {
         public int findDuplicate(int[] nums) {
             int[] nums_sorted = Arrays.stream(nums).sorted().toArray();

             for(int i : nums_sorted ){
                 System.out.println("sorted  : "+i);
             }
             for(int i=1;i<nums_sorted.length;i++){
                 if(nums_sorted[i] == nums_sorted[i-1]){
                     return nums_sorted[i];
                 }
             }
             return -1;
         }

         public List<Integer> mergeSort(List<Integer> list){
             List<Integer> out = new ArrayList<>();
             if(list.size()==1 || list.size()==0){
                 return list;
             }
             List<Integer> firstHalf = list.subList(0, list.size()/2);
             List<Integer> secHalf = list.subList(list.size()/2,list.size());
             List<Integer> sortedFirstHalf = mergeSort(firstHalf);
             List<Integer> sortedSecHalf = mergeSort(secHalf);

             int i=0, j = 0;
             for(;i<sortedFirstHalf.size() && j<sortedSecHalf.size();) {
                 if (sortedFirstHalf.get(i) <= sortedSecHalf.get(j)) {
                     out.add(sortedFirstHalf.get(i++));
                 } else {
                     out.add(sortedSecHalf.get(j++));
                 }
             }
                 while(i<sortedFirstHalf.size()){
                     out.add(sortedFirstHalf.get(i++));
                 }
                 while(j<sortedSecHalf.size()){
                     out.add(sortedSecHalf.get(j++));
                 }
             return out;
             }


         //xoring 1 to N twice except for one number -> gives that number
         public int findDuplicate_xor(int[] nums) {
             int xor = 0;
             for(int i=0;i<nums.length;i++){
                 xor = xor^nums[i]^(i+1);
             }
             int answer = xor^(nums.length);
             System.out.println(answer+" frm xor method ");
             return answer;
         }



    static void main() {

//        int[] nums = new int[]{3,1,3,4,2};
        int[] nums = new int[]{3813,8229,15919,16146,19061,26146,11849,28124,22288,19711,6050,27586,25607,4226,16366,28307,19954,6764,27118,17464,21581,6627,9221,26702,15971,24298,23098,21967,26853,23008,14622,27549,1590,9776,8537,22716,23037,12719,19716,8266,9230,6897,22429,21539,18852,3470,8434,10895,5146,14841,22687,29176,23650,29111,6678,17754,23144,7501,2303,26700,24078,29702,6072,22366,5340,19726,16081,4594,2514,12237,12857,21376,4075,4867,25623,14322,5627,19661,29576,9735,17093,21938,11584,29387,27764,13154,28581,6634,29503,17074,7536,21327,20982,26266,25593,6201,26210,13506,21860,22228,12345,8854,18668,28127,815,11424,29167,8703,11327,16182,28450,12293,23438,18703,16766,13554,3268,19702,25420,19723,14355,9040,18287,29064,1387,29082,29847,16443,5329,29895,19808,10759,25715,15645,17198,23159,18070,22372,26576,20985,26907,17000,10087,18108,15584,7404,19051,12314,15799,29228,12743,23402,23869,11007,11543,931,5000,10879,24942,26556,19238,26741,24944,29866,13096,19510,4865,12506,7463,11430,17993,2896,5621,1974,27184,6974,22256,8256,16731,23503,26335,20273,8608,3909,23546,13144,16979,4572,21991,14783,4629,28087,21875,18592,11179,13478,24519,25320,13119,19803,2934,8173,5394,22077,29669,24426,14468,14216,6199,4731,22827,28375,4882,16999,14444,20250,2686,23113,5083,16203,29295,20495,22406,8422,16487,11370,22127,23316,8914,21535,17144,29394,25888,7068,28082,28342,13482,27902,13006,1951,12529,20776,13721,10117,3184,4747,1319,20572,4499,484,1698,20974,1636,15585,11268,6143,29542,20960,18696,29993,24747,23542,15826,22677,9463,20719,3504,22820,26296,23143,15823,16281,29597,2577,10239,22908,9583,22678,10278,8845,16169,2511,22131,14891,18105,28177,17836,15401,24163,27160,17126,13279,6233,4743,29945,1893,14048,9210,24767,11244,11118,16843,17540,14873,757,15363,28765,19967,10713,8569,24676,18551,28117,8912,3295,2679,18504,15};
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        DuplicatesWithMergeSort ms = new DuplicatesWithMergeSort();
        List<Integer> out = ms.mergeSort(list);
        int ans = ms.findDuplicate(nums);
        System.out.println("ans duplicate  : "+ans);
//
//        System.out.println("out : "+out);
//        nums = new int[]{3,1,3,4,2};
//        ans = ms.findDuplicate_xor(nums);
//        System.out.println("ans duplicate : "+ans);
//        nums = new int []{1,3,4,2,2};
//        ans = ms.findDuplicate(nums);
//        System.out.println("ans duplicate  : "+ans);
//        //xoring works on inputs that look like this : 1,2,4,4,5
//        nums = new int[]{1,2,4,4,5};
//        ans = ms.findDuplicate_xor(nums);
//        System.out.println("ans duplicate : "+ans);
    }
}