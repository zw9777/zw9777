package Twoday;

class Circle
{
    double radius,area;
    Circle(double r)
    {
//        【代码12】 //方法体
        this.radius = r;
    }
    double getArea()
    {
//       【代码13】 //方法体，要求计算出area返回
        area = 3.141596 * radius * radius;
        return area;
    }
    double getLength()
    {
//      【代码14】 //getArea方法体的代码,要求计算出length返回
        double length = 2*3.141596*radius;
        return length;
    }
    void setRadius(double newRadius)
    {
        radius=newRadius;
    }
    double getRadius()
    {
        return radius;
    }
}
