package Twoday;

public class Computer {
    int data[];
    CD includCD;
    public void putCD(CD cd){
        includCD=cd;
        int size=includCD.getSize();
        data=new int[size];
    }
    void copyToComputer(){
        int []b=includCD.getContent();
        int min=Math.min(data.length,b.length);
        for(int i=0;i<data.length;i++){
            data[i]=b[i];
        }
    }
    public void addData(int m){
        for(int i=0;i<data.length;i++){
            data[i]=data[i]+m;
        }
    }
    void copyToCD(){
        includCD.setContent(data);
    }
    void showData(){
        for(int i=0;i<data.length;i++){
            System.out.printf("%3d",data[i]);
        }
    }
}
