package Main;

import Amd.*;
import Intel.*;
import General.ComponentFactory;

public class Program {

    public static void main(String[] args) {

        ComponentFactory factory = new ComponentFactory<>();

        AmdCPU cpu1 = (AmdCPU) factory.createComponent("cpu", "amd", "Raishen-9");



        AmdCPU cpu2 = cpu1.prototype();
        
        cpu2.setModel("Model copy");
        System.out.println(cpu2.getModel());
        System.out.println(cpu1.getModel());

    }

}
