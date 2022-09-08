package Twoday;


public class MainClass {
    public static void main(String[] args) {
//		【代码1】//用类名FamilyPerson访问surname，并为surname赋值："李"
        Family_Person.surname = "李";
        Family_Person father,sonOne,sonTwo;
        father=new Family_Person();
        sonOne=new Family_Person();
        sonTwo=new Family_Person();
//		【代码2】//father调用setName(String s),传递"向阳"
        father.setName("向阳");
        sonOne.setName("抗日");
        sonTwo.setName("抗战");
        System.out.println("父亲："+father.surname+father.name);
        System.out.println("大儿子："+sonOne.surname+sonOne.name);
        System.out.println("二儿子："+sonTwo.surname+sonTwo.name);
//		【代码3】//father调用setName(String s),传递"张"
        father.setName("张");
        System.out.println("父亲："+father.surname+father.name);
        System.out.println("大儿子："+sonOne.surname+sonOne.name);
        System.out.println("二儿子："+sonTwo.surname+sonTwo.name);
    }
}
