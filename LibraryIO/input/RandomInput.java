package LibraryIO.input;

import java.util.Random;

public class RandomInput {
    private int sequenceLength = 100;

    /**
     * The getData method creates and returns a new sequence of randomly generated DNA
     * @return generated data as string
     */
    public String getData() {
        Random newNum = new Random();
        StringBuilder sequence = new StringBuilder();
        String possibleChars = "AGCT";
        for(int i = 0; i < getSequenceLength(); i++)
        {
            sequence.append(possibleChars.charAt(newNum.nextInt(4)));
        }
        return sequence.toString();
    }

    /**
     * The get SequenceLength method returns the sequence length
     * @return sequence length
     */
    private int getSequenceLength(){
        return this.sequenceLength;
    }

    /**
     * The setSequenceLength methods sets the sequence length
     * @param numIn new value for sequence length
     */
    public void setSequenceLength(int numIn){
        this.sequenceLength = numIn;
    }
}