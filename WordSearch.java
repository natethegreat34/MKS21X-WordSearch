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
   private ArrayList<String>wordsToAdd;

   //all words that were successfully added get moved into wordsAdded.
   private ArrayList<String>wordsAdded;
   public WordSearch( int rows, int cols, String fileName){
      int ng = new Random ();
      rows= ng;
   }

public WordSearch( int rows, int cols, String fileName, int randSeed)
{;}
    private char[][]data;

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
      data = new char [rows][cols];
      clear();
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
                }
