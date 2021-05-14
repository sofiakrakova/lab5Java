package somepackage;

import injectable.AutoInjectable;

public class SomeBean extends ParentSomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    @AutoInjectable
    private IncludeSomeBean field3;

    @Override
    public void foo(){
        super.foo();
        field1.doSomething();
        field2.doSomeOther();
        field3.doSomething();
    }
}
