import java.util.Random;
import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
  private char[][]data;
  private int rowlength;
  private int collength;


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
     try {
       fr (fileName);
       System.out.println(wordsToAdd);
     }
     catch (FileNotFoundException e){
       System.out.println(error1);}

      if (alength < 3){return error2;}

      try {
        ro = args[0];
        co = args [1];
        file = args [2];
      }
      catch (NumberFormatException e){
        System.out.println(error2);}
        if (alength == 3 ){
          k = false;
        WordSearch pal = new WordSearch (ro, co, file, k);
        System.out.println(pal);}

      if (alength == 4){
        try {
          sprout = args[3];
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
          return "Last word needs to be key if you want the answer \n" + error2;
        }}}

  //  public WordSearch(int r, int c, String fileName, int seed, boolean answer) {
  //    randgen = new Random (seed);
  //    data = new char [r] [c];
  //    clear ();
  //    if (!answer){
  //      nokey();}
  //
  //
  //
  //
  //    }
  //
  //  public WordSearch(int r, int c, String fileName, boolena answer) {
  //    Random sg = new Random ();
  //    seed = sg.nextInt();
  //    randgen = new Random (seed);
  //    data = new char [r] [c];
  //    clear ();
  //    if (!answer){
  //      nokey();}
  //
  // }

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
private boolean addWord( String word, int r, int c, int rowIncrement, int colIncrement){
if (Safe(r,c,word,rowIncrement,colIncrement) == false){return false;}
  for (int i = 0; i < word.length(); i++){
    data[r][c] = word.charAt(i);
    r = r + rowIncrement;
    c = c + colIncrement;}
    return true;}

  public boolean Safe ( int r, int c, String word, int rowIncrement, int colIncrement){
    if (rowIncrement == 0 && colIncrement == 0){return false;}
    for (int i = 0; i < word.length(); i ++){
      if (data[r][c] != '_' && data[r][c] != word.charAt(i)){
          return false;}
        if (r < 0 || c < 0){
          return false;}
        r = r + rowIncrement;
        c = c + colIncrement;
      } return true;}

//Was helped by Moududur Rahman but that happened before I knew about the academic dishonesty policy for this class.
//I tried writing my own, but everytime it is just another version of this. I undertood the code so my brain can't think of any other way.
// I did a few changes but they were minor...so I hope this is okay.
private void addAllWords() {
  int xc;
  int yc;
  int rv;
  int cv;
  int add = 0;
    for (int i = 0; i < wordsToAdd.size(); i++){
      int tries = 100;
      boolean happy = false;
      String list = wordsToAdd.get(i);
      while (happy == false && tries > 0){
        xc = Math.abs(randgen.nextInt() % c + 1);
        yc = Math.abs(randgen.nextInt() % r+ 1);
        rv = (randgen.nextInt() % 2);
        cv = (randgen.nextInt() % 2);
        if (!addWord(wordsToAdd.get(i), r, c, rv, cv)){
        tries --;
      }
      else{ addWord(wordsToAdd.get(i),r, c, rv, cv);}
      System.out.println(add);
    }
}
}

private void nokey(){
  for (int x = 0; x < data.length; x ++) {
  for (int y = 0; y < data[0].length; y ++) {
    if (data[x][y] == ' ') data[x][y] = fill();
  }
}
}

private String fill () {
String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
Random z = new Random ();
return abc.substring(z%26, z%26 - 1);
}

}




//declare new file
//declare new scanner that takes file as an input
//use scanner methods to add words into the ArrayList
// Instantiate ArrayList somewhere
