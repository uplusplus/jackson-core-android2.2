package com.fasterxml.jackson.core;

import java.lang.reflect.Array;

public class Arrays{
			// 支持基础类型，结果需要转换类型
	public static final <T> T copyOf(T $source, int $newLength) {
		Class<?> __type = $source.getClass().getComponentType();
		int __oldLength = Array.getLength($source);
		T __target = (T)Array.newInstance(__type, $newLength);
		int __preserveLength = Math.min(__oldLength, $newLength);
		System.arraycopy($source, 0, __target, 0, __preserveLength);
		return __target;
	}

	// 支持泛型，但不支持基础类型数组，例如要处理byte[]需要使用上面的方法。
	public static final <T> T[] copyOf(T[] $source, int $newLength) {
		Class<?> __type = $source.getClass().getComponentType();
		int __oldLength = Array.getLength($source);
		@SuppressWarnings("unchecked")
		T[] __target = (T[]) Array.newInstance(__type, $newLength);
		int __preserveLength = Math.min(__oldLength, $newLength);
		System.arraycopy($source, 0, __target, 0, __preserveLength);
		return __target;
	}
}
