package oneParent;

import injectable.AutoInjectable;

public class One extends OneParent {

    @AutoInjectable
    private IOneParentField field;

    @Override
    public int getValue(){
        return field.getValue() + super.getValue();
    }

}
