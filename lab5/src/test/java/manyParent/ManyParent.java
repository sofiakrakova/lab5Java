package manyParent;

import injectable.AutoInjectable;

public class ManyParent {

    @AutoInjectable
    private IManyParentField parentField;

    public int getValue(){
        return parentField.getValue();
    }

}
