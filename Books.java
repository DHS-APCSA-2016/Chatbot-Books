/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Books
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello, my name is Booktopia";
    }
    //Lines 33 - 185 fufill requirement #2
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        //fufills requirement #4i
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }

        else if (findKeyword(statement, "no") >= 0)
        {
            response = "What do you like?";
        }
        else if (findKeyword(statement, "recommend") >= 0)
        {
            response = "Have you read the Harry Potter series?";
        }
        else if (findKeyword(statement, "17") >= 0)
        {
            response = "Young adult books are really popular for your age.";
        }
        else if (findKeyword(statement, "8") >= 0)
        {
            response = "Children's books are really popular for your age.";
        }
        else if (findKeyword(statement, "read") >= 0
        || findKeyword(statement, "reading") >= 0)
        {
            response = "I love to read!";
        }
        else if (findKeyword(statement, "classics") >= 0
        || findKeyword(statement, "classic") >= 0)
        {
            response = "Little House on  the Praire";
        }
        else if (findKeyword(statement, "dumb") >= 0)
        {
            response = "Twilight";
        }
        else if (findKeyword(statement, "important") >= 0)
        {
            response = "Diary of Anne Frank";
        }
        else if (findKeyword(statement, "religious") >= 0)
        {
            response = "Bible";
        }
        else if (findKeyword(statement, "scary") >= 0)
        {
            response = "Goosebumps";
        }
        else if (findKeyword(statement, "fantasy") >= 0)
        {
            response = "The Lord of the Rings";
        }
           else if (findKeyword(statement, "children") >= 0)
        {
            response = "Magic Tree House";
        }
           else if (findKeyword(statement, "successful") >= 0)
        {
            response = "Harry Potter";
        }
           else if (findKeyword(statement, "comics") >= 0
           || findKeyword(statement, "comic") >= 0)
        {
            response = "A comic is a book.";
        }
           else if (findKeyword(statement, "hi") >= 0)
        {
            response = "Do you like books?";
        }
           else if (findKeyword(statement, "never") >= 0)
        {
            response = "Wow, grab one and read it!";
        }
           else if (findKeyword(statement, "hate") >= 0)
        {
            response = "Books are good for growing and you can learn from books.";
        }
           else if (findKeyword(statement, "nonfiction") >= 0)
        {
            response = "Nonfiction books are hard for me.";
        }
        
           else if (findKeyword(statement, "fiction") >= 0)
        {
            response = "I love fiction books!";
        }      
           else if (findKeyword(statement, "biography") >= 0
           || findKeyword(statement, "biographies") >= 0)
        {
            response = "Biographies tell us about a person's life from someone else's point of view.";
        }
           else if (findKeyword(statement, "autpbiography") >= 0
           || findKeyword(statement, "autobiographies") >= 0)
        {
            response = "Autoiographies tell us about a person's life from their point of view.";
        }
           else if (findKeyword(statement, "percentage") >= 0)
        {
            response = "I don't know.";
        }
        else if (findKeyword(statement, "yes") >= 0)
        {
            response = "Cool! Me too.";
        }
         else if (findKeyword(statement, "adventure") >= 0)
        {
            response = "Into the Wild";
        }
         else if (findKeyword(statement, "childish") >= 0)
        {
            response = "Diary of a Whimpy Kid";
        }
         else if (findKeyword(statement, "horror") >= 0)
        {
            response = "Frankenstein";
        }
         else if (findKeyword(statement, "popular") >= 0)
        {
            response = "The Hunger Games";
        }
         else if (findKeyword(statement, "The Hunger Games") >= 0)
        {
            response = "Maze Runner";
        }
         else if (findKeyword(statement, "Maze Runner") >= 0)
        {
            response = "Divergent";
        }
         else if (findKeyword(statement, "Divergent") >= 0)
        {
            response = "Young Adult Novel by Veronica Roth";
        }
         else if (findKeyword(statement, "Computer Science") >= 0)
        {
            response = "The Barron's book is helpful";
        }
         else if (findKeyword(statement, "timeless") >= 0)
        {
            response = "To kill a Mockinbird";
        }
         else if (findKeyword(statement, "romantic") >= 0)
        {
            response = "Nicholas Sparks is an author of many romantic novels, such as the The Notebook";
        }
         else if (findKeyword(statement, "The Notebook") >= 0)
        {
            response = "A romantic novel by Nicholas Sparks";
        }
         else if (findKeyword(statement, "pages") >= 0)
        {
            response = "Find out for yourself!";
        }
        
        else if (findKeyword(statement, "do you", 0) >= 0){
                int psn = findKeyword(statement, "do", 0);
                if (psn >= 0
                        && findKeyword(statement, "like", psn) >= 0){
                    response = transformDoYouLikeStatement(statement);
                }
        }
        else if (findKeyword(statement, "why do you", 0) >= 0){
            int psn = findKeyword(statement, "why", 0);
                if (psn >= 0
                        && findKeyword(statement, "like", psn) >= 0){
                    response = transformWhyDoYouLikeStatement(statement);
                }
        }
          else if (findKeyword(statement, "like", 0) >= 0){
              response = transformLikeStatement(statement);
        }
        //fufills requirement #4iv
        else if (findKeyword(statement, "I love", 0) >= 0){
                int psn = findKeyword(statement, "I", 0);
                if (psn >= 0
                        && findKeyword(statement, "love", psn) >= 0){
                    response = transformLoveStatement(statement);
                }
        }
        //transform responses
        // Responses which require transformations
        
        
        
        else if(findKeyword(statement, "I", 0) >= 0){
            // Look for a two word (I <something> you)
            // pattern
            int psn = findKeyword(statement, "I", 0);

            if (psn >= 0
                    && findKeyword(statement, "you", psn) >= 0){
                response = transformIYouStatement(statement);
            }
            else{
                response = getRandomResponse();
            }
        }
        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);

            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0){
                response = transformYouMeStatement(statement);
            }
            else{
                response = getRandomResponse();
            }
        }
        return response;
    }
    
        /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    //fufills requirement #4ii
    //Transform User's 'Do you like' statement 
    private String transformDoYouLikeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "Do you", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Yes I " + restOfStatement + ".";
    }
    //Transforms User's 'I like' statement 
        private String transformLikeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I", 0);
        String restOfStatement = statement.substring(psn + 1).trim();
        return "Are you sure you " + restOfStatement + "?";
    }
    //Transforms User's 'I love' statement 
       private String transformLoveStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I", 0);
        String restOfStatement = statement.substring(psn + 1).trim();
        return "Are you sure you " + restOfStatement + "?";
    }
    //Transforms User's 'Why do you like' statement 
        private String transformWhyDoYouLikeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "Why do you", 0);
        String restOfStatement = statement.substring(psn + 10).trim();
        return "I like " + restOfStatement + "because authors communicate through them.";
    }
    //Transforms User's 'I, You' statement 
    private String transformIYouStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfI = findKeyword (statement, "I", 0);
        int psnOfYou = findKeyword (statement, "you", psnOfI + 1);
        
        String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
        return "Why do you " + restOfStatement + " me?";
    }
    
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    //
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    //Finds the keyword
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
   
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    //gets a random response from 11 different possible responses
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 11;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "What other books do you like?";
        }
        else if (whichResponse == 3)
        {
            response = "Can you repeat that?";
        }
        else if (whichResponse == 4)
        {
            response = "BOOKS!";
        }
        else if (whichResponse == 5)
        {
            response = "Who knows...";
        }
        else if (whichResponse == 6)
        {
            response = "Any other books?";
        }
        else if (whichResponse == 7)
        {
            response = "What series do you like?";
        }
        else if (whichResponse == 8)
        {
            response = "Books are amazing educational resources.";
        }
        else if (whichResponse == 9)
        {
            response = "I learned a lot from books. Did you?";
        }
        else if (whichResponse == 10)
        {
            response = "What books are you reading now?";
        }

        return response;
    }

}