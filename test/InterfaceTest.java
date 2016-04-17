package cn.longyt.test;

import cn.longyt.util.InterfaceC;
import cn.longyt.util.InterfaceImpl;

public class InterfaceTest {

    public static void main(String[] args) {
        
        /*InterfaceA ia = new InterfaceImpl();
        ia.test();
        
        InterfaceB ib = new InterfaceImpl();
        ib.teach();*/
        
        InterfaceC ic = new InterfaceImpl();
        ic.test();
        ic.teach();
    }
}
