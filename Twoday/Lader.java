package Twoday;

class Lader
{
    double above,bottom,height,area;
    Lader(double a,double b,double c)
    {
//      【代码10】 //方法体，将参数a,b,c分别赋值给above,bottom,height
        this.above=a;
        this.bottom=b;
        this.height=c;
    }
    double getArea()
    {
//      【代码11】 //方法体，,要求计算出area返回
        area = (above + bottom) * height / 2;
        return area;
    }
}
