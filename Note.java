
import java.util.HashMap;

/**
 * @author Sarah Wagner
 * @version 1.0
 * This is the builder class. This creates the Note class. The methods below involve
 * finding the letter associated with a value, the frequency of a note, and the octave
 * the note is found in.
 */
public class Note {

    // DATA has to be private
    private int value; // holds the user's input
    private String length; // holds the length the user input
    private HashMap<Integer, String> noteNum; // declares a hashmap


    // METHODS has to be public

    //constructors

    /**
     * This is the default class. It wil set the value to 0, the length to a quarter note
     * and fills in the hashMap declared above.
     */
    public Note() // this is the default version
    {
        this.value =  0; // this is A4 above middle C
        this.length = "quarter note";
        noteNum = new HashMap<Integer, String>();
        populateNoteNum();

    } // end of note constructor

    /**
     * @param value    this is the integer value the user has entered
     * @param length    this is the String value the user entered for the length of the note
     * This method also populates the hashMap.
     */
    public Note(int value, String length)
    {
        setValue(value);
        setLength(length);
        noteNum = new HashMap<Integer, String>();
        populateNoteNum();
    } // end of note constructor

    /**
     * This is a method that doesn't need paramters or returns anything. It populates the hashMap declared earlier
     * with the key values. The key is the value the user enters and the value is the letter that corresponds to it.
     * 0 is A because A4 is the middle of an 88 key piano.
     */
    private void populateNoteNum()
    {
        noteNum.put(0, "A");
        noteNum.put(1, "A#");
        noteNum.put(2, "B");
        noteNum.put(3, "C");
        noteNum.put(4, "C#");
        noteNum.put(5, "D");
        noteNum.put(6, "D#");
        noteNum.put(7, "E");
        noteNum.put(8, "F");
        noteNum.put(9, "F#");
        noteNum.put(10, "G");
        noteNum.put(11, "G#");
    } // end of populate method


    // getters

    /**
     * This gets the value from the user and returns it.
     * @return value
     */
    public int getValue()
    {
        return value;
    } // end of getValue method

    /**
     * This gets the length from the user and returns it.
     * @return length
     */
    public String getLength()
    {
        return length;
    } // end of getLength method

    /**
     * This gets the letter that corresponds to the value entered above. If the value is outside the range of
     * the hashMap, then it will cycle through adding or subtracting until the value is in range of the hashMap.
     * It will then return whatever letter is located at that value.
     * @return noteNum.get(index)
     */
    public String getLetter()
    {
        int index = value;
        while(index < 0) {
            index = index + 12;
        }
        while(index >= 12) {
            index = index - 12;
        }

        return noteNum.get(index);
    } // end of getLetter method

    /**
     * This is similar to the getLetter method. It adds or subtracts to the value until the value is in range of the
     * hashMap, however this will also keep a counter that counts every time 12 is added/subtracted. This will return
     * the octave value.
     * @return octave
     */
    public int getOctave() {
        int octave  = 4;
        int index = value;
        while(index < 0) {
            index = index + 12;
            octave--;
        }
        while(index >= 12) {
            index = index - 12;
            octave++;
        }


        return octave;
    } // end of getOctave method


    // setters

    /**
     * @param value   this is the initial value the user entered.
     * @return this.value=value  it will return the new value the user will set
     */

    public int setValue(int value)
    {
        return this.value = value;
    } // end of setvalue  method

    /**
     * @param length  this is the initial value the user entered
     * @return this.length = length   it will return the new value the user will set
     */
    public String setLength(String length)
    {
        return this.length = length;
    } // end of setLength method


    //toString

    /**
     * This is needed for the class to run. It will return a print statement if so desired.
     * @return
     */
    public String toString()
    {
        return "The note has a length of  " + this.length;
    } //end of toString method


    //other stuff...

    /**
     * This calculates the frequency of the note at the value entered by the user
     * @return 440*(Math.pow(2, product))
     */
    public double computeFrequency()
    {
        double product = (value/12.0);
        return 440*(Math.pow(2, product));
    } // end of computeFrequency method

    /**
     * This determines whether a note is sharp or natural. If it finds two chars used (i.e. A#) then the note
     * is sharp. If not (i.e. A), then the note is natural.
     * @return
     */
    public String naturalOrSharp()
    {
        if(getLetter().length() == 2)
        {
            return "Sharp";
        } // end of if
        else
        {
            return "Natural";
        } //end of else
    } // end of naturalOrSharp method



} // end of class



