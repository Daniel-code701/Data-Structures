import java.util.Stack;

//使用栈 判断"([{ }])"
public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            //取出每次循环出的字符
            char c = s.charAt(i);
           //先将左侧的括号压入栈
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(stack.isEmpty()){
                //如果没有符合的字符压入 堆栈为空 匹配失败 返回false
                return false;
            }

            //对右侧进行匹配 从栈顶开始取出字符
            char topChar = stack.pop();
            //如果c 循环出的右侧字符符合条件 但从栈顶取出的左侧字符不符合 返回false
            if(c == ')' && topChar != '('){
                return false;
            }
            if(c == ']' && topChar != '['){
                return false;
            }
            if(c == '}' && topChar != '{'){
                return false;
            }

        }
        //最后判断栈顶是否还有字符 只要当栈顶为空的时候 才匹配成功
        return stack.isEmpty();
    }
}
