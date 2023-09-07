package com.Java_Programming.alpha._20_recursionBasic;

import com.Java_Programming.learning.alpha._20_recursionBasic.RemoveDuplicateInAString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RemoveDuplicateInAStringTest {

    @Test
    void removeDuplicateFromString() {
        String str = RemoveDuplicateInAString.removeDuplicateFromString( "ddiippaaannkkarr" , new HashSet<>()) ;
        Assertions.assertEquals(7 , str.length());
        assertTrue(str.equals("dipankr"));

        str = RemoveDuplicateInAString.removeDuplicateFromString( "dddrrr" , new HashSet<>()) ;
        Assertions.assertEquals(2 , str.length());
        assertTrue(str.equals("dr"));
    }
}