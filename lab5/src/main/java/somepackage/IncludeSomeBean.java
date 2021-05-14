package somepackage;

import injectable.AutoInjectable;

public class IncludeSomeBean {
    @AutoInjectable
    private SomeOtherInterface field;
    public void doSomething(){
        field.doSomeOther();
    }
}
