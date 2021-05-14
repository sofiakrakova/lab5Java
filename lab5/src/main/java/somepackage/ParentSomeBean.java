package somepackage;

import injectable.AutoInjectable;

public class ParentSomeBean {
    @AutoInjectable
    private IncludeSomeBean parentField;

    public void foo(){
        parentField.doSomething();
    }

}
