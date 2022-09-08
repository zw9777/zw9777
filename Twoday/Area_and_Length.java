package Twoday;

public class Area_and_Length
{
    public static void main(String args[])
    {
        double length,area;
        Circle circle=null;
        Trangle trangle;
        Lader lader;
//       【代码15】 //创建对象circle
        circle = new Circle(2);
//       【代码16】 //创建对象trangle。
        trangle = new Trangle(3,4,5);
//       【代码17】 //创建对象lader
        lader = new Lader(2,3,4);
//       【代码18】 // circle调用方法返回周长并赋值给length
        length = circle.getLength();
        System.out.println("圆的周长:"+length);
//       【代码19】 // circle调用方法返回面积并赋值给area
        area = circle.getArea();
        System.out.println("圆的面积:"+area);
//       【代码20】 // trangle调用方法返回周长并赋值给length
        length = trangle.getLength();
        System.out.println("三角形的周长:"+length);
//       【代码21】 // trangle调用方法返回面积并赋值给area
        area = trangle.getArea();
        System.out.println("三角形的面积:"+area);
//       【代码22】 // lader调用方法返回面积并赋值给area
        area = lader.getArea();
        System.out.println("梯形的面积:"+area);
//       【代码23】 // trangle调用方法设置三个边，要求将三个边修改为12,34,1。
        trangle.setABC(12,34,1);
//       【代码24】 // trangle调用方法返回面积并赋值给area
        area = trangle.getArea();
        System.out.println("三角形的面积:"+area);
//       【代码25】 // trangle调用方法返回周长并赋值给length
        length = trangle.getLength();
        System.out.println("三角形的周长:"+length);
    }
}
