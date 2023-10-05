import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache {
    private HashMap<Integer, Integer> freqMap = new HashMap<>();
    private HashMap<Integer, Integer> valMap = new HashMap<>();
    private HashMap<Integer, Integer> ageMap = new HashMap<>();
    int size;

    public Cache(int size) {
        this.size = size;
    }

    public int get(int key) {
        // get the value of specified key, but does not remove it from cache
        freqMap.put(key, freqMap.get(key) + 1);
        return valMap.get(key);
    }

    public int put(int key, int value) {
        // put new value and key pair
        if (valMap.containsKey(key) == true) {
            // if the key is already used, replace the value with the new one
            valMap.put(key, value);
            freqMap.put(key, freqMap.get(key) + 1);
            ageMap.put(key, 0);

            // update age for each elements
            ageMap.forEach((k, v) -> {v++; ageMap.replace(k, v);});
            System.out.printf("The value of %d is replaced with %d\n", key, value);

        } else {
            if (valMap.size() == size) {
                System.out.println("The cache is full, removing least frequently used entry");

                // get least frequently used key
                int leastFrequency = 1;
                List<Integer> leastFrequencyKeys = new ArrayList<Integer> ();
                for(HashMap.Entry<Integer, Integer> val : freqMap.entrySet()){
                    if (val.getValue() <= leastFrequency) {
                        leastFrequency = val.getValue();
                        leastFrequencyKeys.add(val.getKey());
                    }
                }

                // get oldest key
                // int oldestKey = 1;
                // for (int i : leastFrequencyKeys.size()) {

                // }

                int removedKey;

                // remove least frequently used entry
                System.out.printf("Removing key: %d with frequency: %d\n", leastFrequencyKey, leastFrequency);
                valMap.remove(removedKey);
                freqMap.remove(removedKey);
                ageMap.remove(removedKey);

                // add new entry
                valMap.put(key, value);
                freqMap.put(key, 1);
                ageMap.put(key, 0);

                // update age for each elements
                ageMap.forEach((k, v) -> {v++; ageMap.replace(k, v);});

                System.out.printf("The value of %d is replaced with %d\n", key, value);
                
            } else {
                valMap.put(key, value);
                freqMap.put(key, 1);
                ageMap.put(key, 0);

                // update age for each elements
                ageMap.forEach((k, v) -> {v++; ageMap.replace(k, v);});

            }
            
        }
        return 0;
    }

    public int retrieve(int key) {
        // get the value of specified key and remove it from cache
        // get the value
        valMap.get(key);
        freqMap.get(key);

        // remove entry from both value and frequency map
        valMap.remove(key);
        freqMap.remove(key);
        return 0; 
    }

    public int clearAll() {
        // clear all key and value of the cache
        valMap.clear();
        freqMap.clear();
        return 0;
    }
}
