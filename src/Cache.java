import java.util.ArrayList;

public class Cache {
    ArrayList<Block> cache;
    final int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>();
    }

    public void put(int value) {
        // check if the cache is already full
        if (this.cache.size() == this.capacity) {
            // find and remove the least frequently used block
            // or oldest block if there are multiple least frequency
            Block removedBlock = findLFU();
            this.cache.remove(removedBlock);
            System.out.println("Removed " + removedBlock + " from cache");
        }

        // check if the cache already contains the same block
        Block proposedblock = new Block(value);
        for (Block block : this.cache) {
            System.out.println("looping");
            if (block.value == proposedblock.value) {
                // get the index of the proposed block in cache 
                // and increase its frequency
                System.out.println("This value is already in cache!");
                block.frequency++;
                updateAge();
    
            } else {
                // put the proposed block into the cache
                System.out.println("added new value");
                this.cache.add(proposedblock);
                updateAge();
                System.out.println("putting " + value);
            }
        }

    }

    private void updateAge() {
        // this method will increment each block age
        this.cache.forEach((block) -> block.age++);
    }

    private Block findLFU() {
        // find least frequently used block
        ArrayList<Block> leastUsedBlocks = new ArrayList<>();
        Block tempLeastFreqUsedBlock = new Block(0);
        int tempLeastFreq = Integer.MAX_VALUE;
        for (Block block : this.cache) {
            if (block.frequency < tempLeastFreq) {
                leastUsedBlocks.clear();
                tempLeastFreq = block.frequency;
                tempLeastFreqUsedBlock = block;

            } else if (block.frequency == tempLeastFreq) {
                leastUsedBlocks.add(block);
            }
        }
        Block removedBlock = tempLeastFreqUsedBlock;

        // find the oldest lFU block if there are
        // multiple least frequently used block
        int tempOldest = Integer.MIN_VALUE;
        Block tempOldestBlock = new Block(0);
        if (!leastUsedBlocks.isEmpty()) {
            for (Block block : leastUsedBlocks) {
                if (block.age > tempOldest) {
                    tempOldest = block.age;
                    tempOldestBlock = block;
                }
            }
            removedBlock = tempOldestBlock;
        }

        return removedBlock;
    }
}
