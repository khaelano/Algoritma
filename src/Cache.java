import java.util.ArrayList;

public class Cache {
    ArrayList<Block> cache;
    final int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>();
    }

    public void put(int value) {
        Block proposedBlock = new Block(value);
        // search if there are any block contains the same
        // value as the proposed block
        boolean isSameValue = false;
        int sameValueIndex = 0;
        for (Block block : this.cache) {
            if (block.value == proposedBlock.value) {
                // get the index of the proposed block in cache 
                isSameValue = true;
                sameValueIndex = this.cache.indexOf(block);
            }
        }

        // check if the cache is already full
        if (this.cache.size() == this.capacity && isSameValue != true) {
            // find and remove the least frequently used block
            // or oldest block if there are multiple least frequency
            Block removedBlock = findLFU();
            this.cache.remove(removedBlock);
            System.out.println("Removed " + removedBlock.value + " from cache");
        }

        // check if the cache already contains the same block
        if (this.cache.size() != 0) {
            if (isSameValue) {
                // if the cache contains the same value
                System.out.println("This value is already in cache!");
                this.cache.get(sameValueIndex).frequency++;
                updateAge();
            } else {
                this.cache.add(proposedBlock);
                updateAge();
            }

        } else {
            // put the proposed block into the cache
            this.cache.add(proposedBlock);
            updateAge();
        }

    }

    public Block see(int index) {
        return this.cache.get(index);
    }

    public boolean isEmpty() {
        return this.cache.isEmpty();
    }
    
    private void updateAge() {
        // this method will increment each block age
        this.cache.forEach((block) -> block.age++);
    }

    private Block findLFU() {
        // find least frequently used block
        ArrayList<Block> leastUsedBlocks = new ArrayList<>();
        int tempLeastFreq = Integer.MAX_VALUE;
        for (Block block : this.cache) {
            if (block.frequency < tempLeastFreq) {
                leastUsedBlocks.clear();
                tempLeastFreq = block.frequency;
                leastUsedBlocks.add(block);

            } else if (block.frequency == tempLeastFreq) {
                leastUsedBlocks.add(block);
            }
        }
        return leastUsedBlocks.get(0);
    }
}
