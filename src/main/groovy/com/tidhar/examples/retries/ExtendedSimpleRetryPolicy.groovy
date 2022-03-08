package com.tidhar.examples.retries

import org.springframework.retry.RetryContext
import org.springframework.retry.policy.SimpleRetryPolicy

class ExtendedSimpleRetryPolicy extends SimpleRetryPolicy{

    @Override
    boolean canRetry(RetryContext context) {
        println("canRetry: ${context}")
        Integer result = context.getAttribute("result")
        return super.canRetry(context) && result == null
    }
}
