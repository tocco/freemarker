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

package org.apache.freemarker.spring.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.freemarker.core.CallPlace;
import org.apache.freemarker.core.Environment;
import org.apache.freemarker.core.TemplateException;
import org.apache.freemarker.core.model.ObjectWrapper;
import org.apache.freemarker.core.model.ObjectWrapperAndUnwrapper;
import org.apache.freemarker.core.model.TemplateFunctionModel;
import org.apache.freemarker.core.model.TemplateModel;
import org.apache.freemarker.core.util.CallableUtils;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.AbstractTemplateView;

/**
 * Abstract TemplateFunctionModel for derived classes to support Spring MVC based templating environment.
 */
public abstract class AbstractSpringTemplateFunctionModel extends AbstractSpringTemplateCallableModel
        implements TemplateFunctionModel {

    /**
     * Construct function with servlet request and response.
     * @param request servlet request
     * @param response servlet response
     */
    public AbstractSpringTemplateFunctionModel(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    /**
     * Execute this function.
     * <P>
     * This method establishes Spring's <code>RequestContext</code> and invokes {@link #executeInternal(TemplateModel[], CallPlace, Environment, ObjectWrapperAndUnwrapper, RequestContext)}
     * which must be implemented by derived function classes.
     * </P>
     */
    @Override
    public TemplateModel execute(TemplateModel[] args, CallPlace callPlace, Environment env) throws TemplateException {
        final ObjectWrapper objectWrapper = env.getObjectWrapper();

        if (!(objectWrapper instanceof ObjectWrapperAndUnwrapper)) {
            CallableUtils.newGenericExecuteException(
                    "The ObjectWrapper of environment isn't an instance of ObjectWrapperAndUnwrapper.", this, true);
        }

        TemplateModel rcModel = env.getVariable(AbstractTemplateView.SPRING_MACRO_REQUEST_CONTEXT_ATTRIBUTE);

        if (rcModel == null) {
            CallableUtils.newGenericExecuteException(
                    AbstractTemplateView.SPRING_MACRO_REQUEST_CONTEXT_ATTRIBUTE + " not found.", this, true);
        }

        RequestContext requestContext = (RequestContext) ((ObjectWrapperAndUnwrapper) objectWrapper).unwrap(rcModel);

        return executeInternal(args, callPlace, env, (ObjectWrapperAndUnwrapper) objectWrapper, requestContext);
    }

    /**
     * Interal execution method that is supposed to be implemented by derived directive classes.
     * @param args argument models
     * @param callPlace the place where this is being called
     * @param env template execution environment
     * @param objectWrapperAndUnwrapper ObjectWrapperAndUnwrapper
     * @param requestContext Spring RequestContext
     * @return function execution result template model
     * @throws TemplateException if template exception occurs
     */
    protected abstract TemplateModel executeInternal(TemplateModel[] args, CallPlace callPlace, Environment env,
            ObjectWrapperAndUnwrapper objectWrapperAndUnwrapper, RequestContext requestContext)
                    throws TemplateException;

}
