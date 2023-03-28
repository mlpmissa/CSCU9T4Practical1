// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   public String findAllEntries(int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
             result = result + current.getEntry();
       }
	   return result;
   }
   
   public String removeRecord(String n, int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator();
	   String result = "Failed to remove";
		   
	   while (iter.hasNext()) {
		   Entry current = iter.next();
		   if ((current.getName()).equalsIgnoreCase(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
			   result = current.getName() + " no longer did anything on " + current.getDay() + "/" + current.getMonth() + 
			   "/" + current.getYear() + " so stop asking.";
			   iter.remove();
		   }
	   }
	   
	   return result;
	   
   }
   
   public Boolean checkEntry(String n, int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator();
	   Boolean check = false;
	   while (iter.hasNext()) {
		   Entry current = iter.next();
		   if ((current.getName()).equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
			   check = true;
		   }
	   }
	   
	   return check;
   }
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord