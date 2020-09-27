package Permutation;


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
    private HashSet<String> words_for_string_is_not = new HashSet<String>(Arrays.asList("not", "ont","nto","tno","ton","otn"));
    private final List<String> dictionaryWords = Arrays.asList("popular","word","industry","page","sheets"),
    notDictionaryWords=Arrays.asList("asdasdzxcasd","asdascxcewcd","blushas","asdubasjbdas");

    private HashSet<String> words_for_string_is_word = new HashSet<String>(Arrays.asList("not", "ont","nto","tno","ton","otn"));

    @Before
    public void SetUp() {

    }

    @Test
    public void test_for_a_word_is_not() {

         permutation = new Permutation("not");
        HashSet<String> words =  get_available_words_for_a_given_word("not");

        Assert.assertEquals(words_for_string_is_not,words);
        Assert.assertFalse(words.isEmpty());


    }

    @Test
    public void test_is_a_Dictionary_word(){
        dictionaryWords.stream().forEach(val->{

          Assert.assertTrue(Dictionary.isDictionaryWord(val));
      });
    }
    @Test
    public void test_is_not_a_Dictionary_word(){
        notDictionaryWords.stream().forEach(val->{
            Assert.assertFalse(Dictionary.isDictionaryWord(val));
        });
    }
    @Test
    public void testForEmpty() {
        HashSet<String> shouldBeEmptyList =  get_available_words_for_a_given_word("");
        Assert.assertEquals(1,shouldBeEmptyList.size());
    }
    private HashSet<String> get_available_words_for_a_given_word(String word){

        return new Permutation(word).getWorldList();
    }
    private HashSet<String> get_available_words_for_a_given_word(Permutation obj){
        return  obj.getWorldList();
    }

}
