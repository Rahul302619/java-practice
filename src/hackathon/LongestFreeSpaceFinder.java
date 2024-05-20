package hackathon;

public class LongestFreeSpaceFinder {
    public static int findLongestFreeSpace(String sequence) {
        var lisOfSequence = sequence.split(" ");
        int startPosition = 0, count = 0, maxFreeSpaceStartPosition = 0, maxFreeSpaceStartPositionCount = 0;
        for(int i=0; i<lisOfSequence.length; i++) {
            if(lisOfSequence[i].equals("FREE")) {
                if(count == 0) startPosition = i;
                count++;
            } else if(maxFreeSpaceStartPositionCount<count){
                maxFreeSpaceStartPosition = startPosition;
                maxFreeSpaceStartPositionCount = count;
                count = 0;
            }
        }
        if(maxFreeSpaceStartPositionCount<count){
            maxFreeSpaceStartPosition = startPosition;
        }
        return maxFreeSpaceStartPosition + 1;
    }

    public static void main(String[] args) {
        String sequence = "FREE FREE FREE FREE TAKEN FREE FREE FREE";
        int startPosition = findLongestFreeSpace(sequence);
        System.out.println("Start position of the longest free space: " + startPosition);
    }
}

