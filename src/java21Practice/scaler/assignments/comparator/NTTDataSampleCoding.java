package scaler.assignments.comparator;

public class NTTDataSampleCoding {
    //binary search
    static void main(String args[]) {
        int [] nums = new int[]{2,3,3,5,5,5,5,9,10,12};
        int target = 5;
        NTTDataSampleCoding n = new NTTDataSampleCoding();
        int index = n.bsWithRepeatedNumbers(nums,target);
        System.out.println(index);

    }
    //repeat numbers in array, return lowest index
    public int bsWithRepeatedNumbers(int nums[],int target){
        int ans_index = -1;
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid = hi - (hi-lo)/2 ;
            if(nums[mid]== target){
                ans_index = mid;
                hi= mid -1;
            }else if(nums[mid] <target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return ans_index;
    }
    record Address(String street, String city , String zipCode){
        public Address(String city, String zipCode){
            this("",city,zipCode);
        }
        public Address{//compact canonical constructor
            if(street ==null){
                street ="";
            }
        }
    }
    record Person(String name, Address address){}
    //shallow copy vs deep copy
    public void shallowVsDeepCopying(){
        Person p1 = new Person("Ajay",new Address("Frisco","75034"));
        Person p2 = p1;//p2 is a shallow copy of p1
        p2 = new Person(p1.name(),p1.address());

    }
}
