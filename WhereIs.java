public class WhereIs{
  public static void main(String[] args){
    WordSearch first = new WordSearch(8, 5);

    System.out.println("---Testing Constructor---");
    System.out.println("testing toString: should print a 8-by-5 empty word search");
    System.out.println(first.toString());

    System.out.println("---Testing addWordHorizontal---");
    System.out.println("testing add YES horizontally to row 2, column 0: should return true");
    System.out.println(first.addWordHorizontal("YES", 2, 0));
    System.out.println("word search should be modified:");
    System.out.println(first.toString());
    System.out.println("\ntesting add NO horizontally to row 1, column 3: should return true");
    System.out.println(first.addWordHorizontal("NO", 1, 3));
    System.out.println("word search should be modified:");
    System.out.println(first.toString());

    System.out.println("\ntesting add YES horizontally to row 0, column 3: should return false");
    System.out.println(first.addWordHorizontal("YES", 0, 3));
    System.out.println("word search should be the same as before:");
    System.out.println(first.toString());

    System.out.println("\ntesting add YES horizontally to row 2, column 0 again: should return true");
    System.out.println(first.addWordHorizontal("YES", 2, 0));
    System.out.println("word search should be the same as before:");
    System.out.println(first.toString());
    System.out.println("\ntesting add YEA horizontally to row 2, column 0: should return false");
    System.out.println(first.addWordHorizontal("YEA", 2, 0));
    System.out.println("word search should be the same as before:");
    System.out.println(first.toString());

    first.addWordHorizontal("S", 3, 4);
    System.out.println("word search modified: added S to middle right corner");
    System.out.println(first.toString());
    System.out.println("\ntesting add NO horizontally to row 3, column 3: should return false");
    System.out.println(first.addWordHorizontal("NO", 3, 3));
    System.out.println("word search should be the same as before:");
    System.out.println(first.toString());

    System.out.println("\ntesting add ESA horzontally to row 2, column 1: should return true");
    System.out.println(first.addWordHorizontal("ESA", 2, 1));
    System.out.println("word search should be modified:");
    System.out.println(first.toString());

    System.out.println("\ntesting add YOS horizontally to row 2, column 0: should return false");
    System.out.println(first.addWordHorizontal("YOS", 2, 0));
    System.out.println("word search be the same as before:");
    System.out.println(first.toString());

    System.out.println("---Testing addWordVertical---");
    System.out.println("testing add NO vertically to row 0, column 0: should return true");
    System.out.println(first.addWordVertical("NO", 0, 0));
    System.out.println("word search should be modified:");
    System.out.println(first.toString());

    System.out.println("\ntesting add NOYS vertically to row 0, column 0: should return true");
    System.out.println(first.addWordVertical("NOYS", 0, 0));
    System.out.println("word search should be modified:");
    System.out.println(first.toString());

    System.out.println("\ntesting add SUPER vertically to row 0, column 4: should return false");
    System.out.println(first.addWordVertical("SUPER", 0, 4));
    System.out.println("word search should be the same as before:");
    System.out.println(first.toString());

    System.out.println("\ntesting add SUPER vertically to row 2, column 2: should return true");
    System.out.println(first.addWordVertical("SUPER", 2, 2));
    System.out.println("word search should be modified:");
    System.out.println(first.toString());

    System.out.println("\ntesting add EYES vertically to row 0, column 1: should return true");
    System.out.println(first.addWordVertical("EYES", 0, 1));
    System.out.println("word search should be modified:");
    System.out.println(first.toString());

    System.out.println("\ntesting add POPE vertically to row 0, column 4: should return false");
    System.out.println(first.addWordVertical("POPE", 0, 4));
    System.out.println("word search should be the same as before");
    System.out.println(first.toString());
  System.out.println(first.addWordHorizontal("SAY", 2, 2));
WordSearch w1 = new WordSearch(6, 6); //tests initialize method
System.out.println(w1 + "\n"); //should print 6 x 6 grid of _
System.out.println("should print 6 x 6 grid of _");
System.out.println(w1.addWordHorizontal("blue", 0, 0)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n"); //should print blue in first row
System.out.println("should print blue in first row");
System.out.println(w1.addWordHorizontal("chocolate", 1, 1)); //should return false
System.out.println("should return false");
System.out.println(w1 + "\n");
System.out.println(w1.addWordHorizontal("uesy", 0, 2)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n"); //should print bluesy in first row
System.out.println("should print bluesy in first row");
System.out.println(w1.addWordVertical("ink", 3, 5)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n"); //should print ink in the last column
System.out.println("should print ink in the last column");
System.out.println(w1.addWordVertical("pen", 0, 3)); //should return false
System.out.println("should return false");
System.out.println(w1 + "\n");
System.out.println(w1.addWordVertical("basket", 0, 0)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n"); //should print basket in the first column
System.out.println("should print basket in the first column");
System.out.println(w1.addWordVertical("ace", 3, 2)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n"); //should print ace in the third column
System.out.println("should print ace in third column");

System.out.println(w1.addWordDiagonal("basalk", 0, 0)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n");//should print basalk in the diagonal
System.out.println("should print basalt in the diagonal");
System.out.println(w1.addWordDiagonal("basalk", 0, 0)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n"); //should remain unchanged
System.out.println("should remain unchanged");
System.out.println(w1.addWordDiagonal("AA", 2, 3)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n");
System.out.println(w1.addWordDiagonal("kie", 3, 0)); //should return true
System.out.println("should return true");
System.out.println(w1 + "\n");//should print kie in the diagonal
}
}
