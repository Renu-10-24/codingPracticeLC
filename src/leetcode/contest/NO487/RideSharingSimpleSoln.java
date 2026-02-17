package contest.NO487;

import java.util.*;

public class RideSharingSimpleSoln {
    RideSharingSystem r = new RideSharingSystem();

//  r.addRider(riderId);
//  r.addDriver(driverId);
//  int[] param_3 = r.matchDriverWithRider();
//  obj.cancelRider(r);
}
class RideSharingSystem {
    Queue<Integer> riderQ = new ArrayDeque<>();
    Queue<Integer> driverQ = new ArrayDeque<>();
    public RideSharingSystem() {
        //no initialization
    }

    public void addRider(int riderId) {
        riderQ.add(riderId);
    }

    public void addDriver(int driverId) {
        driverQ.add(driverId);
    }

    public int[] matchDriverWithRider() {
        int[] matched = new int[2];
        if(!driverQ.isEmpty() && !riderQ.isEmpty()){
            int driver = driverQ.remove();
            int rider = riderQ.remove();

            matched[0]=driver;
            matched[1]=rider;
        }
        return  matched;
    }

    public void cancelRider(int riderId) {
        if(riderQ.contains(riderId)){
            riderQ.remove(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */