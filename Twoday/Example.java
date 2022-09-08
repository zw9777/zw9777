package Twoday;
class A
{
//   【代码1】             //声明一个float型实例变量a
    float a;
//   【代码2】             //声明一个float型类变量b,即static变量b
    static float b;
    void setA(float a)
    {
//      【代码3】        //将参数a的值赋值给成员变量a
        this.a = a;
    }
    void setB(float b)
    {
//      【代码4】       //将参数b的值赋值给成员变量b
        this.b = b;
    }
    float getA()
    {
        return a;
    }
    float getB()
    {
        return b;
    }
    void inputA()
    {
        System.out.println(a);
    }
    static void inputB()
    {
        System.out.println(b);
    }
}
public class Example
{
    public static void main(String args[])
    {
//      【代码5】            //通过类名操作类变量b,并赋值100
        A.b = 100;
//      【代码6】            //通过类名调用方法inputB()
        A.inputB();
        A cat=new A();
        A dog=new A();
//       【代码7】    //cat象调用方法setA(int a)将cat的成员a的值设置为200
        cat.setA(200);
//       【代码8】    //cat调用方法setB(int b)将cat的成员b的值设置为400
        cat.setB(400);
//       【代码9】    //dog象调用方法setA(int a)将dog的成员a的值设置为150
        dog.setA(150);
//       【代码10】   //dog调用方法setB(int b)将dog的成员b的值设置为300
        dog.setB(300);
//       【代码11】   //cat调用inputA()。
        cat.inputA();
//       【代码12】   //cat调用inputB()。
        cat.inputB();
//       【代码13】   //dog调用inputA()。
        dog.inputA();
//       【代码14】   //dog调用inputB()。
        dog.inputB();
    }
}