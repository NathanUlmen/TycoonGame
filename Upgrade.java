//import java.lang.invoke.SwitchPoint;
//import java.math.BigDecimal;
//
//public class Upgrade {
//    String upgradeType;
//    String condition;
//    String methodOfModification, modifier1, modifier2, valueToModify;
//    String comparisonOperator;
//
//    BigDecimal threshold;
//
//
//    public Upgrade() {
//
//    }
//
//    public void upgrade(Ore ore) {
//        switch (upgradeType) {
//            case "conditional" :
//                typeOfConditional(ore);
//            case "constant" :
//                typeOfConstant(ore);
//        }
//    }
//
//    public void typeOfConditional(Ore ore) {
//        switch (condition) {
//            case "value":
//                valueConditional(ore);
//            case "upgrade count":
//                upgadeCountConditional(ore);
//            case "temperature" :
//                temperatureConditional(ore);
//            case "multiOre" :
//                multiOreConditional(ore);
//            case "ore history":
//                historyConditional(ore);
//            case "ore type":
//                oreTypeConditional(ore);
//        }
//    }
//
//    public void typeOfConstant(Ore ore) {
//
//    }
//
//    public void valueConditional(Ore ore) {
//        switch (comparisonOperator) {
//            case ">" :
//               if (ore.getOreValue().compareTo(threshold) == 1) {
//                   modifierType(ore, modifier1);
//               } else {
//                   modifierType(ore, modifier2);
//               }
//            case "<":
//
//        }
//    }
//
//    public void upgadeCountConditional(Ore ore) {
//
//    }
//
//    public void temperatureConditional(Ore ore) {
//
//    }
//    public void multiOreConditional(Ore ore) {
//
//    }
//
//    public void historyConditional(Ore ore) {
//
//    }
//
//    public void oreTypeConditional(Ore ore) {
//
//    }
//
//    public void modifierType(Ore ore, String modifier, String valueToModify) {
//        switch (methodOfModification) {
//            case "multiply":
//                    ore.setOreValue(ore.getOreValue().multiply(new BigDecimal(modifier)));
//            case "add":
//                    ore.setOreValue(ore.getOreValue().multiply(new BigDecimal(modifier)));
//        }
//    }
//
//    public void valueToModify(Ore ore, String modifier, String methodOfModification) {
//        switch (valueToModify) {
//            case "value":
//                modifierType(ore, modifier, valueToModify);
//            case "upgrade count":
//
//            case "temperature" :
//
//            case "multiOre" :
//
//            case "ore history":
//
//            case "ore type":
//
//        }
//    }
//
//
//}
