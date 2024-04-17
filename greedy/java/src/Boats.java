import java.util.Arrays;

class Boats {
    public static int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length - 1;

        Arrays.sort(people);

        int boats = 0;
        while(l <= r) {
            // fit two people in one boat
            if(people[r] + people[l] <= limit){
                l++;
                r--;
            }
            // only fit the heaviest
            else if(people[r] <= limit){
                r--;
            }
            else{
                l++;
            }
            boats++;
        }

        return boats;
    }
}
