// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

/**
 * Represents a DynamicArray
 */
public class DynamicArray<T> implements IndexAccess<T>{

    /** Generic array for Objects */
    private T[] array;

    /** Offset amount for array elements */
    private int offset;

    /**
     * Constructor for defining instance variables
     * @param offset offset amount for array elements
     * @param initialArray array to copy elements
     */
    public DynamicArray(int offset, T[] initialArray) {
        this.array = (T[]) new Object[initialArray.length];

        for (int i = 0; i < initialArray.length; i++) {
            array[i] = initialArray[i];
        }
        
        this.offset = offset;
    }

    /** Returns the value stored at a given index
     * @param i index of element to read
     * @return value stored at the given index
     */
    public T get(int i) {
        int offsetIndex = i - offset;

        if (offsetIndex < 0) {
            offsetIndex = (offsetIndex + array.length) % array.length;
        }

        if (offsetIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Index " + offsetIndex + "out of bounds.");
        }
        return array[offsetIndex];
    }

    /** Returns the value stored at a given index plus the offset
     * @param i index of element to read
     * @param offset adjust index by this value
     * @return value stored at the given index
     */
    public T get(int i, int offset) {
        if (i + offset < 0 || i + offset >= array.length) {
            throw new ArrayIndexOutOfBoundsException(i + offset);
        }
        return array[i + offset];
    }

    /** Stores the given value at the given index
     * @param i index of location to store
     * @param val value to store at given index
     */
    public void set(int i, T val) {
        if (i < 0 || i >= array.length) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        array[i] = val;
    }

    /**
     * Returns a String containing all elements of an array
     * @return a String containing all elements of an array
     */
    public String toString() {
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string += array[i] + "\n";
        }
        return string;
    }
}