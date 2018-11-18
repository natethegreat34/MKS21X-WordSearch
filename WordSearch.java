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
   private ArrayList<String>wordsToAdd = new ArrayList <String> ();

   //all words that were successfully added get moved into wordsAdded.
   private ArrayList<String>wordsAdded = new ArrayList <String> ();

   public static void main(String[] args) {
     int alength = args.length;
     int ro = 0;
     int co = 0;
     String file = "";
     int sprout = 0;
     boolean k = false;
     String error1 = "File not found";
     String error2 = "Might be missing an argument. Make sure it looks like \n java WordSearch row col fileName *optional* (seed answer) \n examples: \n java WordSearch 40 40 word.txt \n or \n WordSearch 40 40 123 word.txt or \n WordSearch 40 40 123 word.txt key";


      if (alength < 3){System.out.println(error2);}

      try {
        ro = Integer.parseInt(args[0]);
        co = Integer.parseInt(args [1]);
        file = args[2];
      }
      catch (NumberFormatException e){
        System.out.println(error2);}
        if (alength == 3 ){

        WordSearch pal = new WordSearch (ro, co, file);
        System.out.println(pal);}

      if (alength == 4){
        try {
          sprout = Integer.parseInt(args[3]);
        }
        catch (NumberFormatException e){
          System.out.println(error2);}
          k = false;
          WordSearch pal = new WordSearch (ro, co, file, sprout, k);
          System.out.println(pal);}


      if (alength == 5){
        if (args[4].equals("key")){
          k = true;
          WordSearch pal = new WordSearch (ro, co, file, sprout, k);
          System.out.println(pal);
        }

        else{
          k = false;
          WordSearch pal = new WordSearch (ro, co, file, sprout, k);
          System.out.println(pal);
        }}
      if (alength > 5){
        System.out.println(error2);
      }}

   public WordSearch(int r, int c, String fileName, int seed, boolean answer) {
     try {
       fr (fileName);
       System.out.println(wordsToAdd);
     }
     catch (FileNotFoundException e){
       System.out.println("File not found.");}
     randgen = new Random (seed);
     data = new char [r] [c];
     clear ();
     addAllWords();
     if (!answer){
       nokey();}}

   public WordSearch(int r, int c, String fileName) {
     try {
       fr (fileName);
       System.out.println(wordsToAdd);
     }
     catch (FileNotFoundException e){
       System.out.println("File not found.");}
     Random sg = new Random ();
     seed = sg.nextInt();
     randgen = new Random (seed);
     data = new char [r] [c];
     clear ();
     addAllWords();
     nokey();
  }

   private void fr (String input) throws FileNotFoundException{
     File f = new File (input);
     Scanner k = new Scanner (f);
     while (k.hasNextLine() ){
       String a  = k.nextLine();
       wordsToAdd.add(a);
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
        for (int y = 0; y < data[x].length;){
          sad = sad + data [x][y] + " ";
          y ++;
          if (y == data[x].length){
            sad = sad + '|';
          }
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
public boolean addWord( String word, int r, int c, int rowIncrement, int colIncrement){
int tv = r;
int tu = c;

  if (rowIncrement == 0 && colIncrement == 0){return false;}
    for (int i = 0; i < word.length(); i ++){
      if (r < 0 || r >= data.length || c < 0 || c >= data [0].length){
        return false;
      }
      if (data[r][c] != '_' && data[r][c] != word.charAt(i)){
          return false;}
          r = r + rowIncrement;
          c = c + colIncrement;
        }

    for (int i = 0; i < word.length(); i++){
      data[tv][tu] = word.charAt(i);
      tv = tv + rowIncrement;
      tu = tu + colIncrement;}
    return true;}

//Was helped by Moududur Rahman but that happened before I knew about the academic dishonesty policy for this class.
//I tried writing my own, but everytime it is just another version of this. I undertood the code so my brain can't think of any other way.
// I did a few changes but they were minor...so I hope this is okay.
private boolean addAllWords() {
  while (wordsToAdd.size() > 0) {
    int idx = Math.abs(randgen.nextInt() % wordsToAdd.size());
    boolean finished = false;
    for (int x = 0; x < 500 && ! finished; x ++) {
      int rows = Math.abs(randgen.nextInt() % data.length);
      int cols = Math.abs(randgen.nextInt() % data[0].length);
      int rowIncrement = randgen.nextInt() % 2;
      int colIncrement = randgen.nextInt() % 2;
      if (addWord(wordsToAdd.get(idx), rows, cols, rowIncrement, colIncrement)) {
        finished = true;
        wordsAdded.add(wordsToAdd.get(idx));
      }
    }
    wordsToAdd.remove(idx);
  }
  return true;
}

private void nokey(){
  for (int x = 0; x < data.length; x ++) {
  for (int y = 0; y < data[0].length; y ++) {
    if (data[x][y] ==  '_') data[x][y] = fill();
  }
}
}

private char fill () {
String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
Random z = new Random ();
return abc.charAt(Math.abs(z.nextInt() % 26));
}

}




//declare new file
//declare new scanner that takes file as an input
//use scanner methods to add words into the ArrayList
// Instantiate ArrayList somewhere
