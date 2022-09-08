package Twoday;

import java.util.Scanner;

public class Tset_user_save {
    public static void main(String[] args) {


        Users_save_money dwz,yzs,rzj,mqz,xlk;
        dwz = new Users_save_money(20031021,"dwz",0);
        yzs = new Users_save_money(20031022,"yzs",0);
        rzj = new Users_save_money(20031023,"rzj",0);
        mqz = new Users_save_money(20031024,"mqz",0);
        xlk = new Users_save_money(20031025,"xlk",0);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        System.out.println("欢迎来到邓总商行");
        while (flag){
            System.out.println("请输入ID");
            int id = scanner.nextInt();
            if (id == dwz.ID){
                System.out.println("请再次输入ID确认");
                dwz.Save_money();
                break;
            } else if (id == yzs.ID) {
                System.out.println("请再次输入ID确认");
                yzs.Save_money();
                break;
            } else if (id == rzj.ID) {
                System.out.println("请再次输入ID确认");
                rzj.Save_money();
                break;
            } else if (id == mqz.ID) {
                System.out.println("请再次输入ID确认");
                mqz.Save_money();
                break;
            } else if (id == xlk.ID) {
                System.out.println("请再次输入ID确认");
                xlk.Save_money();
                break;
            }else {
                System.out.println("ID错误请重新输入，是否还要继续存款,继续存款请按Yes，退出请按No");
                while (flag) {
                    Scanner scanner1 = new Scanner(System.in);
                    String accept = scanner1.nextLine();
                    String str = "Yes";
                    String str2 = "NO";
                    if (accept.equals(str)) {
                        System.out.println("即将跳转到重新输入ID页面");
                        break;
                    } else if (accept.equals(str2)) {
                        flag = false;
                    } else{
                        System.out.println("重新输入选项");
                    }
                }

            }

        }
        /*
        Users_save_money cycle;
        cycle = new Users_save_money(1,"dd",0);
        cycle.Cycle();可以将上述方法简写*/
    }
}
