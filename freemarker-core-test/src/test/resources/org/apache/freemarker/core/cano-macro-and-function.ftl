<#ftl stripWhitespace=false>
<#--
  Licensed to the Apache Software Foundation (ASF) under one
  or more contributor license agreements.  See the NOTICE file
  distributed with this work for additional information
  regarding copyright ownership.  The ASF licenses this file
  to you under the Apache License, Version 2.0 (the
  "License"); you may not use this file except in compliance
  with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing,
  software distributed under the License is distributed on an
  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
  KIND, either express or implied.  See the License for the
  specific language governing permissions and limitations
  under the License.
-->
<#macro m></#macro>
<#macro m a></#macro>
<#macro m a b></#macro>
<#macro m a b c...></#macro>
<#macro m a...></#macro>
<#macro m p1{positional}, p2{positional}, pva{positional}... n1 n2 nva...></#macro>
<#macro m p1{positional}, p2{positional}=2, pva{positional}... n1=3 n2 nva...></#macro>
<#macro m a{positional}></#macro>
<#macro m a{positional}=1></#macro>
<#macro m a{positional}...></#macro>
<#macro m nva{positional}... pva...></#macro>
<#function f()></#function>
<#function f(a)></#function>
<#function f(a, b)></#function>
<#function f(a, b, c...)></#function>
<#function f(a...)></#function>
<#function f(p1, p2, pva..., n1{named}, n2{named}, nva{named}...)></#function>
<#function f(p1, p2=2, pva..., n1{named}, n2{named}=3, nva{named}...)></#function>
<#function f(a{named})></#function>
<#function f(a{named}=1)></#function>
<#function f(a{named}...)></#function>
<#function f(nva..., pva{named}...)></#function>

<#macro  m  p1 { positional } , p2 { positional } = 2 , pva { positional } ... n1 = 3 n2 nva ... ></#macro >