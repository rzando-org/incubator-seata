/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.seata.common.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The eurekaRegistry exception.
 *
 */
public class EurekaRegistryExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        exceptionAsserts(new EurekaRegistryException(FrameworkErrorCode.UnknownAppError.getErrMessage()));
    }

    @Test
    public void testConstructorWithMessageAndThrowable() {
        exceptionAsserts(new EurekaRegistryException(FrameworkErrorCode.UnknownAppError.getErrMessage(), new Throwable()));
    }

    @Test
    public void testConstructorWithThrowable() {
        assertThat(new EurekaRegistryException(new Throwable(FrameworkErrorCode.UnknownAppError.getErrMessage()))).isInstanceOf(EurekaRegistryException.class).hasMessage("java.lang.Throwable: " + FrameworkErrorCode.UnknownAppError.getErrMessage());
    }

    private static void exceptionAsserts(EurekaRegistryException exception) {
        assertThat(exception).isInstanceOf(EurekaRegistryException.class).hasMessage(FrameworkErrorCode.UnknownAppError.getErrMessage());
    }
}
