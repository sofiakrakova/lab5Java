package anyFields;

import injectable.AutoInjectable;

public class AnyFields {
    @AutoInjectable
    private IAnyField1 anyField1;
    @AutoInjectable
    private IAnyField2 anyField2;

    public String getValue(){
        return anyField2.getValue() + anyField1.getValue();
    }

}
