package com.ag.annotations_;

public class Core {
	public static void main(String[] args) throws Exception {
		SampleCls sampleCls = new SampleCls();
		AnnotationImplementer annotationImplementer = new AnnotationImplementer();
		annotationImplementer.implement(sampleCls);

		NameCheckImplementer nameCheckImplementer = new NameCheckImplementer();
		nameCheckImplementer.implement(sampleCls);
	}
}
