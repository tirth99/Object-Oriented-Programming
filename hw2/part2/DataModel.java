import java.util.*;
import java.io.*;

public class DataModel extends Observable {
   public DataModel() {
      dataList = new ArrayList<>();
   }

   public int getSize() {
      return dataList.size();
   }

   public void addData(int data) {
      dataList.add(data);
      setChanged();
      notifyObservers();
   }

   public ArrayList<Integer> getDataList() {
      return dataList;
   }

   public void replaceData(int index, int data) {
      dataList.set(index, data);
      setChanged();
      notifyObservers();
   }

   public int getData(int i) {
      return dataList.get(i);
   }

   private ArrayList<Integer> dataList;
}