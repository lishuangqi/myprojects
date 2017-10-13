package com.lishuangqi.utils;

import java.math.BigDecimal;

/**
 * Created by michael on 2017/10/13.
 */
public final class DecimalUtil {
    private static final int DEF_DIV_SCALE = 10;

    public DecimalUtil() {
    }

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    public static double div(double v1, double v2) {
        return div(v1, v2, 10);
    }

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } else {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.divide(b2, scale, 4).doubleValue();
        }
    }

    public static double round(double v, int scale) {
        if (v == 0.0D) {
            return 0.0D;
        } else if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } else {
            BigDecimal b = new BigDecimal(Double.toString(v));
            BigDecimal one = new BigDecimal("1");
            return b.divide(one, scale, 4).doubleValue();
        }
    }

    public static Integer round(double v) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return Integer.valueOf(b.divide(one, 0, 4).intValue());
    }

    public static Integer roundUp(double v) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return Integer.valueOf(b.divide(one, 0, 0).intValue());
    }

    public static Double roundUp(double v, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return Double.valueOf(b.divide(one, scale, 0).doubleValue());
    }

    public static Integer roundDown(double v) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return Integer.valueOf(b.divide(one, 0, 1).intValue());
    }

    public static Double roundDown(double v, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return Double.valueOf(b.divide(one, scale, 1).doubleValue());
    }

    public static Integer round2Thousand(double v) {
        int num = round(v).intValue();
        num += 1000 - num % 1000;
        return Integer.valueOf(num);
    }

    public static Double avg(Double... nums) {
        if (nums != null && nums.length > 0) {
            double total = 0.0D;

            for (int i = 0; i < nums.length; ++i) {
                total += nums[i].doubleValue();
            }

            return Double.valueOf(div(total, (double) nums.length));
        } else {
            return Double.valueOf(0.0D);
        }
    }

    public static Double stdEv(Double... nums) {
        if (nums != null && nums.length > 0) {
            double avg = avg(nums).doubleValue();
            double total = 0.0D;

            for (int i = 0; i < nums.length; ++i) {
                total += Math.pow(nums[i].doubleValue() - avg, 2.0D);
            }

            return Double.valueOf(Math.sqrt(div(total, (double) (nums.length - 1))));
        } else {
            return Double.valueOf(0.0D);
        }
    }

    public static Double stdEvp(Double... nums) {
        if (nums != null && nums.length > 0) {
            double avg = avg(nums).doubleValue();
            double total = 0.0D;

            for (int i = 0; i < nums.length; ++i) {
                total += Math.pow(nums[i].doubleValue() - avg, 2.0D);
            }

            return Double.valueOf(Math.sqrt(div(total, (double) nums.length)));
        } else {
            return Double.valueOf(0.0D);
        }
    }

    public static void main(String[] args) {
        System.out.println(stdEvp(new Double[]{Double.valueOf(10.0D), Double.valueOf(15.0D), Double.valueOf(20.0D), Double.valueOf(25.0D), Double.valueOf(30.0D)}));
    }
}

