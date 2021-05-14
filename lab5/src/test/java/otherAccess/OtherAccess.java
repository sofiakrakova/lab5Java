package otherAccess;

import injectable.AutoInjectable;

public class OtherAccess {
    @AutoInjectable
    public IOtherAccessField field1;
    @AutoInjectable
    protected IOtherAccessField field2;
    @AutoInjectable
    IOtherAccessField field3;
    @AutoInjectable
    private IOtherAccessField field4;

    public int getValue() {
        return field1.getValue() + field2.getValue() + field3.getValue() + field4.getValue();
    }

}
