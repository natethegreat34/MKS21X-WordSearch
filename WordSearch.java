import java.util.Random;
import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
  private char[][]data;
   //the random seed used to produce this WordSearch
   private int seed;
   public int seeder;
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
     String error2 = "Might be missing or have an additional argument or the wrong type. Make sure it looks like \n java WordSearch (integer) row (integer) col (name of file) fileName *optional* ((integer) seed (key) answer) \n examples: \n java WordSearch 40 40 word.txt \n or \n java WordSearch 40 40 word.txt 123 \n or \n java WordSearch 40 40 word.txt 123 key";
     String error3 = "Seed is too big or too small or completely wrong. Has to be between an integer 0 and 10000 inclusive.";
     String error4 = "You can't ask for the answer key without giving a seed.";
     String error5 = "Row and column inputs can't be negative.";

      if (alength < 3){System.out.println(error2);
      System.exit(1);}
      try {
        ro = Integer.parseInt(args[0]);
        co = Integer.parseInt(args [1]);
        file = args[2];
      }
      catch (NumberFormatException e){
        System.out.println(error2);
      System.exit(1);}
        k = false;
      if (Integer.parseInt(args[0])< 0 || Integer.parseInt(args[1]) < 0){
        System.out.println(error5);
        System.exit(1);
      }
        if (alength == 3 ){
          k = false;
        WordSearch pal = new WordSearch (ro, co, file, k);
        System.out.println(pal);}

      if (alength == 4){
        try {
          sprout = Integer.parseInt(args[3]);
        }
        catch (NumberFormatException e){
          System.out.println(error4);
          System.out.println(error2);
        System.exit(1);}

              k = false;
              if (Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3]) > 10000){System.out.println(error3);
              System.exit(1);}
                k = false;
          WordSearch pal = new WordSearch (ro, co, file, sprout, k);
          System.out.println(pal);}


      if (alength == 5){
        try {
          sprout = Integer.parseInt(args[3]);
        }
        catch (NumberFormatException e){
          System.out.println(error4);
          System.out.println(error2);
        System.exit(1);}
        if (args[4].equals("key")){
              k = true;
              if ( Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3])> 10000){System.out.println(error3);
              System.exit(1);}
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
        System.exit(1);
      }}

   public WordSearch(int r, int c, String fileName, int seed, boolean answer) {
     try {
       fr (fileName);
     }
     catch (FileNotFoundException e){
       System.out.println("File not found.");
       System.exit(1);}
       seeder = seed;
     randgen = new Random (seed);
     data = new char [r] [c];
     clear ();
     addAllWords();
     if (!answer){
       nokey();}}

   public WordSearch(int r, int c, String fileName, boolean answer) {
     try {
       fr (fileName);
     }
     catch (FileNotFoundException e){
       System.out.println("File not found.");
     System.exit(1);}
     Random sg = new Random ();
     seed = sg.nextInt();
     randgen = new Random (seed);
     data = new char [r] [c];
     clear ();
     addAllWords();
     if (!answer){
       nokey();}}


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
    sad = sad + "Words: (Seed:" + seeder + ")" + wordsAdded;
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
         xc = Math.abs(randgen.nextInt() % data.length);
         yc = Math.abs(randgen.nextInt() % data[0].length);
         rv = (randgen.nextInt() % 2);
         cv = (randgen.nextInt() % 2);
         if (!addWord(wordsToAdd.get(i), xc, yc, rv, cv)){
         tries --;
       }
       else{ addWord(wordsToAdd.get(i),xc, yc, rv, cv);
         wordsAdded.add(wordsToAdd.get(i));
        happy = true;}
     }
 }
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
