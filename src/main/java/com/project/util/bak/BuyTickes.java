package com.wision.util.Jsoup;

public class BuyTickes {
    public static volatile  int nums = 30;
    public static  void buyTickets() {
        System.out.println("当前用户【线程】" + Thread.currentThread().getName() + "，抢到了第" + nums + "票");
        nums--;
    }

    public static void main(String[] args)  {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true){
                    synchronized(BuyTickes.class)
                    {
                        try{
                            //  Thread.sleep(2);
                            if(nums>0){
                                buyTickets();
                            }else{
                                System.out.println("当前窗口已经售完！");
                                break;
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }

                    }

                }
            }, i + "线程").start();
        }

    }
}