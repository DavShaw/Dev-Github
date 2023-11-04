package General;

import Amd.*;
import Intel.*;

public class ComponentFactory <Generic> {

    public <Generic> Generic createComponent(String component, String brand, String model) {

        if (brand.equalsIgnoreCase("amd")) {

            switch (component.toLowerCase()) {
                case "cpu":  
                    return (Generic) this.createAmdCPU("AMD", model);
            
                case "gpu":
                    return (Generic) this.createAmdGPU("AMD", model);

                case "ram":
                    return (Generic) this.createAmdRAM("AMD", model);

                default:
                    return null;
            }
        }

        else if (brand.equalsIgnoreCase("intel")) {

            switch (component.toLowerCase()) {
                case "cpu":
                    return (Generic) this.createIntelCPU("Intel", model);
            
                case "gpu":
                    return (Generic) this.createIntelGPU("Intel", model);

                case "ram":
                    return (Generic) this.createIntelRAM("Intel", model);
                
                default:
                    return null;
            }
        }

        else {
            return null;
        }

    }
    
    private AmdCPU createAmdCPU(String brand, String model) {
        return new AmdCPU(brand, model);
    }

    private AmdGPU createAmdGPU(String brand, String model) {
        return new AmdGPU(brand, model);
    }

    private AmdRAM createAmdRAM(String brand, String model) {
        return new AmdRAM(brand, model);
    }

    private IntelCPU createIntelCPU(String brand, String model) {
        return new IntelCPU(brand, model);
    }

    private IntelGPU createIntelGPU(String brand, String model) {
        return new IntelGPU(brand, model);
    }

    private IntelRAM createIntelRAM(String brand, String model) {
        return new IntelRAM(brand, model);
    }



}
