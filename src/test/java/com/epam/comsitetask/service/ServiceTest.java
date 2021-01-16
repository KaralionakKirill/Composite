package com.epam.comsitetask.service;

import com.epam.compositetask.composite.Component;
import com.epam.compositetask.composite.impl.Composite;
import com.epam.compositetask.parser.Parser;
import com.epam.compositetask.parser.impl.ParagraphParser;
import com.epam.compositetask.reader.TextReader;
import com.epam.compositetask.service.CompositeService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServiceTest {
    CompositeService service = new CompositeService();
    Parser parser = new ParagraphParser();
    TextReader reader = new TextReader();
    String text;
    Composite textComposite;

    @BeforeTest
    public void beforeClass() {
        text = reader.readFromFile("text");
        textComposite = parser.parse(text);
    }

    @Test
    public void findSentenceWithLongestWord() {
        Component actual = service.findSentenceWithLongestWord(textComposite);
        Component expected = textComposite.getChild(0).getChild(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deleteSentenceLessSize() {
        Component actual = service.deleteSentenceLessSize(textComposite,12);
        Component expected = textComposite;
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void numberSimilarWords() {
        int actual = service.numberSimilarWords(textComposite,"программ");
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }
}
