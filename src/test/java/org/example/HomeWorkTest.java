package org.example;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    public void testPartitionBy() {
        Predicate<Integer> lessThan4 = i -> (i < 4);

        //null list
        assertEquals(0, homeWork.partitionBy(null, lessThan4));

        //one-element list, pred(list[0]) is false
        assertEquals(0, homeWork.partitionBy(new Node<>(4), lessThan4));

        //one-element list, pred(list[0]) is true
        assertEquals(1, homeWork.partitionBy(new Node<>(3), lessThan4));

        //all list elements satisfy pred
        Node<Integer> list1 = new Node<>(0);
        list1.add(1).add(2);
        assertEquals(3, homeWork.partitionBy(list1, lessThan4));

        //no list elements satisfy pred
        Node<Integer> list2 = new Node<>(4);
        list2.add(5).add(6);
        assertEquals(0, homeWork.partitionBy(list2, lessThan4));

        //some list elements satisfy pred, other - not
        Node<Integer> list3 = new Node<>(0);
        list3.add(1).add(2).add(4).add(5);
        assertEquals(3, homeWork.partitionBy(list3, lessThan4));

        //some list elements satisfy pred, other - not
        Node<Integer> list4 = new Node<>(4);
        list3.add(3).add(0).add(1).add(5);
        assertEquals(0, homeWork.partitionBy(list4, lessThan4));
    }

    @Test
    public void testFindNthElement() {
        Node<Integer> list = new Node<>(0);
        list.add(1).add(2).add(3).add(4);

        //find first element
        assertEquals(0, homeWork.findNthElement(list, 0));
        //find element
        assertEquals(2, homeWork.findNthElement(list, 2));
        //find last element
        assertEquals(4, homeWork.findNthElement(list, 4));
        //find element before first
        assertThrows(IllegalArgumentException.class, () -> homeWork.findNthElement(list, -1));
        //find element after last
        assertThrows(IllegalArgumentException.class, () -> homeWork.findNthElement(list, 5));
        //find element for null list
        assertThrows(IllegalArgumentException.class, () -> homeWork.findNthElement(null, 0));
    }

}