import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The class Dictionary implements a dictionary ADT with a binary search tree.
 * The dictionary stores words and their definitions. Precondition: all words
 * are distinct.
 *
 * @author Mohammed Alfarra, 6368950, U02
 */
public class Dictionary
{

    private BinarySearchTree bst; //dictionary is stored here, sorted on words

    /**
     * Parameterized constructor, reads given textfile with dictionary info into
     * the class variable bst, a binary search tree. All letters will be
     * converted to lowercase before adding to dictionary.
     *
     * @param inputFilename name of input file with dictionary info
     */
    public Dictionary(String inputFilename)
    {
        bst = new BinarySearchTree();

        //read file and store it in the binary search tree
        File file = new File(inputFilename);

        try
        {
            Scanner input = new Scanner(file);

            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] tokens = line.split(": ");

                bst.add(new ElementType(tokens[0].toLowerCase(), tokens[1].toLowerCase()));
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Dictionary file not found!");
            System.exit(1);
        }
    }

    /**
     * Adds a new entry to this dictionary. All letters will be converted to
     * lowercase before adding to dictionary.
     *
     * @param word word to be added
     * @param meaning meaning of the given word
     */
    public void add(String word, String meaning)
    {
        ElementType entry = new ElementType(word.toLowerCase(), meaning.toLowerCase());
        bst.add(entry);
    }

    /**
     * Determines if a given word is defined in the dictionary.
     *
     * @param word given word
     * @return true if given word is defined in the dictionary, false otherwise
     */
    public boolean contain(String word)
    {
        return bst.contain(word.toLowerCase());
    }

    /**
     * If given word is defined in the dictionary, meaning of word is returned;
     * otherwise, empty string is returned.
     *
     * @param word given word
     * @return meaning of given word if word is defined in dictionary; empty
     * string otherwise
     */
    public String find(String word)
    {

        return bst.find(word.toLowerCase());
    }

    /**
     * Returns the number of elements in the binary search tree.
     *
     * @return the number of elements in the binary search tree
     */
    public int getNumberOfWords()
    {
        return bst.getCount();
    }

    /**
     * Determines if this dictionary is empty. The method takes O(1) time.
     *
     * @return true if the dictionary contains no elements, false otherwise
     */
    public boolean isEmpty()
    {
        return bst.isEmpty();
    }

    /**
     * If given word is found in the dictionary, it replaces its meaning with
     * the given one and a value of TRUE is returned; otherwise FALSE is
     * returned. All letters in the meaning string will be converted to
     * lowercase before replacement occurs.
     *
     * @param word given word
     * @param meaning given meaning
     * @return true if replacement is successful, false otherwise
     */
    public boolean replace(String word, String meaning)
    {
        return bst.replace(word.toLowerCase(), meaning.toLowerCase());
    }

    /**
     * Builds a String description of this dictionary.
     *
     * @return String containing the dictionary elements
     */
    public String toString()
    {
        return bst.toString();
    }
}

