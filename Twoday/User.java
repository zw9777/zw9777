package Twoday;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        CD dataCD=new CD();
        System.out.println("请输入接收数组长度");
        /*进行修改，将数组变成可以从键盘接收*/
//        int b[]={1,2,3,4,5,6,7,8}; /*我这里将数组以键盘输入*/
        Scanner scanner = new Scanner(System.in);
        int sss = scanner.nextInt();
        int []dwz = new int[sss];
        for (int i = 0; i < sss; i++) {
            System.out.println("请继续输入");
            int accept = scanner.nextInt();
            dwz[i] = accept;
        }
        for (int i = 0; i < dwz.length; i++) {
            System.out.print(dwz[i]+" ");
        }
        System.out.println();
        dataCD.setSize(dwz.length);
        dataCD.setContent(dwz);/*将b数组复制到CD*/
        int a[]=dataCD.getContent();/*得到复制后的数组*/
        System.out.println("dataCD上的内容：");
        for(int i=0;i<a.length;i++){
            System.out.printf("%3d",a[i]);
        }
        Computer computerIMB=new Computer();
//		【代码1】//computerIMB调用putCD(CD cd)方法，将dataCD的引用传递给cd
        computerIMB.putCD(dataCD);
        System.out.println("\n将dataCD的数据复制到计算机：computerIMB.");
//		【代码2】//computerIMB调用copyToComputer()方法
        computerIMB.copyToComputer();
        System.out.println("computerIMB上的内容：");
        computerIMB.showData();
        int m=12;
        System.out.println("\ncomputerIMB将每个数据增加"+m);
        computerIMB.addData(m);
        System.out.println("computerIMB将增值后的数据复制到CD：dataCD");
//		【代码3】//computerIMB调用copyToCD()方法
        computerIMB.copyToCD();
        System.out.println("dataCD上的内容：");
        a=dataCD.getContent();
        for(int i=0;i<a.length;i++){
            System.out.printf("%3d",a[i]);
        }
        System.out.println();
        CD dwz1;
        dwz1 = new CD();
        int b[] = {1,2,3};
        dwz1.setSize(b.length);
        dwz1.setContent(b);
        int acc[] = dwz1.getContent();
        for (int i = 0; i < acc.length; i++) {
            System.out.print(acc[i]+ " ");
        }
    }
}

