package com.chenbingyi;

import com.chenbingyi.exam.LetterCombination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@SpringBootTest
class ExamServicesApplicationTests {

	@Autowired
	LetterCombination letterCombination;
	@Test
	void combinationTest() {
		List<String> expectResult=List.of("ad","ae","af","bd","be","bf","cd","ce","cf");
		List<Integer> arr1 = Arrays.asList(2,3);
		List<Integer> arr2=Arrays.asList(12,13);
		List<String> result1 = letterCombination.combination(arr1);
		List<String> result2=letterCombination.combination(arr2);
		assert result1.toString().equals(expectResult.toString());
		assert result2.toString().equals(expectResult.toString());
	}

}
