package Twoday;


public class Tank {
    //【代码1】//声明double型变量speed，刻画速度
    double speed;
    //【代码2】//声明int型变量bulletAmount，刻画炮弹数量
    int bulletAmount;
    boolean flag = true;

    void speedUp(int s){   /*加速方法*/
        //【代码3】//s+speed赋值给speed
        speed = s + speed;
        if (speed > 220){
            speed = speed - s;
        }
    }


    void breakspeed(){     /*刹车*/
        if (speed > 0){
            speed = 0;
        }
    }

    void speedDown(int d){  /*减速方法*/
        if(speed-d>=0) {
            //【代码4】//d-speed赋值给speed
            speed = speed - d;
        }else{
            System.out.println(this + "速度不符合");
            speed=0;

        }
    }



    int getBulletAmount() {  /*设置子弹数量*/
        return bulletAmount;
    }

    void setBulletAmount(int m) {
        bulletAmount = m;
    }
    double getSpeed() {   /*得到速度*/
        return speed;
    }
    void fire(){
        if(bulletAmount>=1){
            //【代码5】//将bulletAmount-1赋值给bulletAmount
            bulletAmount = bulletAmount -1;
            System.out.println("打出一发炮弹");
        }
        else{
            System.out.println("没有炮弹了，无法开火");
        }
    }
}
