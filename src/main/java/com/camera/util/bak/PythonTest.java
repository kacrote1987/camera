package com.wision.util.Jsoup;

import java.io.*;

public class PythonTest {
    public static void main(String[] args) {
        String[] arguments = new String[] {"python","D:\\MyProgame\\Workspaces\\wision_py\\baidu.py",""};   //这里构建要在cmd中输入的参数，第二个参数表示.py文件的路径，第二个之后的参数都表示要传给.py文件的参数，可以根据.py文件的需求写
        try {
            Process process = Runtime.getRuntime().exec(arguments);//这个方法相当于在cmd中输入 python D:\\ccc\\1.py D:/ccc/
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);  //在java编译器中打印.py文件的执行结果
            }
            in.close();
            int re = process.waitFor();//因为是process这个进程调用.py文件， 所以要将当前进程阻塞等待.py文件执行完毕， 若果.py文件成功运行完毕，此方法将返回0，代表执行成功
            System.out.println(re); //执行成功的话这里会打印一个0，否则会打印1，2或者其他数字
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}