package Permutation;


import org.example.SpringBoot.Exception.CannotComputeException;
import org.example.SpringBoot.WordCalculator.Dictionary;
import org.example.SpringBoot.WordCalculator.Permutation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationTest {
    private Permutation permutation;
    private final HashSet<String> words_for_string_is_not = new HashSet<String>(Arrays.asList("not", "ont","nto","tno","ton","otn"));


    private final HashSet<String> words_for_string_is_word = new HashSet<String>(Arrays.asList("not", "ont","nto","tno","ton","otn"));

    @Before
    public void SetUp() {

    }

    @Test
    public void test_for_a_word_is_not() throws CannotComputeException {

         permutation = new Permutation("not");
        HashSet<String> words =  get_available_words_for_a_given_word("not");
        Assert.assertEquals(words_for_string_is_not,words);
        Assert.assertFalse(words.isEmpty());


    }


    @Test
    public void testForEmpty() throws CannotComputeException {
        HashSet<String> shouldBeEmptyList =  get_available_words_for_a_given_word("");
        Assert.assertEquals(1,shouldBeEmptyList.size());
    }
    private HashSet<String> get_available_words_for_a_given_word(String word) throws CannotComputeException {

        return new Permutation(word).getWorldList();
    }
    private HashSet<String> get_available_words_for_a_given_word(Permutation obj) throws CannotComputeException{
        return  obj.getWorldList();
    }

}
