package net.bytebuddy.dynamic.scaffold.inline;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.test.utility.MockitoRule;
import net.bytebuddy.test.utility.ObjectPropertyAssertion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class MethodRebaseResolverMethodNameTransformerPrefixingTest {

    private static final String FOO = "foo";

    @Rule
    public TestRule mockitoRule = new MockitoRule(this);

    @Mock
    private MethodDescription methodDescription;

    @Test
    public void testTransformation() throws Exception {
        when(methodDescription.getInternalName()).thenReturn(FOO);
        String transformed = new MethodRebaseResolver.MethodNameTransformer.Prefixing().transform(methodDescription);
        assertThat(transformed, not(FOO));
        assertThat(transformed, endsWith(FOO));
    }

    @Test
    public void testObjectProperties() throws Exception {
        ObjectPropertyAssertion.of(MethodRebaseResolver.MethodNameTransformer.Prefixing.class).apply();
    }
}
