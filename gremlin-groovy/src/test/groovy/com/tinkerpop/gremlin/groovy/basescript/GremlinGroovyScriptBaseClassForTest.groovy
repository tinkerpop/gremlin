package com.tinkerpop.gremlin.groovy.basescript

/**
 * @author Pieter Martin
 */
abstract class GremlinGroovyScriptBaseClassForTest extends Script {

    def useInterceptor= { Class theClass, Class theInterceptor, Closure theCode->
        def proxy= ProxyMetaClass.getInstance( theClass )
        def interceptor= theInterceptor.newInstance()
        proxy.interceptor= interceptor
        proxy.use( theCode )
    }

}
