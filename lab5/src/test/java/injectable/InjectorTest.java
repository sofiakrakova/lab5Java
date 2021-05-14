package injectable;

import anyFields.AnyFields;
import manyParent.ManySon;
import oneParent.One;
import otherAccess.OtherAccess;
import otherField.Other;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InjectorTest {

    @org.junit.jupiter.api.Test
    void anyFieldsInject() throws FileNotFoundException {
        Injector injector = new Injector(new File(InjectorTest.class.getResource("/any_fields.properties").getFile()));
        AnyFields testObject = injector.inject(new AnyFields());
        assertEquals("Ham44", testObject.getValue());
    }

    @org.junit.jupiter.api.Test
    void oneParentInject() throws FileNotFoundException {
        Injector injector = new Injector(new File(InjectorTest.class.getResource("/one_parent.properties").getFile()));
        One testObject = injector.inject(new One());
        assertEquals(2, testObject.getValue());
    }

    @org.junit.jupiter.api.Test
    void manyParentInject() throws FileNotFoundException {
        Injector injector = new Injector(new File(InjectorTest.class.getResource("/many_parent.properties").getFile()));
        ManySon testObject = injector.inject(new ManySon());
        assertEquals(3, testObject.getValue());
    }

    @org.junit.jupiter.api.Test
    void otherAccessInject() throws FileNotFoundException {
        Injector injector = new Injector(new File(InjectorTest.class.getResource("/other_access.properties").getFile()));
        OtherAccess testObject = injector.inject(new OtherAccess());
        assertEquals(4, testObject.getValue());
    }

    @org.junit.jupiter.api.Test
    void otherFieldInject() throws FileNotFoundException {
        Injector first = new Injector(new File(InjectorTest.class.getResource("/other_field_first.properties").getFile()));
        Other firstTestObject = first.inject(new Other());
        Injector second = new Injector(new File(InjectorTest.class.getResource("/other_field_second.properties").getFile()));
        Other secondTestObject = second.inject(new Other());
        assertNotEquals(firstTestObject.getValue(), secondTestObject.getValue());
        assertEquals(1, firstTestObject.getValue());
        assertEquals(2, secondTestObject.getValue());
    }
}