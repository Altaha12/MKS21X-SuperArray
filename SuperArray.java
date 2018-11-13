public class SuperArray{
  private String[] data;
  private int size;
  public SuperArray(){
    this.data=new String[10];
    this.size=0;
  }
  public SuperArray(int cap){
    if(cap<0){
      throw new IllegalArgumentException();
    }
    this.data=new String[cap];
    this.size=0;
  }
  public void clear(){
    this.data =new String[10];
    this.size=0;
  }
  public int size(){
    return this.size;
  }
  public Boolean isEmpty(){
    if(size==0){
      return true;}
    return false;
  }
  public Boolean add(String e){
    if(size==this.data.length){
      this.resize();
      this.data[size]=e;
      size+=1;
      return true;
    }
    this.data[size]=e;
    size+=1;
    return true;
  }
  public String toString(){
    if(this.data.length==0||this.size==0){
      return "[]";
    }
    String r="[";
    for(int i=0;i<this.size-1;i++){
      r+=this.data[i]+", ";
    }
    r+=this.data[size-1]+"]";
    return r;
  }
  public String toStringDebug(){
    if(this.data.length==0){
      return "[]";
    }
    String r="[";
    for(int i=0;i<this.size-1;i++){
      r+=this.data[i]+", ";
    }
    r+=this.data[size-1]+", ";
    for(int i=0;i<this.data.length-this.size;i++){
      r+="null, ";
    }
    r+=" null]";
    return r;
  }
  public String get(int x){
    if(!(x < 0 || x >= size())){
      return this.data[x];
    }
    throw new IndexOutOfBoundsException();
  }
  public String set(int index,String e){
    String t = this.get(index);
    if(t==null){
      throw new IndexOutOfBoundsException();
    }
    this.data[index]=e;
    return t;
  }
  private void resize(){
    String[] data0=new String[this.data.length*2+1];
    this.size=this.data.length*2+1;
    System.arraycopy(this.data,0,data0,0,this.size);
    this.data=data0;
  }
  public Boolean contains(String target){
    for(int i=0;i<this.size;i++){
      if(this.data[i].equals(target)){
        return true;
      }
    }
    return false;
  }
  public int indexOf(String target){
    if(contains(target)){
      for(int i=0;i<this.size;i++){
        if(this.data[i].equals(target)){
          return i;
        }
      }
    }
    return -1;
  }
  public int lastIndexOf(String target){
    if(contains(target)){
      for(int i=size-1;i>-1;i--){
        if(this.data[i].equals(target)){
          return i;
        }
      }
    }
    return -1;
  }
  public void add(int index, String e){
    if(index==size){
      this.add(e);
    }
    if(index>=0&&index<size){
      if(size==this.data.length){
        this.resize();
      }
      String[] data0= new String[this.data.length];
      System.arraycopy(this.data,0,data0,0,index);
      data0[index]=e;
      System.arraycopy(this.data,index,data0,index+1,size-index);
      size+=1;
      this.data=data0;
    }
    if(index < 0 || index > size()){
      throw new IndexOutOfBoundsException();
    }
  }
  public String remove(int index){
    if(index < 0 || index > size()){
      throw new IndexOutOfBoundsException();
    }
    String[] data0=new String[this.data.length];
    System.arraycopy(this.data,0,data0,0,index);
    System.arraycopy(this.data,index+1,data0,index,size-index);
    String r=this.data[index];
    this.data=data0;
    size-=1;
    return r;
  }
  public Boolean remove(String element){
    if(this.contains(element)){
      this.remove(this.indexOf(element));
      return true;
    }
    return false;
  }
}
