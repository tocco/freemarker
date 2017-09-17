/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.freemarker.core;

/**
 * AST directive node: {@code #break}
 */
final class ASTDirBreak extends ASTDirective {

    @Override
    ASTElement[] accept(Environment env) {
        throw BreakOrContinueException.BREAK_INSTANCE;
    }

    @Override
    protected String dump(boolean canonical) {
        return canonical ? "<" + getASTNodeDescriptor() + "/>" : getASTNodeDescriptor();
    }
    
    @Override
    String getASTNodeDescriptor() {
        return "#break";
    }

    @Override
    int getParameterCount() {
        return 0;
    }

    @Override
    Object getParameterValue(int idx) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    ParameterRole getParameterRole(int idx) {
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    boolean isNestedBlockRepeater() {
        return false;
    }
    
}
