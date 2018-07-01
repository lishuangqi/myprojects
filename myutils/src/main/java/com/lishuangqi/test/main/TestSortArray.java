package com.lishuangqi.test.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序算法主类
 *
 * @author eric
 */
class TestSortArray {

    /*
     * 【插入排序】
     * 基本思想： 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
     * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的， 如此反复循环，直到全部排好顺序。
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            for (; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j]; // 将大于temp的值整体后移一个单位
            }
            arr[j + 1] = temp;
        }
    }

    /*
     * 【选择排序】 基本思想： 在要排序的一组数中，选出最小的一个数与第一个位置的数交换,
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int position = i;
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];
            arr[i] = temp;
        }
    }

    /*
     * 【冒泡排序】
     * 基本思想： 在要排序的一组数中， 对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
     * 让较大的数往下沉，较小的往上冒。 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /*
     * 【希尔排序】
     * 基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，
     * 每组中记录的下标相差d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，
     * 在每组中再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
     */
    public void shellSort(int[] arr) {

        double d1 = arr.length;
        int temp = 0;

        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < arr.length; i += d) {
                    int j = i - d;
                    temp = arr[i];
                    for (; j >= 0 && temp < arr[j]; j -= d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }
            if (d == 1)
                break;
        }
    }

    /*
     * 【堆排序】
     * 基本思想：堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     * 堆的定义如下：具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）
     * 或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。在这里只讨论满足前者条件的堆。
     * 由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。
     * 完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。
     * 初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。
     * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。
     * 依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
     * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
     * 所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数
     */
    public void heapSort(int[] arr) {
        // 循环建堆
        for (int i = 0; i < arr.length - 1; i++) {
            buildMaxHeap(arr, arr.length - 1 - i); // 建堆
            swap(arr, 0, arr.length - 1 - i); // 交换堆顶和最后一个元素
        }
    }

    private void buildMaxHeap(int[] arr, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (arr[biggerIndex] < arr[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (arr[k] < arr[biggerIndex]) {
                    // 交换他们
                    swap(arr, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    /*
     * 【快速排序】
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
     * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     */
    public void quickSort(int[] arr) {
        // 查看数组是否为空
        if (arr.length > 0) {
            quickSort(arr, 0, arr.length - 1);
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high); // 将list数组进行一分为二
            quickSort(arr, low, middle - 1); // 对低字表进行递归排序
            quickSort(arr, middle + 1, high); // 对高字表进行递归排序
        }
    }

    private int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low]; // 数组的第一个作为中轴
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high]; // 比中轴小的记录移到低端
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low]; // 比中轴大的记录移到高端
        }
        arr[low] = temp; // 中轴记录到尾
        return low; // 返回中轴的位置

    }

    /*
     * 【基数排序】
     * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void radixSort(int[] arr) {

        // 首先确定排序的趟数;
        int max = arr[0];
        int time = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }

        // 建立10个队列;
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }

        // 进行time次分配和收集;
        for (int i = 0; i < time; i++) {

            // 分配数组元素;
            for (int j = 0; j < arr.length; j++) {

                // 得到数字的第time+1位数;
                int x = arr[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(arr[j]);
                queue.set(x, queue2);
            }

            int count = 0;// 元素计数器;

            // 收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    arr[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 32, 43, 56, 12, 34, 21, 34, 54, 19 };
        TestSortArray sa = new TestSortArray();
        System.out.print("Before Sorting : ");
        sa.printArray(arr); // 排序前打印输出
        System.out.println();
         sa.insertSort(arr); // 插入排序
        // sa.selectSort(arr); // 选择排序
        // sa.bubbleSort(arr); // 冒泡排序
        // sa.shellSort(arr); // 希尔排序
        // sa.heapSort(arr); // 堆排序
        // sa.quickSort(arr); // 快速排序
        // sa.mergingSort(arr, 0, arr.length - 1 ); // 归并排序
//        sa.radixSort(arr); // 基数排序
        System.out.print("After Sorting : ");
        sa.printArray(arr); // 排序后打印输出
    }

}