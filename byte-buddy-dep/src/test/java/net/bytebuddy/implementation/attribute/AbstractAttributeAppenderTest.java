package net.bytebuddy.implementation.attribute;

import net.bytebuddy.test.utility.MockitoRule;
import org.junit.Rule;
import org.junit.rules.TestRule;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class AbstractAttributeAppenderTest {

    @Rule
    public TestRule mockitoRule = new MockitoRule(this);

    protected @interface Qux {

        class Instance implements Qux {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Qux.class;
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Baz {

        class Instance implements Baz {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Baz.class;
            }
        }
    }

    @Retention(RetentionPolicy.CLASS)
    protected @interface QuxBaz {

        class Instance implements QuxBaz {

            @Override
            public Class<? extends Annotation> annotationType() {
                return QuxBaz.class;
            }
        }
    }
}
