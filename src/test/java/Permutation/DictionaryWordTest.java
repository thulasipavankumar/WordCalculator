package Permutation;
import org.example.SpringBoot.WordCalculator.Dictionary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DictionaryWordTest {
    private final List<String> dictionaryWords = Arrays.asList("popular","word","industry","page","sheets"),
            notDictionaryWords=Arrays.asList("asdasdzxcasd","asdascxcewcd","blushas","asdubasjbdas");
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
}
