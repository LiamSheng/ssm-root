package linzi.ssm.spring01ioc.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class windowsConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 判断环境中的OS
        String osName = context.getEnvironment().getProperty("OS");
        assert osName != null;
        return osName.contains("Windows");
    }
}
