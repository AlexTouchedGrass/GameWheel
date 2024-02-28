import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameWheel {
    private List<Slice> slices;

    // Creates a GameWheel with 20 slices
    public GameWheel() {
        slices = new ArrayList<>();
        initializeSlices();
    }

    // Initializes the slices with specified colors and prize values
    private void initializeSlices() {
        for (int i = 0; i < 20; i++) {
            String color;
            int prizeAmount;

            if (i % 5 == 0 && i != 0) {
                // Black color slices at positions 0, 5, 10, 15
                color = "Black";
                prizeAmount = 1000 * i;
            } else if (i % 2 == 1) {
                // Red color slices for odd indices
                color = "Red";
                prizeAmount = 200 * i;
            } else {
                // Blue color slices for even indices
                color = "Blue";
                prizeAmount = 100 * i;
            }

            slices.add(new Slice(color, prizeAmount));
        }
    }

    // Returns the slice at a given position
    public Slice getSlice(int position) {
        return slices.get(position);
    }

    // Scrambles the order of slices
    public void scramble() {
        Collections.shuffle(slices);
    }

    // Sorts the slices based on their prize amounts
    public void sort() {
        Collections.sort(slices, (slice1, slice2) -> Integer.compare(slice1.getPrizeAmount(), slice2.getPrizeAmount()));
    }

    // Returns a string representation of the GameWheel
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("GameWheel Slices:\n");
        for (Slice slice : slices) {
            result.append(slice).append("\n");
        }
        return result.toString();
    }
}
