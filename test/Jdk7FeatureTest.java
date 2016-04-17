package cn.longyt.test;

import java.util.Set;

import org.junit.Test;

public class Jdk7FeatureTest {

    @Test
    public void test001() {
        String s = "test";
        switch (s) {
        case "test":
            System.out.println(s);
            break;
        case "test1":
            System.out.println("test1");
            break;
        default:
            System.out.println("break");
            break;
        }
    }
    
    @Test
    public void test002(){
        byte aByte = (byte)0b0110001;
        System.out.println(aByte);
    }
}
