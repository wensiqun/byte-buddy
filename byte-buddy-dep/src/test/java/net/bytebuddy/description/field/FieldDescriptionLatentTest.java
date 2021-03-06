package net.bytebuddy.description.field;

import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.type.TypeDescription;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class FieldDescriptionLatentTest extends AbstractFieldDescriptionTest {

    private static final String FOO = "foo";

    @Override
    protected FieldDescription describe(Field field) {
        return new FieldDescription.Latent(field.getName(),
                new TypeDescription.ForLoadedType(field.getDeclaringClass()),
                new TypeDescription.ForLoadedType(field.getType()),
                field.getModifiers());
    }

    @Test
    @Override
    public void testAnnotations() throws Exception {
        assertThat(new FieldDescription.Latent(FOO,
                mock(TypeDescription.class),
                mock(TypeDescription.class),
                0).getDeclaredAnnotations(), is((AnnotationList) new AnnotationList.Empty()));
    }
}
