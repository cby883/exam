package com.chenbingyi.exam;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * LetterCombination
 *
 * @author chenbingyi
 * @date 2020.12.22
 * @blame Given an integer array containing digits from [0, 9], the task is to print all possible letter
 * combinations that the numbers could represent. A mapping of digit to letters (just like
 * on the telephone buttons) is being followed. Note that 0 and 1 do not map to any
 * letters. All the mapping are shown in the image below:
 * @test 单元测试在ExamServicesApplicationTests中
 */
@Service
public class LetterCombination {
    public final int ONE = 1;
    public static Map<String, List<String>> data = new HashMap<>();

    static {
        data.put("0", Collections.emptyList());
        data.put("1", Collections.emptyList());
        data.put("2", Arrays.asList("a", "b", "c"));
        data.put("3", Arrays.asList("d", "e", "f"));
        data.put("4", Arrays.asList("g", "h", "i"));
        data.put("5", Arrays.asList("j", "k", "l"));
        data.put("6", Arrays.asList("m", "n", "o"));
        data.put("7", Arrays.asList("p", "q", "r", "s"));
        data.put("8", Arrays.asList("t", "u", "v"));
        data.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    /**
     * @param arr
     * @return List
     * @desc 回溯+递归解法
     */
    public List<String> combination(List<Integer> arr) {
        String keys = arr.toString();
        //从缓存取
        if (data.containsKey(keys)) {
            return data.get(keys);
        }
        //判空处理
        if (arr == null || arr.isEmpty()) {
            return Collections.emptyList();
        }
        //只有一个元素
        if (arr.size() == ONE) {
            int num = arr.get(0) % 10;
            return new ArrayList<String>(data.get(num + ""));
        }
        //拆分数组
        int firstNum = arr.get(0) % 10;
        List<Integer> subArr = arr.subList(1, arr.size());
        //递归调用
        List<String> subResult = combination(subArr);
        //构造结果
        List<String> strList = data.get(firstNum + "");
        //判断第一个元素的字符串集是否为空
        if (strList == null || strList.isEmpty()) {
            return subResult;
        }
        //不为空，则和子字符串序列构造结果字符串集合
        List<String> result = new ArrayList<>();
        //构造结果
        strList.forEach(s1->{
            subResult.forEach(s2->{
                result.add(s1+s2);
            });
        });
        //缓存结果数据
        data.put(arr.toString(), result);
        return result;
    }

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        List<Integer> arr1 = Arrays.asList(10, 0,2,19,3);
        List<String> ll = letterCombination.combination(arr1);
        System.out.println(ll);

    }
}
