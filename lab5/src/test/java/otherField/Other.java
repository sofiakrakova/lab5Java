package otherField;

import injectable.AutoInjectable;

public class Other {
    @AutoInjectable
    private IOtherField field;

    public int getValue(){
        return field.getValue();
    }

}
