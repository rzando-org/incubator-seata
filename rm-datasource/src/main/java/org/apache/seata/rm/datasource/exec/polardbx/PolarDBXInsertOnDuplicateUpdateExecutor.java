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
package org.apache.seata.rm.datasource.exec.polardbx;

import org.apache.seata.common.loader.LoadLevel;
import org.apache.seata.common.loader.Scope;
import org.apache.seata.rm.datasource.StatementProxy;
import org.apache.seata.rm.datasource.exec.StatementCallback;
import org.apache.seata.rm.datasource.exec.mysql.MySQLInsertOnDuplicateUpdateExecutor;
import org.apache.seata.sqlparser.SQLRecognizer;
import org.apache.seata.sqlparser.util.JdbcConstants;

/**
 * Insert on duplicated update executor for PolarDB-X
 *
 */
@LoadLevel(name = JdbcConstants.POLARDBX, scope = Scope.PROTOTYPE)
public class PolarDBXInsertOnDuplicateUpdateExecutor extends MySQLInsertOnDuplicateUpdateExecutor {
    public PolarDBXInsertOnDuplicateUpdateExecutor(StatementProxy statementProxy, StatementCallback statementCallback,
                                                   SQLRecognizer sqlRecognizer) {
        super(statementProxy, statementCallback, sqlRecognizer);
    }
}
