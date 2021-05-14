package manyParent;

import injectable.AutoInjectable;

public class ManySon extends Many {
    @AutoInjectable
    private IManyParentField fieldSon;
    @Override
    public int getValue(){
        return fieldSon.getValue() + super.getValue();
    }
}
