public class SuperArray{
  private String[] data;
  private int size;
  private int resize=10;
  public SuperArray(){data = new String[resize];}
  public void clear(){size=0;}
  public int size(){return size;}
  public Boolean add(String x){if(size<10){data[size]=x;return true;}else return false;}
  public String toString(){String S="["; for(int i=0;i<size-1;i++)S+=data[i];S+=data[size]+"]";return S;}
  public String toStringDebug(){String S="["; for(int i=0;i<size-1;i++)S+=data[i];S+=data[size]+"]";return S;}
  public String get(int index){if(!(index < 0 || index >= size()))return data[index];else{System.out.println("error");return null;}}
  public String set(int index, String str){if(!(index < 0 || index >= size())){data[index]=str;return null;}else{System.out.println("error");return null;}}
}
