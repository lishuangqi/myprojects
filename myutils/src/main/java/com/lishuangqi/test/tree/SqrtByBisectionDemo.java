package com.lishuangqi.test.tree;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Created by michael on 2019/4/29.
 */
public class SqrtByBisectionDemo {
    public static double sqrtByBisection(double n, double eps) //用二分法
    {
        //小于0的按照你需要的处理
        if (n < 0)
            return n;
        double mid, last;
        double low = 0, up = n;
        mid = (low + up) / 2;
        do {
            if (mid * mid > n)
                up = mid;
            else
                low = mid;
            last = mid;
            mid = (up + low) / 2;
//            System.out.println("mid:"+mid);
            System.out.println(abs(mid - last));
        }
        //精度控制
        while (abs(mid - last) > eps);


        return mid;
    }

    /**
     * 这种算法的原理很简单，我们仅仅是不断用(x,f(x))的切线来逼近方程x^2-a=0的根。
     * 根号a实际上就是x^2-a=0的一个正实根，这个函数的导数是2x。
     * 也就是说，函数上任一点(x,f(x))处的切线斜率是2x。
     * 那么，x-f(x)/(2x)就是一个比x更接近的近似值。
     * 代入 f(x)=x^2-a得到x-(x^2-a)/(2x)，也就是(x+a/x)/2。
     * @param x
     * @param eps
     * @return
     */
    public static double SqrtByNewton(double x, double eps)
    {
        double val = x;//最终
        double last;//保存上一个计算的值
        do
        {
            last = val;
            val =(val + x/val) / 2;
            System.out.println(abs(val - last));
        }while(abs(val-last) > eps);
        return val;
    }

//    float InvSqrt(float x)
//    {
//        float xhalf = 0.5f*x;
//        int i = *(int*)&x; // get bits for floating VALUE
//        i = 0x5f375a86- (i>>1); // gives initial guess y0
//        x = *(float*)&i; // convert bits BACK to float
//        x = x*(1.5f-xhalf*x*x); // Newton step, repeating increases accuracy
//        return x;
//    }

    public static void main(String[] args) {
        double v1 = sqrtByBisection(2, 0.0001d);
        double v2 = SqrtByNewton(2, 0.0001d);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(sqrt(2));
    }
}
