import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
 * Use Java Reflection API to access the methods and fields of a class at runtime.
 * Also known as a class manipulator as it can be pretty much used to manipulate the 
 * fields and objects.
 * It is pretty useful when debugging applications.
 */
public class TestingReflection {

	
	public static void main(String[] args)
	{
		Class reflectClass=UFOEnemyShip.class;
		
		String className=reflectClass.getName();
		
		System.out.println(className);
		
		int classModifier=reflectClass.getModifiers();
	
		System.out.println(Modifier.isPrivate(classModifier));
		
		Class[] interfaces=reflectClass.getInterfaces();
		
		Class superClass=reflectClass.getSuperclass();
		
		System.out.println(superClass);
		Method[] classMethods=reflectClass.getMethods();
		for(Method m:classMethods)
		{
			System.out.println("Method name "+m.getName());
			if(m.getName().startsWith("get"))
			{
				System.out.println("Getter method");
			}
			else if(m.getName().startsWith("set"))
			{
				System.out.println("Setter method");
			}
			System.out.println("return type "+m.getReturnType());
			
			Class[] parameterType=m.getParameterTypes();
			System.out.println("Parameters");
			
			for(Class p:parameterType)
			{
				System.out.println("Paramerter name "+p.getName());
			}
			System.out.println();
		}
		
		Constructor constructor=null;
		
		Object constructor2=null;
		
		try {
			
			constructor=reflectClass.getConstructor(EnemyShipFactory.class);
			
			constructor2=reflectClass.getConstructor(int.class,String.class)
					.newInstance(12,"RandomString");
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class[] parameterTypes=constructor.getParameterTypes();
		
		for(Class p:parameterTypes)
		{
			System.out.println(p.getName());
		}
		
		UFOEnemyShip newEnemyShip=null;
		
		EnemyShipFactory enemyShipFactory=null;
		
		try {
			
			newEnemyShip=(UFOEnemyShip)constructor.newInstance(enemyShipFactory);
			
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newEnemyShip.setName("XT-1000");
		
		System.out.println("Enemyship name: "+newEnemyShip.getName());
		
		Field privateStringName = null;
		
		UFOEnemyShip enemyShipPrivate = new UFOEnemyShip(enemyShipFactory);
		
		/*
		 * Through reflection we can access the private fields and methods just by their
		 * corresponding names which is done in the try block below. We can access these fields
		 * and methods through the corresponding class that has the hold of them.
		 */
		try {
			String idCodeString = "idCode";
			
			privateStringName = UFOEnemyShip.class.getDeclaredField(idCodeString);
			//To make it accessible as it is private
			privateStringName.setAccessible(true);
			
			String valueOfName = (String)privateStringName.get(enemyShipPrivate);
			
			System.out.println("Private Field Name: "+valueOfName);
			
			String methodName = "getPrivate";
			
			Method privateMethod = UFOEnemyShip.class.getDeclaredMethod(methodName, null);
			//To access the method as it is private first.
			privateMethod.setAccessible(true);
			
			String privateReturnValue = (String)privateMethod.invoke(enemyShipPrivate, null);
			
			System.out.println("Private method return value :"+privateReturnValue);
			
			//If a private method has parameters and if there are more than one of them
			Class[] methodParameters = new Class[]{int.class,String.class};
			
			Object[] params=new Object[]{10,"Random"};
			
			privateMethod = UFOEnemyShip.class.getDeclaredMethod("getOtherPrivate", methodParameters);
			
			privateMethod.setAccessible(true);
			
			privateReturnValue = (String)privateMethod.invoke(enemyShipPrivate, params);
			
			System.out.println("Private method return value with params :"+privateReturnValue);
		
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
