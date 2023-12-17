
/**
 * This class represents the element in the nodes of the dictionary.
 *
 * @author Prof. A. Hernandez
 */
public class ElementType
{

    public String meaning; // meaning of the word
    public String word;    // word

    /**
     * Default constructor. Sets this object to a default element type.
     *
     */
    public ElementType()
    {
        word = "";
        meaning = "";
    }

    /**
     * Parameterized constructor.
     *
     * @param word value of the "word" component of this object
     * @param meaning value of the "meaning" component of this object
     */
    public ElementType(String word, String meaning)
    {
        this.word = word;
        this.meaning = meaning;
    }

}

