package manyParent;

import injectable.AutoInjectable;

public class Many extends ManyParent {
    @AutoInjectable
    private IManyParentField field;
    @Override
    public int getValue(){
        return field.getValue() + super.getValue();
    }
}
