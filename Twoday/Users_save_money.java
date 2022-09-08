package Twoday;

import java.util.Scanner;

public class Users_save_money {
    int ID;
    String user_name;
    int money;
    int start_money;
    int end_money;
    boolean flag = true;
    public Users_save_money(int ID, String user_name, int money) {
        this.ID = ID;
        this.user_name = user_name;
        this.money = money;

    }

    void Save_money() {
        /*判断用户是否是本人*/
        System.out.println("请输入本人ID");
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            int id = scanner.nextInt();
            if (id == this.ID) {
                System.out.println("ID: " + this.ID + " " + "user_name: " + this.user_name + " " + "现有存款：" + this.money);
                System.out.println("欢迎登陆，请输入存款金额");
                start_money = scanner.nextInt();
                System.out.println("存款已存入");
                while (start_money <= 0) {
                    System.out.println("存款金额不正确，请重新输入存款金额");
                    start_money = scanner.nextInt();
                    System.out.println("存款已存入");
                }
                money = start_money + money;
                System.out.println("ID: " + this.ID + " " + "user_name: " + this.user_name + " " + "现有存款：" + this.money);
                break;
            } else {
                System.out.println("ID错误");
                System.out.println("请重新输入本人ID");
            }
        }
    }
    void Cycle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入ID");
        int id = scanner.nextInt();
        if (id == this.ID){
            Save_money();
        }else{
            System.out.println("没找到");
        }
    }
}
