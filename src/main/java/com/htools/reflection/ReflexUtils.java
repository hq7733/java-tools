package com.htools.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hq
 * @date 2023/8/10
 */
public class ReflexUtils {
    /**
     * 创建对象
     *
     * @param className 类名
     * @return 类对象
     */
    public static Object createObject(String className) {
        Class[] pareTyples = new Class[]{};
        Object[] pareVaules = new Object[]{};

        try {
            Class r = Class.forName(className);
            return createObject(r, pareTyples, pareVaules);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 创建对象
     *
     * @param clazz {@link Class}
     * @return 类对象
     */
    public static Object createObject(Class clazz) {
        Class[] pareTyple = new Class[]{};
        Object[] pareVaules = new Object[]{};

        return createObject(clazz, pareTyple, pareVaules);
    }

    /**
     * 调用单个参数的构造方法，创建对象
     *
     * @param className 类名
     * @param pareTyple 参数类型
     * @param pareVaule 参数值
     * @return 类对象
     */
    public static Object createObject(String className, Class pareTyple, Object pareVaule) {

        Class[] pareTyples = new Class[]{pareTyple};
        Object[] pareVaules = new Object[]{pareVaule};

        try {
            Class r = Class.forName(className);
            return createObject(r, pareTyples, pareVaules);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 调用单个参数的构造方法，创建对象
     *
     * @param clazz     {@link Class}
     * @param pareTyple 参数类型
     * @param pareVaule 参数值
     * @return 类对象
     */
    public static Object createObject(Class clazz, Class pareTyple, Object pareVaule) {
        Class[] pareTyples = new Class[]{pareTyple};
        Object[] pareVaules = new Object[]{pareVaule};

        return createObject(clazz, pareTyples, pareVaules);
    }

    /**
     * 调用单个参数的构造方法，创建对象，已知className
     *
     * @param className  类名
     * @param pareTyples 参数类型
     * @param pareVaules 参数值
     * @return 类对象
     */
    public static Object createObject(String className, Class[] pareTyples, Object[] pareVaules) {
        try {
            Class r = Class.forName(className);
            return createObject(r, pareTyples, pareVaules);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 调用单个参数的构造方法，创建对象，已知class
     *
     * @param clazz      {@link Class}
     * @param pareTyples 参数类型数组
     * @param pareVaules 参数值数组
     * @return 类对象
     */
    public static Object createObject(Class clazz, Class[] pareTyples, Object[] pareVaules) {
        try {
            Constructor ctor = clazz.getDeclaredConstructor(pareTyples);
            ctor.setAccessible(true);
            return ctor.newInstance(pareVaules);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 调用私有方法
     *
     * @param obj        对象
     * @param methodName 方法名
     * @param pareTyples 参数类型数组
     * @param pareVaules 参数值数组
     * @return 方法返回值
     */
    public static Object invokeInstanceMethod(Object obj, String methodName, Class[] pareTyples, Object[] pareVaules) {
        if (obj == null) {
            return null;
        }

        try {
            //调用一个private方法 //在指定类中获取指定的方法
            Method method = obj.getClass().getDeclaredMethod(methodName, pareTyples);
            method.setAccessible(true);
            return method.invoke(obj, pareVaules);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 调用实例方法
     *
     * @param obj        对象
     * @param methodName 方法名
     * @param pareTyple  参数类型
     * @param pareVaule  参数值
     * @return 方法返回值
     */
    public static Object invokeInstanceMethod(Object obj, String methodName, Class pareTyple, Object pareVaule) {
        Class[] pareTyples = {pareTyple};
        Object[] pareVaules = {pareVaule};

        return invokeInstanceMethod(obj, methodName, pareTyples, pareVaules);
    }

    /**
     * 调用无餐的实例方法
     *
     * @param obj        对象
     * @param methodName 方法名
     * @return 方法返回值
     */
    public static Object invokeInstanceMethod(Object obj, String methodName) {
        Class[] pareTyples = new Class[]{};
        Object[] pareVaules = new Object[]{};

        return invokeInstanceMethod(obj, methodName, pareTyples, pareVaules);
    }


    /**
     * 调用无参数的静态方法
     *
     * @param className  类名
     * @param methodName 方法名
     * @return
     */
    public static Object invokeStaticMethod(String className, String methodName) {
        Class[] pareTyples = new Class[]{};
        Object[] pareVaules = new Object[]{};

        return invokeStaticMethod(className, methodName, pareTyples, pareVaules);
    }

    /**
     * 调用有一个参数的静态方法
     *
     * @param className  类名
     * @param methodName 方法名
     * @param pareTyple  参数类型
     * @param pareVaule  参数值
     * @return 方法返回值
     */
    public static Object invokeStaticMethod(String className, String methodName, Class pareTyple, Object pareVaule) {
        Class[] pareTyples = new Class[]{pareTyple};
        Object[] pareVaules = new Object[]{pareVaule};

        return invokeStaticMethod(className, methodName, pareTyples, pareVaules);
    }

    /**
     * 调用多个参数的静态方法
     *
     * @param className  类名
     * @param methodName 方法名
     * @param pareTyples 参数类型数组
     * @param pareVaules 参数值数组
     * @return 方法返回值
     */
    public static Object invokeStaticMethod(String className, String methodName, Class[] pareTyples, Object[] pareVaules) {
        try {
            Class obj_class = Class.forName(className);
            return invokeStaticMethod(obj_class, methodName, pareTyples, pareVaules);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Object invokeStaticMethod(Class clazz, String methodName, Class[] pareTyples, Object[] pareVaules) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, pareTyples);
            method.setAccessible(true);
            return method.invoke(null, pareVaules);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Object getFieldObject(String className, Object obj, String filedName) {
        try {
            Class obj_class = Class.forName(className);
            return getFieldObject(obj_class, obj, filedName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getFieldObject(Class clazz, Object obj, String filedName) {
        try {
            Field field = clazz.getDeclaredField(filedName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void setFieldObject(Class clazz, Object obj, String filedName, Object filedVaule) {
        try {
            Field field = clazz.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(obj, filedVaule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFieldObject(String className, Object obj, String filedName, Object filedVaule) {
        try {
            Class obj_class = Class.forName(className);
            setFieldObject(obj_class, obj, filedName, filedVaule);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
