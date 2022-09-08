package Twoday;

class Trangle
{
    double sideA,sideB,sideC,area,length;
    boolean boo;
    public  Trangle(double a,double b,double c)
    {
//    【代码1】 //参数a,b,c分别赋值给sideA,sideB,sideC
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
        if(a+b>c&&a+c>b&&b+c>a) //a,b,c构成三角形的条件表达式
        {
//       【代码3】 //给boo赋值。
            boo = true;
        }
    else
        {
//        【代码4】 //给boo赋值。
            boo = false;
        }
    }
    double getLength()
    {
//       【代码5】 //方法体，要求计算出length的值并返回
        if (boo) {
            double length = sideA + sideB + sideC;
            return length;
        }else {
            System.out.println("不是三角形");
            return 0;
        }
    }
    public double  getArea()
    {
        if(boo)
        {
            double p=(sideA+sideB+sideC)/2.0;
            area=Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC)) ;
            return area;
        }
        else
        {
            System.out.println("不是一个三角形,不能计算面积");
            return 0;
        }
    }
    public void setABC(double a,double b,double c)
    {
        //    【代码6】 //参数a,b,c分别赋值给sideA,sideB,sideC
        sideA=a;
        sideB=b;
        sideC=c;
        if(a+b>c&&a+c>b&&b+c>a) //a,b,c构成三角形的条件表达式
        {
//       【代码8】 //给boo赋值。
            boo = true;
        }
        else
        {
//        【代码9】 //给boo赋值。
            boo = false;
        }
    }
}
