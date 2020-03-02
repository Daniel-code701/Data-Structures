import java.util.Arrays;

public class Array <E>{
    //定义一个成员变量
    private E[] data;
    //用来描述data数组中到底有多少个元素
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        //new 不支持泛型类 Object强制转换
        data = (E[]) new Object[capacity];
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
    public void addLast(E e){

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
    public void addFirst(E e){
        add(0, e);
    }

    //在数组中index位置插入一个元素
    public void add(int index,E e){
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


    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            //判断对象使用equals
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素的索引 如果不存在元素e  则返回-1
    public int find(E e){
        for(int i = 0; i < size; i ++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除元素
    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }

        E res = data[index];

        for(int i = index + 1; i < size; i ++){
            data[i - 1] = data[i];
        }
        data[size] = null; // loitering objects != memory leak
        size --;
        return res;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
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
