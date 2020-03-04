//定义一个接口类
public interface Stack<E> {
    //获取栈的元素个数
    int getSize();
    //查看栈是否为空
    boolean isEmpty();
    //向栈压入一个元素
    void push(E e);
    //弹出一个元素
    E pop();
    //查看栈顶的元素
    E peek();
}