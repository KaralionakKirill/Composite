package com.epam.compositetask.service;

import com.epam.compositetask.composite.Component;
import com.epam.compositetask.composite.impl.Composite;

import java.util.Comparator;
import java.util.List;

public class CompositeService {

    public int countVowel(Component component) {
        int result = 0;
        for (int i = 0; i < component.count(); i++) {
            result += isVowel(component.buildStr().toLowerCase()) ? 1 : 0;
        }
        return result;
    }

    private boolean isVowel(String letter) {
        String[] vowels = {"а", "у", "е", "ё", "ы", "о", "э", "я", "и", "ю"};
        for (String vowel : vowels) {
            if (letter.equals(vowel)) {
                return true;
            }
        }
        return false;
    }

    public int countConsonant(Component component) {
        int result = 0;
        for (int i = 0; i < component.count(); i++) {
            result += isVowel(component.buildStr().toLowerCase()) ? 1 : 0;
        }
        return result;
    }

    private boolean isConsonant(String letter) {
        String[] vowels = {"й", "ц", "к", "н", "г", "ш", "щ", "з", "х", "ф", "в", "п", "р", "л", "д",
                "ж", "ч", "с", "м", "т", "б"};
        for (String vowel : vowels) {
            if (letter.equals(vowel)) {
                return true;
            }
        }
        return false;
    }

    public Component findSentenceWithLongestWord(Composite composite) {
        int max = 0;
        Component sentenceWLW = null;
        List<Component> paragraphList = composite.getList();
        for (Component paragraph : paragraphList) {
            List<Component> sentenceList = paragraph.getList();
            for (Component sentence : sentenceList) {
                List<Component> wordList = sentence.getList();
                for (Component word : wordList) {
                    if (word.count() > max) {
                        max = word.count();
                        sentenceWLW = sentence;
                    }
                }
            }
        }
        return sentenceWLW;
    }

    public Component deleteSentenceLessSize(Composite composite, int sentenceSize) {
        List<Component> paragraphList = composite.getList();
        for (Component paragraph : paragraphList) {
            List<Component> sentenceList = paragraph.getList();
            for (Component sentence : sentenceList) {
                if (sentence.count() < sentenceSize) {
                    paragraph.remove(sentence);
                }
            }
        }
        return new Composite(paragraphList);
    }

    public int numberSimilarWords(Composite composite, String searchWord) {
        int count = 0;
        List<Component> paragraphList = composite.getList();
        for (Component paragraph : paragraphList) {
            List<Component> sentenceList = paragraph.getList();
            for (Component sentence : sentenceList) {
                List<Component> wordList = sentence.getList();
                for (Component word : wordList) {
                    String strWord = word.buildStr();
                    strWord = strWord.toLowerCase();
                    if (strWord.equals(searchWord)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public Component sortingByParagraph(Composite composite) {
        List<Component> paragraphList = composite.getList();
        Comparator<Component> comparator = Comparator.comparingInt(Component::count);
        paragraphList.sort(comparator);
        return new Composite(paragraphList);
    }
}
