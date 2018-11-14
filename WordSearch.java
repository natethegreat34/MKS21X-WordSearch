import java.util.Random;
import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
  private char[][]data;

   //the random seed used to produce this WordSearch
   private int seed;

   //a random Object to unify your random calls
   private Random randgen;

   //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
   private ArrayLis<String>wordsToAdd;

   //all words that were successfully added get moved into wordsAdded.
   private ArrayList<String>wordsAdded;
   public WordSearch(int r, int c, String fileName, int seed, boolean answer){
     randgen = new Random (seed);
     clear ();
     wordsToAdd = getWords (fileName);
     addAllWords();
     fillInRandomLetters();
     try{
       File f = new File(fileName);//can combine
       Scanner in = new Scanner(f);//into one line

        while(in.hasNext()){
          String word = in.next();
          //do something with word
          System.out.println(word);
}

     }catch(FileNotFoundException e){
       System.out.println("File not found: " + fileName);
       //e.printStackTrace();
       System.exit(1);
     }
   }





    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int x = 0; x < data.length; x ++){
        for (int y = 0; y < data[x].length; y ++){
          data[x][y] = '_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
      String sad = "";
      for (int x = 0; x < data.length; x ++){
        sad = sad + '|';
        for (int y = 0; y < data[x].length; y ++){
          sad = sad + data [x][y] + " ";
        }
        sad = sad + "\n";
    }
    sad = sad + "Words: ";
    return sad;
  }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement){
if (Safe(r,c,word,rowIncrement,colIncrement) == false){return false;}
  if (rowIncrement == 1){
        if (colIncrement == 1){
           for (int i = 0; i < word.length(); col ++){
               data[r][c] = word.charAt(i);
               i ++;
               r ++;
             }
           }
        if (colIncrement == 0){
           for (int i = 0; i < word.length();){
               data[r][c] = word.charAt(i);
               i ++;
               r ++;
             }
         }
         if (colIncrement == -1){
           for (int i = 0; i < word.length(); col --){
               data[r][c] = word.charAt(i);
               i ++;
               r ++;
             }
         }
       }

  if (rowIncrement == 0){
         if (colIncrement == 1){
           for (int i = 0; i < word.length(); col ++){
               data[r][c] = word.charAt(i);
               i ++;
             }
           }
         if (colIncrement == -1){
           for (int i = 0; i < word.length(); col --){
               data[r][c] = word.charAt(i);
               i ++;
             }
         }
       }

  if (rowIncrement == -1){
         if (colIncrement == 1){
           for (int i = 0; i < word.length(); col ++){
               data[r][c] = word.charAt(i);
               i ++;
               r --;
             }
           }
         if (colIncrement == 0){
           for (int i = 0; i < word.length();){
               data[r][c] = word.charAt(i);
               i ++;
               r --;
             }
         }
         if (colIncrement == -1){
           for (int i = 0; i < word.length(); col --){
               data[r][c] = word.charAt(i);
               i ++;
               r --;
             }
         }
       }
     return true;}

  public boolean Safe ( int r, int c, String word, int rowIncrement, int colIncrement){
    if (rowIncrement == 0 && colIncrement == -1){
          for (int i = 0; i < word.length(); col --){
            if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
              return false;
            }
            else {i ++;}
          }}
    if (rowIncrement == 0 && colIncrement == 0){
        return false;
        }
    if (rowIncrement == 0 && colIncrement == 1){
          for (int i = 0; i < word.length(); col ++){
            if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
              return false;
            }
            else {i ++;}
          }}
    if (rowIncrement == 1 && colIncrement == -1){
              for (int i = 0; i < word.length(); col --){
                if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
                  return false;
                }
                else {
                  i ++;
                  r ++;}
              }}
    if (rowIncrement == 1 && colIncrement == 0){
                      for (int i = 0; i < word.length();){
                        if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
                          return false;
                        }
                        else {
                          i ++;
                          r ++;}
                      }}
    if (rowIncrement == 1 && colIncrement == 1){
                      for (int i = 0; i < word.length(); col ++){
                        if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
                          return false;
                        }
                        else {
                              i ++;
                              r ++;}
                        }}

    if (rowIncrement == -1 && colIncrement == -1){
                    for (int i = 0; i < word.length(); col --){
                      if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
                        return false;
                        }
                        else {
                              i ++;
                              r --;}
                            }}
    if (rowIncrement == -1 && colIncrement == 0){
                    for (int i = 0; i < word.length();){
                      if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
                        return false;
                        }
                        else {
                              i ++;
                              r --;}
                            }}
      if (rowIncrement == -1 && colIncrement == 1){
                    for (int i = 0; i < word.length(); col ++){
                      if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
                        return false;
                        }
                        else {
                              i ++;
                              r --;}
                            }}
      return true;
                  }

//Was helped by Moududur Rahman
private void addAllWords() {
  int xc;
  int yc;
  int rv;
  int cv;
  int add = 0;
    for (int i = 0; i < wordsToAdd.size(); i++){
      int c = 100;
      boolean happy = false;
      String list = wordsToAdd.get(i);
      while (happy == false && c > 0){

      xc = Math.abs(randgen.nextInt() % rows);
      yc = Math.abs(randgen.nextInt() % cols);
      rv = (randgen.nextInt() % 2);
      cv = (randgen.nextInt() % 2);
      if(happy = addWord( yc, xc, list, rv, cv)){
        add++;
      }
      c --;
      System.out.println(add);
    }
}
}
getWords (){;}
}




//declare new file
//declare new scanner that takes file as an input
//use scanner methods to add words into the ArrayList
// Instantiate ArrayList somewhere
