package oneParent;

import injectable.AutoInjectable;

public class OneParent {

    @AutoInjectable
    private IOneParentField parentField;

    public int getValue(){
        return parentField.getValue();
    }

}
