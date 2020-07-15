package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {

//   TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Computer


    @Test
    public void constructorShouldCreateValidInstance() {
        Computer computer = new Computer("Word");

        String expectedName = "Word";
        String actualName = computer.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorInvalid1() {
        Computer computer = new Computer("");

    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorInvalid2() {
        Computer computer = new Computer(null);
    }

    @Test
    public void getNameTest() {
        Computer computer = new Computer("Word");

        String expectedName = "Word";
        String actualName = computer.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void addPartTest() {
        Computer computer = new Computer("Word");
        Part part1 = new Part("part1", 1.2);
        Part part2 = new Part("part2", 1.2);
        computer.addPart(part1);
        computer.addPart(part2);

        List parts = new ArrayList<>();
        parts.add(part1);
        parts.add(part2);

        Assert.assertArrayEquals(parts.toArray(), computer.getParts().toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPartTestInvalid() {
        Computer computer = new Computer("Word");
        computer.addPart(null);
    }

    @Test
    public void getPartsTest() {
        Computer computer = new Computer("Word");
        Part part1 = new Part("part1", 1.2);
        Part part2 = new Part("part2", 1.2);
        computer.addPart(part1);
        computer.addPart(part2);

        List expectedPart = new ArrayList<>();
        expectedPart.add(part1);
        expectedPart.add(part2);

        List actualPart = computer.getParts();
        Assert.assertArrayEquals(expectedPart.toArray(), actualPart.toArray());
    }

    @Test
    public void getTotalPriceTest() {
        Computer computer = new Computer("Word");
        Part part1 = new Part("part1", 1.0);
        Part part2 = new Part("part2", 1.0);
        computer.addPart(part1);
        computer.addPart(part2);

        String expectedPrice = String.valueOf(2.0);
        String actualPrice = String.valueOf(computer.getTotalPrice());

        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void removePartTest() {
        Computer computer = new Computer("Word");
        Part part1 = new Part("part1", 1.2);
        Part part2 = new Part("part2", 1.2);
        computer.addPart(part1);
        computer.addPart(part2);

        List expectedPart = new ArrayList<>();
        expectedPart.add(part1);
        expectedPart.add(part2);
        expectedPart.remove(part2);

        computer.removePart(part2);
        List actualPart = computer.getParts();

        Assert.assertArrayEquals(expectedPart.toArray(), actualPart.toArray());
    }

    @Test
    public void getPartTest() {
        Computer computer = new Computer("Word");
        Part part1 = new Part("part1", 1.2);
        Part part2 = new Part("part2", 1.2);
        computer.addPart(part1);
        computer.addPart(part2);

        Part expectedPartName = part2;
        Part actualPartName = computer.getPart(part2.getName());

        Assert.assertEquals(expectedPartName, actualPartName);

    }
}