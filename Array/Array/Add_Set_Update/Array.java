import java.util.Arrays;

public class Array {
    //定义一个成员变量
    private int[] data;
    //用来描述data数组中到底有多少个元素
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组元素个数
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e){

//        //容量已满 抛出异常
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        //数组的元素==传入的元素  size ++
//        data[size] = e;
//        size ++;

        //在创建完add方法后 可以直接调用add方法来实现
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0, e);
    }

    //在数组中index位置插入一个元素
    public void add(int index,int e){
        if (size == data.length) {
            throw new IllegalArgumentException("add failed. Array is full.");
        }

        //判断index
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Array is full.");
        }

        //因为要向指定位置插入一个元素 所以就要把data中原有的元素向后挪一个位置
        for (int i = size - 1; i >= index; i --) {
                data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append(String.format("Array: size = %d, capacity: %d\n", size, data.length));
       res.append('[');
       for(int i = 0; i < size; i ++){
           res.append(data[i]);
           if(i != size -1){
                res.append(',');
           }
       }
       res.append(']');
       return res.toString();
    }
}