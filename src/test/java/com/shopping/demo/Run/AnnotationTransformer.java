package com.shopping.demo.Run;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class aClass, Constructor construct, Method method) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}
