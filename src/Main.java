
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tester class.
 *
 * @author Mohammed Alfarra, 6368950, U02
 */
public class Main
{

    public Main()
    {
        System.out.println("Test starts");

        Dictionary dictionary = new Dictionary("shuffled dictionary.txt");

        File file = new File("assignment 3 test set.txt");

        try
        {
            Scanner in = new Scanner(file);

            String operation = "", item = "";
            int entryNumber = 0;
            while (in.hasNextLine())
            {
                entryNumber++;
                operation = in.next();
                if (operation.equals("IS_EMPTY")
                        || operation.equals("NUMBER_OF_WORDS"))
                    System.out.print("\n" + operation + ": ");
                else
                {
                    item = in.nextLine().trim();
                    System.out.println("\n" + operation + " " + item);
                }

                switch (operation)
                {
                    case "ADD":
                        dictionary.add(item, "definition TBD");
                        System.out.println("Word without definition added!");
                        break;
                    case "CONTAIN":
                        System.out.println(dictionary.contain(item));
                        break;
                    case "FIND":
                        String def = dictionary.find(item);
                        String out = def.equals("") ? "not found!" : def;
                        System.out.println(out);
                        break;
                    case "IS_EMPTY":
                        System.out.println(dictionary.isEmpty());
                        break;
                    case "NUMBER_OF_WORDS":
                        System.out.println(dictionary.getNumberOfWords());
                        break;
                    case "REPLACE":
                        String[] tokens = item.split(": ");
                        if (dictionary.replace(tokens[0], tokens[1]))
                            System.out.println("Replaced!");
                        else
                            System.out.println("word " + tokens[0]
                                    + " not found");
                        break;
                    case "PRINT":
                        System.out.println(dictionary);
                        break;
                    default:
                        System.out.println("Operation \"" + operation + "\" unknown at line " + entryNumber);
                        System.exit(1);
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            System.exit(1);
        }

        System.out.println("Test ends");
    }

    public static void main(String[] args)
    {
        new Main();
    }
}

